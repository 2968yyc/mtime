package com.stylefeng.guns.rest.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.cskaoyan.AliveUser;
import com.cskaoyan.bean.AllVo;
import com.cskaoyan.bean.order.OrderVo;
import com.cskaoyan.bean.vo.DataVo;
import com.cskaoyan.bean.vo.StatusVo;
import com.cskaoyan.bean.vo.Vo;
import com.cskaoyan.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: yyc
 * @Date: 2019/6/8 18:32
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Reference(check = false)
    private OrderService orderService;

    @RequestMapping(value = "buyTickets",method = RequestMethod.POST)
    public Vo buyTickets(Integer fieldId,String soldSeats,String seatsName){
        try {
            //验证传入的座位信息是否有效
            boolean trueSeats = orderService.isTrueSeats(fieldId, soldSeats);
            //验证传入座位信息是否已经售出
            boolean allSeatsUnsold = orderService.isAllSeatsUnsold(fieldId, soldSeats);
            //发起订单,需要登录人信息
            if (trueSeats && allSeatsUnsold) {
                String username = AliveUser.getThread();
                OrderVo orderVo = orderService.addOrder(fieldId, soldSeats, seatsName, username);
                return new DataVo(0,  orderVo);
            }

            return new StatusVo(1, "该订单不存在");
        }catch (Exception e){
            e.printStackTrace();
            return new StatusVo(999,"系统出现异常，请联系管理员");
        }

    }

    @RequestMapping(value = "getOrderInfo",method = RequestMethod.POST)
    public Vo getOrderInfo(@RequestParam(value = "nowPage",required = false,defaultValue = "1")Integer nowPage,
                           @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize)
    {
        //获取当前登录人信息
        String username = AliveUser.getThread();
        if (username==null || username.trim().length()==0){
            return new StatusVo(999,"系统出现异常，请联系管理员");
        }
        //获取当前人的订单信息
        List<OrderVo> orderByUsername = orderService.getOrderByUsername(username,nowPage,pageSize);
        if (orderByUsername==null || orderByUsername.size()==0){
            if (orderByUsername==null){
                return new StatusVo(700,"您未登录");
            }
            return new StatusVo(1,"订单列表为空哦！~");
        }
        return new DataVo(0,orderByUsername);

    }
}
