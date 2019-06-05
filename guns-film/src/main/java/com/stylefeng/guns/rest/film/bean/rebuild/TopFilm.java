package com.stylefeng.guns.rest.film.bean.rebuild;

import com.stylefeng.guns.rest.film.bean.MtimeFilmT;

/**
 * @Author: Qiu
 * @Date: 2019/6/5 17:07
 */
public class TopFilm extends MtimeFilmT {

    private int filmId;
    private String score;


    public TopFilm() {
    }

    public TopFilm(int filmId, String imgAddress, String filmName, String score) {
        this.setFilmId(filmId);
        this.setImgAddress(imgAddress);
        this.setFilmName(filmName);
        this.setScore(score);
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
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
