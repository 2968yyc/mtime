package com.stylefeng.guns.rest.modular.auth.controller.dto;

/**
 * @Author: xf
 * @Date: 2019/6/4 22:45
 */
public class CinemaReq {
    private String brandId="99";
    private String hallType="99";
    private String districtId="99";
    private String pageSize="12";
    private String nowPage="1";

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
