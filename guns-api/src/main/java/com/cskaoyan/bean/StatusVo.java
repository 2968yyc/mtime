package com.cskaoyan.bean;

/**
 * @Author: yyc
 * @Date: 2019/6/4 17:04
 */
public class StatusVo extends Vo{

    public StatusVo() {
    }
    public StatusVo(int status,String msg) {
        this.setStatus(status);
        this.setMsg(msg);
    }

    @Override
    public  int getStatus() {
        return super.getStatus();
    }

    @Override
    public  String getMsg() {
        return super.getMsg();
    }
}
