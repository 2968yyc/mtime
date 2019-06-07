package com.cskaoyan.bean.vo.film;

import com.cskaoyan.bean.vo.Vo;

/**
 * @Author: Qiu
 * @Date: 2019/6/5 14:47
 */
public class FilmQueryVo extends Vo {

    public FilmQueryVo() {
    }

    public FilmQueryVo(int status, String imgPre, Integer nowPage, int totalPage, Object data) {
        this.setStatus(status);
        this.setImgPre(imgPre);
        this.setData(data);
        this.setNowPage(nowPage + "");
        this.setTotalPage(totalPage + "");
    }

    @Override
    public int getStatus() {
        return super.getStatus();
    }

    @Override
    public Object getData(){
        return super.getData();
    }

    @Override
    public String getImgPre(){
        return super.getImgPre();
    }

    @Override
    public Integer getNowPage() {
        return super.getNowPage();
    }

    @Override
    public Integer getTotalPage() {
        return super.getTotalPage();
    }

}
