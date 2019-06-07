package com.stylefeng.guns.rest.modular.auth.controller.dto;

/**
 * @Author: xf
 * @Date: 2019/6/4 22:51
 */
public class CinemaResp {
    private String  status="0";
    private String noePage="1";
    private String totalPage="5";
    private Object data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNoePage() {
        return noePage;
    }

    public void setNoePage(String noePage) {
        this.noePage = noePage;
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
