package com.cskaoyan.bean;

/**
 * @Author: yyc
 * @Date: 2019/6/4 20:27
 */
public class DataVo extends Vo{
    public DataVo() {
    }
    public DataVo(int status,Object data) {
        this.setStatus(status);
        this.setData(data);
    }

    @Override
    public int getStatus() {
        return super.getStatus();
    }

    @Override
    public Object getData() {
        return super.getData();
    }
}
