package com.stylefeng.guns.rest.film.bean.rebuild;

import java.io.Serializable;

/**
 * @Author: Qiu
 * @Date: 2019/6/5 20:59
 */
public class Cat implements Serializable {
    private int catId;
    private String catName;
    private boolean isActive;

    public Cat() {
    }

    public Cat(int catId, String catName, boolean isActive) {
        this.catId = catId;
        this.catName = catName;
        this.isActive = isActive;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
