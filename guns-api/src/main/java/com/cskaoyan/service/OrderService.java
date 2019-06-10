package com.cskaoyan.service;

import com.cskaoyan.bean.orders.OrderInfoVo;

import java.util.List;

/**
 * @Author:ZCH
 * @Date:2019/6/8 22:43
 */
public interface OrderService {

    boolean isTrueSeats(int fieldId, String seats);

    boolean isNoSoldSeats(int fieldId, String seats);

    OrderInfoVo buyTickets(int fieldId, String soldSeats, String seatsName, int userId);

    List<OrderInfoVo> getOrdersByUserId(int userId);

    String getSoldSeatsByFieldId(int fieldId);
}
