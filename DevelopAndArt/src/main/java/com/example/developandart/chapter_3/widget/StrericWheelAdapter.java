/*
 *  Copyright 2010 Yuri Kanivets
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.example.developandart.chapter_3.widget;


import java.util.List;

/**
 * Numeric Wheel adapter.
 * 数字wheelview的adapter
 */
public class StrericWheelAdapter implements WheelAdapter {

    /**
     * The default min value
     */
    private List<String> strContents;

    /**
     * @param strContents
     */
    public StrericWheelAdapter(List<String> strContents) {
        this.strContents = strContents;
    }


    public List<String> getStrContents() {
        return strContents;
    }


    public void setStrContents(List<String> strContents) {
        this.strContents = strContents;
    }


    public String getItem(int index) {
        if (index >= 0 && index < getItemsCount()) {
            return strContents.get(index);
        }
        return null;
    }

    public int getItemsCount() {
        return strContents.size();
    }

    /**
     * 璁剧疆鏈�ぇ鐨勫搴�
     */
    public int getMaximumLength() {
        int maxLen = 5;
        return maxLen;
    }
}
