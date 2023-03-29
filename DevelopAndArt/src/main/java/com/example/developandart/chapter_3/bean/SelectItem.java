package com.example.developandart.chapter_3.bean;

public class SelectItem {
    private int index;
    private String channelName;

    public SelectItem(int index, String channelName) {
        this.index = index;
        this.channelName = channelName;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
