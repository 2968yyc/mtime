package com.stylefeng.guns.rest.order.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.cskaoyan.bean.order.OrderVo;
import com.stylefeng.guns.rest.order.bean.MoocOrderT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单信息表 Mapper 接口
 * </p>
 *
 * @author yyc
 * @since 2019-06-09
 */
public interface MoocOrderTMapper extends BaseMapper<MoocOrderT> {


    String getAllSeatsByFieldId(@Param("fieldId") Integer fieldId);

    String  getSoldSeatsByFieldId(@Param("fieldId") Integer fieldId);

    OrderVo getOrderDetailByOrderId(String uuid);
    List<OrderVo> getOrderDetailByUserId(Integer userId, Page<OrderVo> page);
}
