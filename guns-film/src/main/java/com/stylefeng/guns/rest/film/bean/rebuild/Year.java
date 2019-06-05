package com.stylefeng.guns.rest.film.bean.rebuild;

import java.io.Serializable;

/**
 * @Author: Qiu
 * @Date: 2019/6/5 21:01
 */
public class Year implements Serializable {
    private int yearId;
    private String yearName;
    private boolean isActive;

    public Year() {
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getYearId() {
        return yearId;
    }

    public void setYearId(int yearId) {
        this.yearId = yearId;
    }

    public String getYearName() {
        return yearName;
    }

    public void setYearName(String yearName) {
        this.yearName = yearName;
    }

    public Year(int yearId, String yearName, boolean isActive) {
        this.yearId = yearId;
        this.yearName = yearName;
        this.isActive = isActive;
    }
}
