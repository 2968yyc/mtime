package com.stylefeng.guns.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cskaoyan.bean.Vo;
import com.stylefeng.guns.rest.common.persistence.vo.CinemaReq;
import com.stylefeng.guns.rest.common.persistence.vo.CinemaResp;
import com.stylefeng.guns.rest.common.persistence.vo.CondReq;
import com.stylefeng.service.CinemaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xf
 * @Date: 2019/6/4 21:53
 */
@RestController
public class CinemaController {
    @Reference(version = "1.0")
    CinemaService cinemaService;



    @RequestMapping("cinema/getCinemas")
    public Vo getCinema(CinemaReq cinemaReq){

        Vo vo = cinemaService.selectCinemaByOptions(cinemaReq);
        return vo;
    }
    @RequestMapping("cinema/getCondition")
    public Vo getCondition(CondReq condReq){
        return cinemaService.selectConditionByOptions(condReq);
    }
}
