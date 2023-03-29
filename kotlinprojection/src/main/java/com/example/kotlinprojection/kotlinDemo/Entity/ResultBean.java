package com.example.kotlinprojection.kotlinDemo.Entity;

import java.util.List;

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 * <p>
 * ResultBean
 *
 * @author liujianming
 * @date 2021-12-16
 */
public class ResultBean {
    private int showapi_res_code;
    private String showapi_res_error;
    private String showapi_res_id;
    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public String getShowapi_res_id() {
        return showapi_res_id;
    }

    public void setShowapi_res_id(String showapi_res_id) {
        this.showapi_res_id = showapi_res_id;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        private int ret_code;
        private String ret_message;
        private List<DataBean> data;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public String getRet_message() {
            return ret_message;
        }

        public void setRet_message(String ret_message) {
            this.ret_message = ret_message;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            private String english;
            private String chinese;

            public String getEnglish() {
                return english;
            }

            public void setEnglish(String english) {
                this.english = english;
            }

            public String getChinese() {
                return chinese;
            }

            public void setChinese(String chinese) {
                this.chinese = chinese;
            }
        }
    }
}
