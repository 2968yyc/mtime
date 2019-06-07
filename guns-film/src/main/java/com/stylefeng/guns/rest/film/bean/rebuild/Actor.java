package com.stylefeng.guns.rest.film.bean.rebuild;

import java.io.Serializable;

/**
 * @Author: xf
 * @Date: 2019/6/7 9:39
 */
public class Actor implements Serializable {
    private int uuid;
    private String actorName;
    private String actorImg;
    private String roleName;

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorImg() {
        return actorImg;
    }

    public void setActorImg(String actorImg) {
        this.actorImg = actorImg;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
