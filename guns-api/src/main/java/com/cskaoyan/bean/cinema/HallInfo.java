package com.cskaoyan.bean.cinema;

import java.io.Serializable;

/**
 * @Author:ZCH
 * @Date:2019/6/6 9:11
 */
public class HallInfo implements Serializable {
    private int hallFieldId;
    private String hallName;
    private Double price;
    private String seatFile;
    private String soldSeats;

    public HallInfo() {
    }

    public HallInfo(int hallFieldId, String hallName, Double price, String seatFile, String soldSeats) {
        this.hallFieldId = hallFieldId;
        this.hallName = hallName;
        this.price = price;
        this.seatFile = seatFile;
        this.soldSeats = soldSeats;
    }

    public int getHallFieldId() {
        return hallFieldId;
    }

    public void setHallFieldId(int hallFieldId) {
        this.hallFieldId = hallFieldId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSeatFile() {
        return seatFile;
    }

    public void setSeatFile(String seatFile) {
        this.seatFile = seatFile;
    }

    public String getSoldSeats() {
        return soldSeats;
    }

    public void setSoldSeats(String soldSeats) {
        this.soldSeats = soldSeats;
    }

    @Override
    public String toString() {
        return "HallInfo{" +
                "hallFieldId=" + hallFieldId +
                ", hallName='" + hallName + '\'' +
                ", price=" + price +
                ", seatFile='" + seatFile + '\'' +
                ", soldSeats='" + soldSeats + '\'' +
                '}';
    }
}
