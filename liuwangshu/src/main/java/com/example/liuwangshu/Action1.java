package com.example.liuwangshu;

import io.reactivex.functions.Action;

/**
 * ClassName:Action1
 * Package:com.example.liuwangshu
 *
 * @date:21-6-15
 * @author:liujianming
 */
public interface Action1<T> extends Action {
    void call(T t);
}
