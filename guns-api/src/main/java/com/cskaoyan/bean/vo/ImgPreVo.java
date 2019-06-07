package com.cskaoyan.bean.vo;

/**
 * @Author:ZCH
 * @Date:2019/6/6 21:58
 */
public class ImgPreVo extends Vo{

    public ImgPreVo() {
    }

    public ImgPreVo(int status,Object data, String imgPre) {
        this.setStatus(status);
        this.setData(data);
        this.setImgPre(imgPre);
    }

    @Override
    public String getImgPre() {
        return super.getImgPre();
    }

    @Override
    public void setImgPre(String imgPre) {
        super.setImgPre(imgPre);
    }

    @Override
    public int getStatus() {
        return super.getStatus();
    }

    @Override
    public void setStatus(int status) {
        super.setStatus(status);
    }

    @Override
    public Object getData() {
        return super.getData();
    }

    @Override
    public void setData(Object data) {
        super.setData(data);
    }
}
