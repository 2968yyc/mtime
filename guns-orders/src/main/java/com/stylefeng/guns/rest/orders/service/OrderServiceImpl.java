package com.stylefeng.guns.rest.orders.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.cskaoyan.bean.orders.OrderInfoVo;
import com.cskaoyan.service.CinemaFieldService;
import com.cskaoyan.service.OrderService;
import com.stylefeng.guns.rest.orders.dao.MoocOrderTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.List;

/**
 * @Author:ZCH
 * @Date:2019/6/8 22:44
 */

@Service(interfaceClass = OrderService.class)
@Component
public class OrderServiceImpl implements OrderService {

    @Reference
    CinemaFieldService cinemaFieldService;

    @Autowired
    MoocOrderTMapper moocOrderTMapper;

    @Override
    public OrderInfoVo buyTickets(int fieldId, String soldSeats, String seatsName, int userId) {
        OrderInfoVo orderInfoVo = moocOrderTMapper.buyTicketsById(fieldId, soldSeats, seatsName);
        return orderInfoVo;
    }

    //验证是否为真实的座位编号
    @Override
    public boolean isTrueSeats(int fieldId, String seats) {
        //根据fieldId来找到对应的座位信息
        try {
            String seatPath = cinemaFieldService.getSeatsByFieldId(fieldId);
            String seatAddress = "E:\\project4\\前端代码\\film-front\\static" + seatPath;
            File file = new File(seatAddress);
            FileInputStream inputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true){
                String s = reader.readLine();
                if (s == null){
                    break;
                }
                sb.append(s);
            }
            Jedis jedis = new Jedis();
            jedis.set(seatPath,sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isNoSoldSeats(int fieldId, String seats) {
        return false;
    }

    @Override
    public List<OrderInfoVo> getOrdersByUserId(int userId) {
        return null;
    }

    @Override
    public String getSoldSeatsByFieldId(int fieldId) {
        return null;
    }
}
