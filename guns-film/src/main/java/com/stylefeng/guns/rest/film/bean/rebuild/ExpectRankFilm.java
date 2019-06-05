package com.stylefeng.guns.rest.film.bean.rebuild;

import com.stylefeng.guns.rest.film.bean.MtimeFilmT;

/**
 * @Author: Qiu
 * @Date: 2019/6/5 17:05
 */
public class ExpectRankFilm extends MtimeFilmT {

    private int filmId;
    private int expectNum;


    public ExpectRankFilm() {
    }

    public ExpectRankFilm(int filmId, String imgAddress, String filmName, int expectNum) {
        this.setFilmId(filmId);
        this.setImgAddress(imgAddress);
        this.setFilmName(filmName);
        this.setExpectNum(expectNum);
    }

    public int getExpectNum() {
        return expectNum;
    }

    public void setExpectNum(int expectNum) {
        this.expectNum = expectNum;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
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
