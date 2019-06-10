package com.stylefeng.guns.rest.order.serviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cskaoyan.bean.order.OrderInfo;
import com.cskaoyan.bean.order.OrderVo;

import com.cskaoyan.service.CinemaFieldService;
import com.cskaoyan.service.OrderService;

import com.cskaoyan.service.UserService;
import com.stylefeng.guns.core.util.UuidUtil;
import com.stylefeng.guns.rest.order.bean.MoocOrderT;
import com.stylefeng.guns.rest.order.dao.MoocOrderTMapper;
import com.stylefeng.guns.rest.order.util.Ftputil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @Author: yyc
 * @Date: 2019/6/8 18:27
 */
@Slf4j
@Component
@com.alibaba.dubbo.config.annotation.Service(interfaceClass = OrderService.class)
public class DefaultOrderServiceImpl implements OrderService {

    @Autowired
    private MoocOrderTMapper moocOrderTMapper;
    @Autowired
    private Ftputil ftputil;
    @Reference(check = false)
    private CinemaFieldService cinemaFieldService;
    @Reference(check = false)
    private UserService userService;

    @Override
    public boolean isTrueSeats(Integer fieldId, String seats) {
        //获取seats真实地址
        String seats_addrress = moocOrderTMapper.getAllSeatsByFieldId(fieldId);
        String seats_json = ftputil.getFileStrByAddr(seats_addrress);
        JSONObject jsonObject = JSONObject.parseObject(seats_json);
        String ids = jsonObject.get("ids").toString();
        String[] idsArray = ids.split(",");
        String[] buy_seats = seats.split(",");

        //是否是全包括
        List<String> validlist = Arrays.asList(idsArray);
        return validlist.containsAll(Arrays.asList(buy_seats));

    }

    /**
     * 判断是否包含在已卖出订单中
     * @param fieldId
     * @param seats
     * @return
     */
    @Override
    public boolean isAllSeatsUnsold(Integer fieldId, String seats) {
        String allSoldSeatsStr = moocOrderTMapper.getSoldSeatsByFieldId(fieldId);
        if (allSoldSeatsStr==null){
            allSoldSeatsStr="";
        }
        String[] split = allSoldSeatsStr.split(",");
        String[] buy_seats = seats.split(",");
        return !Arrays.asList(split).containsAll(Arrays.asList(buy_seats));

    }

    /**
     * 创建新订单
     * @param fieldId
     * @param soldSeats
     * @param seatsName
     * @param username
     * @return
     */
    @Override
    public OrderVo addOrder(Integer fieldId, String soldSeats, String seatsName, String username) {
        String uuid = UuidUtil.getUuid();
        //影片信息
        OrderInfo orderInfo = cinemaFieldService.getOrderInfoByFieldId(fieldId);
        String[] seatids = soldSeats.split(",");
        //总金额
        double totalPrice = getTotalPrice(seatids.length, orderInfo.getPrice());
        MoocOrderT moocOrderT = new MoocOrderT();
        moocOrderT.setUuid(uuid);
        moocOrderT.setSeatsName(seatsName);
        moocOrderT.setSeatsIds(soldSeats);
        moocOrderT.setOrderUser(userService.getUserIdByUsername(username));
        moocOrderT.setOrderPrice(totalPrice);
        moocOrderT.setFilmPrice(orderInfo.getPrice()+0.0);
        moocOrderT.setFilmId(orderInfo.getFilmId());
        moocOrderT.setFieldId(fieldId);
        moocOrderT.setCinemaId(orderInfo.getCinemaId());
        Integer insert = moocOrderTMapper.insert(moocOrderT);
        if (insert>0){
            //返回查询结果
             return moocOrderTMapper.getOrderDetailByOrderId(uuid);
        }else {
            log.error("订单插入失败");
            return null;
        }
    }
    private double getTotalPrice(int sold,int price){
        BigDecimal sold_deci= new BigDecimal(sold);
        BigDecimal film_price = new BigDecimal(price);
        BigDecimal result =sold_deci.multiply(film_price);

        //四舍五入
        result.setScale(2, RoundingMode.HALF_UP);
        return result.doubleValue();

    }

    @Override
    public List<OrderVo> getOrderByUsername(String username, Integer nowPage, Integer pageSize) {
        if (username==null || username.trim().length()==0){
            log.error("用户订单信息获取失败，用户未传入");
            return null;
        }
        int userId = userService.getUserIdByUsername(username);
        Page<OrderVo> page = new Page<>(nowPage,pageSize);
        List<OrderVo> orderDetailByUserId = moocOrderTMapper.getOrderDetailByUserId(userId,page);
        if (orderDetailByUserId==null || orderDetailByUserId.size()==0){
            orderDetailByUserId = new ArrayList<>();
        }
        return orderDetailByUserId;
    }

    @Override
    public String getSoldSeatsByFieldId(Integer fieldId) {
        if (fieldId==null){
            log.error("查询已售座位错误，未传入任何场次信息");
            return "";
        }
        try {
            return moocOrderTMapper.getSoldSeatsByFieldId(fieldId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
