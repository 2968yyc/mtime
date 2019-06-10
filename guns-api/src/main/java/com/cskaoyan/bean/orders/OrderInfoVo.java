package com.cskaoyan.bean.orders;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:ZCH
 * @Date:2019/6/8 22:34
 */
public class OrderInfoVo implements Serializable {
    private String orderId;
    private String filmName;
    private Date fieldTime;
    private String cinemaName;
    private String seatsName;
    private Double orderPrice;
    private Date orderTimestamp;

    public OrderInfoVo() {
    }

    public OrderInfoVo(String orderId, String filmName, Date fieldTime, String cinemaName, String seatsName, Double orderPrice, Date orderTimestamp) {
        this.orderId = orderId;
        this.filmName = filmName;
        this.fieldTime = fieldTime;
        this.cinemaName = cinemaName;
        this.seatsName = seatsName;
        this.orderPrice = orderPrice;
        this.orderTimestamp = orderTimestamp;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Date getFieldTime() {
        return fieldTime;
    }

    public void setFieldTime(Date fieldTime) {
        this.fieldTime = fieldTime;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getSeatsName() {
        return seatsName;
    }

    public void setSeatsName(String seatsName) {
        this.seatsName = seatsName;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getOrderTimestamp() {
        return orderTimestamp;
    }

    public void setOrderTimestamp(Date orderTimestamp) {
        this.orderTimestamp = orderTimestamp;
    }

    @Override
    public String toString() {
        return "OrderInfoVo{" +
                "orderId='" + orderId + '\'' +
                ", filmName='" + filmName + '\'' +
                ", fieldTime=" + fieldTime +
                ", cinemaName='" + cinemaName + '\'' +
                ", seatsName='" + seatsName + '\'' +
                ", orderPrice=" + orderPrice +
                ", orderTimestamp=" + orderTimestamp +
                '}';
    }
}
