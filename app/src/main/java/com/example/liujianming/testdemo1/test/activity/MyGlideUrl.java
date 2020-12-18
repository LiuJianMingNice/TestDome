package com.example.liujianming.testdemo1.test.activity;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;

import java.net.URL;

public class MyGlideUrl extends GlideUrl {

    private String mUrl;

    public MyGlideUrl(URL url) {
        super(url);
    }

    public MyGlideUrl(String url) {
        super(url);
        mUrl = url;
    }

    public MyGlideUrl(URL url, Headers headers) {
        super(url, headers);
    }

    public MyGlideUrl(String url, Headers headers) {
        super(url, headers);
    }


}
