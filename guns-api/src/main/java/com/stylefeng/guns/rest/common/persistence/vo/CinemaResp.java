package com.stylefeng.guns.rest.common.persistence.vo;

import com.cskaoyan.bean.vo.Vo;

/**
 * @Author: xf
 * @Date: 2019/6/4 22:51
 */
public class CinemaResp extends Vo {
    public CinemaResp() {
    }

    public CinemaResp(int status, Integer nowPage, int totalPage, Object data) {
        this.setStatus(status);
        this.setData(data);
        this.setNowPage(nowPage);
        this.setTotalPage(totalPage);
    }

    @Override
    public int getStatus() {
        return super.getStatus();
    }


    @Override
    protected int getNowPage() {
        return super.getNowPage();
    }

    @Override
    protected int getTotalPage() {
        return super.getTotalPage();
    }

    @Override
    public Object getData() {
        return super.getData();
    }

}
