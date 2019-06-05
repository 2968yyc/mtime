package com.cskaoyan.bean;

import java.io.Serializable;

/**
 * @Author: yyc
 * @Date: 2019/6/4 20:30
 */
public class Vo implements Serializable {
    private int status;
    private String msg;
    private Object data;

    protected int getStatus() {
        return status;
    }

    protected void setStatus(int status) {
        this.status = status;
    }

    protected String getMsg() {
        return msg;
    }

    protected void setMsg(String msg) {
        this.msg = msg;
    }

    protected Object getData() {
        return data;
    }

    protected void setData(Object data) {
        this.data = data;
    }
}
