package com.stylefeng.guns.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cskaoyan.bean.orders.OrderInfoVo;
import com.cskaoyan.bean.vo.ImgPreVo;
import com.cskaoyan.bean.vo.StatusVo;
import com.cskaoyan.bean.vo.Vo;
import com.cskaoyan.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:ZCH
 * @Date:2019/6/8 22:39
 */

@RestController
public class OrdersController {

    @Reference
    OrderService orderService;

    @PostMapping("order/buyTickets")
    public Vo buyTickets(int fieldId, String soldSeats, String seatsName){

        //验证售出的票的信息是否正确

        //判断已销售的座位是否已经被售出

        //执行业务，创建订单信息
        try {
            OrderInfoVo orderInfoVo = orderService.buyTickets(fieldId, soldSeats, seatsName,userId);
            if (orderInfoVo != null){
                ImgPreVo imgPreVo = new ImgPreVo(0, orderInfoVo, "");
                return imgPreVo;
            }else {
                StatusVo statusVo = new StatusVo(1, "该订单不存在");
                return statusVo;
            }
        }catch (Exception e){
            e.printStackTrace();
            StatusVo statusVo = new StatusVo(999, "系统出现异常，请联系管理员");
            return statusVo;
        }
    }

    @PostMapping("order/getOrderInfo")
    public Vo getOrderInfo(@RequestParam(name = "nowPage", required = false, defaultValue = "1") int nowPage,
                           @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize){

        return null;
    }
}
