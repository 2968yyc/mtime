package com.cskaoyan.bean.vo.film;

import com.cskaoyan.bean.vo.Vo;

import java.lang.Override;

/**
 * @Author: Qiu
 * @Date: 2019/6/5 14:36
 */
public class FilmIndexVo extends Vo {

    public FilmIndexVo() {}

    public FilmIndexVo(String imgPre, int status,Object data){
        this.setImgPre(imgPre);
        this.setStatus(status);
        this.setData(data);
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
}
