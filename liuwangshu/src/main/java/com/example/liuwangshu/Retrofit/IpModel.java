package com.example.liuwangshu.Retrofit;

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 * <p>
 * IpModel
 *
 * @author liujianming
 * @date 2022-08-17
 */
public class IpModel {
    private int code;
    private IpData data;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return this.code;
    }
    public void setData(IpData data) {
        this.data = data;
    }
    public IpData getData() {
        return this.data;
    }
}
