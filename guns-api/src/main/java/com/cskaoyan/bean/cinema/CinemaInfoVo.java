package com.cskaoyan.bean.cinema;


import java.io.Serializable;

/**
 * @Author:ZCH
 * @Date:2019/6/4 23:16
 */
public class CinemaInfoVo implements Serializable {
    private String cinemaId;
    private String imgUrl;
    private String cinemaName;
    private String cinemaAdress;
    private String cinemaPhone;

    public CinemaInfoVo() {
    }

    public CinemaInfoVo(String cinemaId, String imgUrl, String cinemaName, String cinemaAdress, String cinemaPhone) {
        this.cinemaId = cinemaId;
        this.imgUrl = imgUrl;
        this.cinemaName = cinemaName;
        this.cinemaAdress = cinemaAdress;
        this.cinemaPhone = cinemaPhone;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaAdress() {
        return cinemaAdress;
    }

    public void setCinemaAdress(String cinemaAdress) {
        this.cinemaAdress = cinemaAdress;
    }

    public String getCinemaPhone() {
        return cinemaPhone;
    }

    public void setCinemaPhone(String cinemaPhone) {
        this.cinemaPhone = cinemaPhone;
    }

    @Override
    public String toString() {
        return "CinemaInfoVo{" +
                "cinemaId='" + cinemaId + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                ", cinemaAdress='" + cinemaAdress + '\'' +
                ", cinemaPhone='" + cinemaPhone + '\'' +
                '}';
    }
}
