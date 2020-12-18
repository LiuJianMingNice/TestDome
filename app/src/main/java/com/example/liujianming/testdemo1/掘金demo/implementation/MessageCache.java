package com.example.liujianming.testdemo1.掘金demo.implementation;

import com.example.liujianming.testdemo1.掘金demo.bean.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import androidx.annotation.NonNull;

public class MessageCache {

    private static final MessageCache instance = new MessageCache();

    //缓存池最多缓存多少个最近会话消息
    public static final int SESSION_MAX_NUM = 50;

    //缓存池每个最近会话消息最多缓存多少个消息体
    public static final int MESSAGE_MAX_NUM = 20;

    //LRU缓存容器
    private CustomLRUCache<String, Map<Long, Message>> cache = new CustomLRUCache<>(SESSION_MAX_NUM);

    //私有化构造函数
    private MessageCache() {

    }

    //获取单例
    public static MessageCache getInstance() {
        return instance;
    }

    //获取数据
    public List<Message> getData(@NonNull String sessionId) {
        Map<Long, Message> messageMap = cache.get(sessionId);
        if (messageMap != null) {
            List<Message> messages = new ArrayList<>(messageMap.values());
            sort(messages);
            return messages;
        }
        return null;
    }

    //设置新数据（将清理旧的缓存
    public void setNewData(@NonNull String sessionId, @NonNull List<Message> messages) {
        cache.remove(sessionId);
        addData(sessionId, messages);
    }

    //添加数据
    public void addData(@NonNull String sessionId, @NonNull Message message) {
        addData(sessionId, Collections.singletonList(message));
    }

    //添加数据
    public void addData(@NonNull String sessionId, @NonNull List<Message> messages) {
        // 边界值处理
        if (messages == null || messages.isEmpty()) {
            return;
        }

        Map<Long, Message> messageMap = cache.get(sessionId);
        if (messageMap == null) {
            // 新添加缓存容器
            messageMap = new ConcurrentHashMap<>(MESSAGE_MAX_NUM);
            cache.put(sessionId, messageMap);
        }

        // 新消息超过最大数量，直接清空旧数据、截取集合
        int outSize = messages.size() - MESSAGE_MAX_NUM;
        if (outSize > 0) {
            messageMap.clear();
            // 消息时间从小到大排序，这里从集合尾部截取最新MESSAGE_MAX_NUM条
            messages = messages.subList(outSize, messages.size());
        }

        // 新旧总消息超过最大数量，整体移动清除旧数据
        outSize = (messageMap.size() + messages.size()) - MESSAGE_MAX_NUM;
        if (outSize > 0) {
            List<Message> oldMessages = new ArrayList<>(messageMap.values());
            sort(oldMessages);
            for (int i = 0; i < outSize; i++) {
                Message oldMessage = oldMessages.get(i);
                messageMap.remove(oldMessage.messageId);
            }
        }

        // 新存入缓存
        for (Message message : messages) {
            messageMap.put(message.messageId, message);
        }
    }

    //移除会话
    public void remove(@NonNull String seesionId) {
        cache.remove(seesionId);
    }

    //移除某条会话的某条消息
    public void remove(@NonNull String sessionId, long messageId) {
        if (cache.containsKey(sessionId)) {
            Map<Long, Message> messageMap = cache.get(sessionId);
            if (messageMap != null && !messageMap.isEmpty()) {
                messageMap.remove(messageId);
            }
        }
    }

    //判空
    public boolean isEmpty() {
        return cache.isEmpty();
    }

    //是否包含会话
    public boolean containKey(@NonNull String sessionId) {
        return cache.containsKey(sessionId);
    }

    //是否包含会话的某条消息
    public boolean containsKey(@NonNull String sessionId, long messageId) {
        if (cache.containsKey(sessionId)) {
            Map<Long, Message> messageMap = cache.get(sessionId);
            if (messageMap != null && !messageMap.isEmpty()) {
                return messageMap.containsKey(messageId);
            }
        }
        return false;
    }

    //清空缓存
    public void clear() {
        cache.clear();
    }

    //按时间戳升序排序
    private void sort(List<Message> messages) {
        Collections.sort(messages, (o1, o2) -> {
            long diff = o1.timestamp - o2.timestamp;
            return diff > 0 ? 1 : diff == 0 ? 0 : -1;
        });
    }
}
