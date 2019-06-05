package com.stylefeng.guns.rest.film.bean.rebuild;

import com.stylefeng.guns.rest.film.bean.MtimeFilmT;

/**
 * @Author: Qiu
 * @Date: 2019/6/5 17:02
 */
public class BoxRankFilm extends MtimeFilmT {
    private int filmId;
    private int boxNum;


    public BoxRankFilm() {
    }

    public BoxRankFilm(int filmId, String imgAddress, String filmName, int boxNum) {
        this.setFilmId(filmId);
        this.setImgAddress(imgAddress);
        this.setFilmName(filmName);
        this.setBoxNum(boxNum);
    }

    public int getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(int boxNum) {
        this.boxNum = boxNum;
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
