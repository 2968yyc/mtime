package com.cskaoyan.bean;

import com.cskaoyan.bean.vo.Vo;

/**
 * @Author : zjf
 * @Date : 2019/6/5 下午 05:58
 */
public class AllVo extends Vo {
    @Override
    protected int getStatus() {
        return super.getStatus();
    }

    @Override
    protected void setStatus(int status) {
        super.setStatus(status);
    }

    @Override
    protected String getMsg() {
        return super.getMsg();
    }

    @Override
    protected void setMsg(String msg) {
        super.setMsg(msg);
    }

    @Override
    protected Object getData() {
        return super.getData();
    }

    @Override
    protected void setData(Object data) {
        super.setData(data);
    }

    public AllVo() {
    }

    public AllVo(int status,String msg,Object data) {
        this.setStatus(status);
        this.setMsg(msg);
        this.setData(data);
    }
}
