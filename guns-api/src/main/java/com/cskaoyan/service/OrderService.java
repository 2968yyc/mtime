package com.cskaoyan.service;

import com.cskaoyan.bean.order.OrderVo;
import com.cskaoyan.bean.vo.Vo;

import java.util.List;

/**
 * @Author: yyc
 * @Date: 2019/6/8 18:21
 */
public interface OrderService {

    //验证传入的座位信息是否有效
    boolean isTrueSeats(Integer fieldId, String seats);

    //验证传入座位信息是否已经售出
    boolean isAllSeatsUnsold(Integer fieldId, String seats);

    //发起订单
    OrderVo addOrder(Integer fieldId, String soldSeats, String seatsName, String username);

    //获取当前人的订单信息
    List<OrderVo> getOrderByUsername(String username);
    //根据fieldId获取已经售出的座位编号
    String getSoldSeatsByFieldId(Integer fieldId);

}
