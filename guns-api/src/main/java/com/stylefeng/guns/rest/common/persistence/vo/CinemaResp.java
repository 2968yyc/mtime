package com.stylefeng.guns.rest.common.persistence.vo;

/**
 * @Author: xf
 * @Date: 2019/6/4 22:51
 */
public class CinemaResp {
    private String  status="0";
    private String nowPage="1";
    private String totalPage="5";
    private Object data;

    public String getStatus() {
        return status;
    }

    public CinemaResp(String nowPage, String totalPage, Object data) {
        this.nowPage = nowPage;
        this.totalPage = totalPage;
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNowPage() {
        return nowPage;
    }

    public void setNowPage(String nowPage) {
        this.nowPage = nowPage;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
