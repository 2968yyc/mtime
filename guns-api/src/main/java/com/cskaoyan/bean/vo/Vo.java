package com.cskaoyan.bean.vo;

import java.io.Serializable;

/**
 * @Author: yyc
 * @Date: 2019/6/4 20:30
 */
public class Vo implements Serializable {
    private int status;
    private String msg;
    private Object data;
    private String imgPre;
    private Integer nowPage;
    private Integer totalPage;

    protected Integer getNowPage() {
        return nowPage;
    }

    protected void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    protected Integer getTotalPage() {
        return totalPage;
    }

    protected void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    protected String getImgPre() {
        return imgPre;
    }

    protected void setImgPre(String imgPre) {
        this.imgPre = imgPre;
    }

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
