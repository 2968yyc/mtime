package com.stylefeng.guns.rest.common.persistence.vo;

import java.io.Serializable;

/**
 * @Author: xf
 * @Date: 2019/6/4 22:45
 */
public class CinemaReq implements Serializable {
    private String pageSize="12";
    private String nowPage="1";
    private String hallType="99";
    private String districtId="99";
    private String brandId="99";
    private String areaId="99";

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getHallType() {
        return hallType;
    }

    public void setHallType(String hallType) {
        this.hallType = hallType;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getNowPage() {
        return nowPage;
    }

    public void setNowPage(String nowPage) {
        this.nowPage = nowPage;
    }
}
