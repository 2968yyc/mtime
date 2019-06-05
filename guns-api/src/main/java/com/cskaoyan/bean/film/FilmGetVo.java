package com.cskaoyan.bean.film;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/6/5 21:55
 */
public class FilmGetVo implements Serializable {
    private Integer showType =1;
    private Integer sortId =1;
    private Integer catId =99;
    private Integer sourceId =99;
    private Integer yearId = 99;
    private Integer nowPage =1;
    private Integer pageSize = 18;

    public FilmGetVo() {
    }

    public FilmGetVo(Integer showType, Integer sortId, Integer catId, Integer sourceId, Integer yearId, Integer nowPage, Integer pageSize) {
        this.showType = showType;
        this.sortId = sortId;
        this.catId = catId;
        this.sourceId = sourceId;
        this.yearId = yearId;
        this.nowPage = nowPage;
        this.pageSize = pageSize;
    }

    public Integer getShowType() {
        return showType;
    }

    public void setShowType(Integer showType) {
        this.showType = showType;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
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

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
