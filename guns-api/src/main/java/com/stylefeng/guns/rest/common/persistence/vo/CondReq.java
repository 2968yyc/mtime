package com.stylefeng.guns.rest.common.persistence.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/6/5 17:41
 */
public class CondReq implements Serializable {
    private List<Integer> brandId;
    private List<Integer> areaId;
    private List<Integer> hallType;

    public CondReq() {
    }

    public CondReq(List<Integer> brandId, List<Integer> areaId, List<Integer> hallType) {
        this.brandId = brandId;
        this.areaId = areaId;
        this.hallType = hallType;
    }

    public List<Integer> getBrandId() {
        return brandId;
    }

    public void setBrandId(List<Integer> brandId) {
        this.brandId = brandId;
    }

    public List<Integer> getAreaId() {
        return areaId;
    }

    public void setAreaId(List<Integer> areaId) {
        this.areaId = areaId;
    }

    public List<Integer> getHallType() {
        return hallType;
    }

    public void setHallType(List<Integer> hallType) {
        this.hallType = hallType;
    }
}
