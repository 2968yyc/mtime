package com.stylefeng.guns.rest.common.persistence.vo;

import com.cskaoyan.bean.Vo;

/**
 * @Author: xf
 * @Date: 2019/6/4 22:51
 */
public class CinemaResp extends Vo {
    private int nowPage=1;
    private int totalPage=5;

    public CinemaResp() {
    }

    public CinemaResp(int nowPage, int totalPage, Object data) {
        this.nowPage = nowPage;
        this.totalPage = totalPage;
        this.setData(data);
    }

    @Override
    public int getStatus() {
        return super.getStatus();
    }


    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public Object getData() {
        return super.getData();
    }

}
