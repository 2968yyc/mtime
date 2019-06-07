package com.stylefeng.guns.rest.film.bean.rebuild;

import java.io.Serializable;

/**
 * @Author: Qiu
 * @Date: 2019/6/5 21:02
 */
public class Source implements Serializable {
    private int sourceId;
    private String sourceName;
    private boolean isActive;


    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Source(int sourceId, String sourceName, boolean isActive) {
        this.sourceId = sourceId;
        this.sourceName = sourceName;
        this.isActive = isActive;
    }

    public Source() {
    }
}
