package com.stylefeng.guns.rest.film.bean.rebuild;

import com.stylefeng.guns.rest.film.bean.MtimeFilmT;

/**
 * @Author: Qiu
 * @Date: 2019/6/5 15:16
 */
public class HotFilm extends MtimeFilmT {
    private int filmId;


    public HotFilm() {
    }

    public HotFilm(int filmId, int filmType, String imgAddress, String filmName, String filmScore) {
        this.setFilmId(filmId);
        this.setFilmType(filmType);
        this.setImgAddress(imgAddress);
        this.setFilmName(filmName);
        this.setFilmScore(filmScore);
    }


    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
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

    @Override
    public String getFilmScore() {
        return super.getFilmScore();
    }

}
