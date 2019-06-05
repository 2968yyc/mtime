package com.stylefeng.guns.rest.common.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 地域信息表
 * </p>
 *
 * @author xf
 * @since 2019-06-04
 */
public class MtimeHallDictT  implements Serializable{
    private Integer halltypeId;
    private String  halltypeName;
    private boolean isActive;
    private String seatAddress;

    public String getSeatAddress() {
        return seatAddress;
    }

    public void setSeatAddress(String seatAddress) {
        this.seatAddress = seatAddress;
    }

    public Integer getHalltypeId() {
        return halltypeId;
    }

    public void setHalltypeId(Integer halltypeId) {
        this.halltypeId = halltypeId;
    }

    public String getHalltypeName() {
        return halltypeName;
    }

    public void setHalltypeName(String halltypeName) {
        this.halltypeName = halltypeName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
