package com.stylefeng.guns.rest.common.persistence.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/6/5 17:41
 */
public class CondReq implements Serializable {
    private String brandId="99";
    private String areaId="99";
    private String hallType="99";

    public CondReq() {
    }

    public CondReq(String brandId, String areaId, String hallType) {
        this.brandId = brandId;
        this.areaId = areaId;
        this.hallType = hallType;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getHallType() {
        return hallType;
    }

    public void setHallType(String hallType) {
        this.hallType = hallType;
    }
}
