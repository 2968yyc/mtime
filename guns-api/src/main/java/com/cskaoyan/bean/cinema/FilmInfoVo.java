package com.cskaoyan.bean.cinema;

import java.util.List;

/**
 * @Author:ZCH
 * @Date:2019/6/4 23:21
 */
public class FilmInfoVo {
    private String filmId;
    private String filmName;
    private String filmLength;
    private String filmType;
    private String filmCats;
    private String actors;
    private String imgAddress;
    private List filmFields;

    public FilmInfoVo() {
    }

    public FilmInfoVo(String filmId, String filmName, String filmLength, String filmType, String filmCats, String actors, String imgAddress, List filmFields) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.filmLength = filmLength;
        this.filmType = filmType;
        this.filmCats = filmCats;
        this.actors = actors;
        this.imgAddress = imgAddress;
        this.filmFields = filmFields;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(String filmLength) {
        this.filmLength = filmLength;
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }

    public String getFilmCats() {
        return filmCats;
    }

    public void setFilmCats(String filmCats) {
        this.filmCats = filmCats;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public List getFilmFields() {
        return filmFields;
    }

    public void setFilmFields(List filmFields) {
        this.filmFields = filmFields;
    }

    @Override
    public String toString() {
        return "FilmInfoVo{" +
                "filmId='" + filmId + '\'' +
                ", filmName='" + filmName + '\'' +
                ", filmLength='" + filmLength + '\'' +
                ", filmType='" + filmType + '\'' +
                ", filmCats='" + filmCats + '\'' +
                ", actors='" + actors + '\'' +
                ", imgAddress='" + imgAddress + '\'' +
                ", filmFields=" + filmFields +
                '}';
    }
}
