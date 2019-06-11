package com.cskaoyan.bean.film;

import java.io.Serializable;

/**
 * @Author: Qiu
 * @Date: 2019/6/7 22:18
 */
public class FilmConditionVo implements Serializable {
    private Integer catId=99;
    private Integer sourceId=99;
    private Integer yearId=99;

    public FilmConditionVo() {
    }

    public FilmConditionVo(Integer catId, Integer sourceId, Integer yearId) {
        this.catId = catId;
        this.sourceId = sourceId;
        this.yearId = yearId;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getYearId() {
        return yearId;
    }

    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }
}
