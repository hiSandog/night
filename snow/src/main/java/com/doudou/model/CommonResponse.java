package com.doudou.model;

/**
 * Created by chenjiaming on 2017/7/9.
 */
public class CommonResponse<T> {

    private T body;
    private int code;
    private String msg;

    public CommonResponse() {}

    public CommonResponse(T body) {
        this.body = body;
        if (body != null) {
            code = 200;
            msg = "success";
        } else {
            code = 300;
            msg = "fail";
        }
    }

    public CommonResponse(boolean isSuccess) {
        if (isSuccess) {
            code = 200;
            msg = "success";
        } else {
            code = 300;
            msg = "fail";
        }
    }

    public CommonResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResponse(T body, int code, String msg) {
        this.body = body;
        this.code = code;
        this.msg = msg;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}