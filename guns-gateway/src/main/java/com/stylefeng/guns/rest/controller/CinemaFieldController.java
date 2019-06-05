package com.stylefeng.guns.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cskaoyan.bean.cinema.CinemaInfoVo;
import com.cskaoyan.bean.vo.DataVo;
import com.cskaoyan.bean.vo.StatusVo;
import com.cskaoyan.bean.vo.Vo;
import com.cskaoyan.service.CinemaFieldService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:ZCH
 * @Date:2019/6/5 16:29
 */

@RestController
@RequestMapping("cinema")
public class CinemaFieldController {

    @Reference
    CinemaFieldService cinemaFieldService;

    @RequestMapping("getFields")
    public Vo getFields(Integer cinemaId){
        try {
            CinemaInfoVo cinemaInfo = cinemaFieldService.getCinemaInfo(cinemaId);
            if (cinemaId != null){
                return new DataVo(0,cinemaInfo);
            }else {
                return new StatusVo(1,"影院信息查询失败");
            }
        }catch (Exception e){
            return new StatusVo(999,"系统出现异常，请联系管理员");
        }
    }
}
