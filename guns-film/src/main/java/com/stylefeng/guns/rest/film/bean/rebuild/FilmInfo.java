package com.stylefeng.guns.rest.film.bean.rebuild;

import com.stylefeng.guns.rest.film.bean.MtimeFilmT;

import java.io.Serializable;

/**
 * @Author: Qiu
 * @Date: 2019/6/5 22:34
 */
public class FilmInfo implements Serializable {
    private int filmId;
    private int filmType;
    private String imgAddress;
    private String filmName;
    private String filmScore;

    public FilmInfo(int filmId, int filmType, String imgAddress, String filmName, String filmScore) {
        this.filmId = filmId;
        this.filmType = filmType;
        this.imgAddress = imgAddress;
        this.filmName = filmName;
        this.filmScore = filmScore;
    }

    public FilmInfo() {
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getFilmType() {
        return filmType;
    }

    public void setFilmType(int filmType) {
        this.filmType = filmType;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmScore() {
        return filmScore;
    }

    public void setFilmScore(String filmScore) {
        this.filmScore = filmScore;
    }
}
