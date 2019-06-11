package com.stylefeng.guns.rest.film.bean.rebuild;

import com.stylefeng.guns.rest.film.bean.MtimeFilmT;

import java.util.Date;

/**
 * @Author: Qiu
 * @Date: 2019/6/5 16:27
 */
public class SoonFilm extends MtimeFilmT {
    private Integer filmId;
    private Integer expectNum;
    private Date showTime;

    public SoonFilm(Integer filmId, Integer filmType, String imgAddress, String filmName, Integer expectNum, Date showTime) {
        this.setFilmId(filmId);
        this.setFilmType(filmType);
        this.setImgAddress(imgAddress);
        this.setFilmName(filmName);
        this.setExpectNum(expectNum);
        this.setShowTime(showTime);
    }

    public SoonFilm() {
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public Integer getExpectNum() {
        return expectNum;
    }

    public void setExpectNum(int expectNum) {
        this.expectNum = expectNum;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    @Override
    public Integer getFilmType() {
        return super.getFilmType();
    }

    @Override
    public String getImgAddress() {
        return super.getImgAddress();
    }

    @Override
    public String getFilmName() {
        return super.getFilmName();
    }


}
