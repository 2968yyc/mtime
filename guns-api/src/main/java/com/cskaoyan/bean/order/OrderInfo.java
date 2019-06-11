package com.cskaoyan.bean.order;

import java.io.Serializable;

/**
 * @Author: yyc
 * @Date: 2019/6/9 22:59
 */
public class OrderInfo implements Serializable {
    private Integer cinemaId;
    private Integer filmId;
    private Integer price;

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
