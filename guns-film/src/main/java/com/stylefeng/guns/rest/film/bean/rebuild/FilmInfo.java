package com.stylefeng.guns.rest.film.bean.rebuild;

import com.stylefeng.guns.rest.film.bean.MtimeFilmT;

/**
 * @Author: Qiu
 * @Date: 2019/6/5 22:34
 */
public class FilmInfo extends MtimeFilmT {
     private int filmId;

    public FilmInfo() {
    }

    public FilmInfo(int filmId,int filmType,String imgAddress,String filmName,String filmScore) {
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
    public Integer getFilmType(){
        return super.getFilmType();
    }
    @Override
    public String getFilmName(){
        return super.getFilmName();
    }
    @Override
    public String getFilmScore(){
        return super.getFilmScore();
    }


}
