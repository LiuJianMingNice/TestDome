package com.example.liuwangshu.other.event;

/**
 * ClassName:MessageEvent
 * Package:com.example.liuwangshu.other.event
 *
 * @date:21-5-24
 * @author:liujianming
 */
public class MessageEvent {
    private String message;
    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
