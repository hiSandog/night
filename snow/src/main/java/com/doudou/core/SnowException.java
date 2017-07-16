package com.doudou.core;

/**
 * Created by chenjiaming on 2017/7/9.
 */
public class SnowException extends RuntimeException {

    private int code;
    private String msg;

    public SnowException() {}

    public SnowException(int code, String msg) {
        this.code = code;
        this.msg = msg;
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
