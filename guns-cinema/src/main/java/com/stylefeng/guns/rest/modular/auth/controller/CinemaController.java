package com.stylefeng.guns.rest.modular.auth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.common.persistence.service.CinemaService;
import com.stylefeng.guns.rest.common.persistence.vo.CinemaReq;
import com.stylefeng.guns.rest.common.persistence.vo.CinemaResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xf
 * @Date: 2019/6/4 21:53
 */
@RestController
public class CinemaController {
    @Reference
    CinemaService cinemaService;

    @RequestMapping("/cinema/getCinemas")
    public CinemaResp getCinema(CinemaReq cinemaReq){
        cinemaService.test();
        return null;
    }
}
