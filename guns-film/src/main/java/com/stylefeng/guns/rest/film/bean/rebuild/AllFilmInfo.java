package com.stylefeng.guns.rest.film.bean.rebuild;

import com.stylefeng.guns.rest.film.bean.MtimeActorT;

import java.util.Date;
import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/6/6 16:35
 */
public class AllFilmInfo {
    //film表
    private String filmName;
    private String  imgAddress;
    private int totalBox;
    private int filmSourceId;
    private int filmAreaID;
    private Date filmTime;
    private String cats;
    //Cat表
    private List<String> filmCats;
    //source表
    private String filmSource;
    private String filmArea;

    //film_info表
    private String filmId;
    private String filmEnName;
    private String score;
    private int scoreNum;
    private int filmLength;
    private String biography;
    private String imgVo;
    private int directorId;
    //actor表
    private MtimeActorT director;
    private List<MtimeActorT> actors;

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public int getTotalBox() {
        return totalBox;
    }

    public void setTotalBox(int totalBox) {
        this.totalBox = totalBox;
    }

    public int getFilmSourceId() {
        return filmSourceId;
    }

    public void setFilmSourceId(int filmSourceId) {
        this.filmSourceId = filmSourceId;
    }

    public int getFilmAreaID() {
        return filmAreaID;
    }

    public void setFilmAreaID(int filmAreaID) {
        this.filmAreaID = filmAreaID;
    }

    public Date getFilmTime() {
        return filmTime;
    }

    public void setFilmTime(Date filmTime) {
        this.filmTime = filmTime;
    }

    public String getCats() {
        return cats;
    }

    public void setCats(String cats) {
        this.cats = cats;
    }

    public List<String> getFilmCats() {
        return filmCats;
    }

    public void setFilmCats(List<String> filmCats) {
        this.filmCats = filmCats;
    }

    public String getFilmSource() {
        return filmSource;
    }

    public void setFilmSource(String filmSource) {
        this.filmSource = filmSource;
    }

    public String getFilmArea() {
        return filmArea;
    }

    public void setFilmArea(String filmArea) {
        this.filmArea = filmArea;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getFilmEnName() {
        return filmEnName;
    }

    public void setFilmEnName(String filmEnName) {
        this.filmEnName = filmEnName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(int scoreNum) {
        this.scoreNum = scoreNum;
    }

    public int getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(int filmLength) {
        this.filmLength = filmLength;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getImgVo() {
        return imgVo;
    }

    public void setImgVo(String imgVo) {
        this.imgVo = imgVo;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public MtimeActorT getDirector() {
        return director;
    }

    public void setDirector(MtimeActorT director) {
        this.director = director;
    }

    public List<MtimeActorT> getActors() {
        return actors;
    }

    public void setActors(List<MtimeActorT> actors) {
        this.actors = actors;
    }
}
