package com.stylefeng.guns.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.common.persistence.vo.CinemaReq;
import com.stylefeng.guns.rest.common.persistence.vo.CinemaResp;
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
    public CinemaResp getCinema(CinemaReq cinemaReq){
        cinemaService.test();
        return null;
    }
}
