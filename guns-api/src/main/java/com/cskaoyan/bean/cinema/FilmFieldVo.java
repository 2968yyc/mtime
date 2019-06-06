package com.cskaoyan.bean.cinema;

import java.io.Serializable;

/**
 * @Author:ZCH
 * @Date:2019/6/4 23:24
 */
public class FilmFieldVo implements Serializable {
    private String fieldId;
    private String beginTime;
    private String endTime;
    private String language;
    private String hallName;
    private String price;

    public FilmFieldVo() {
    }

    public FilmFieldVo(String fieldId, String beginTime, String endTime, String language, String hallName, String price) {
        this.fieldId = fieldId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.language = language;
        this.hallName = hallName;
        this.price = price;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FilmFieldVo{" +
                "fieldId='" + fieldId + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", language='" + language + '\'' +
                ", hallName='" + hallName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
