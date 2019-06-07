package com.stylefeng.guns.rest.modular.auth.controller;

import com.stylefeng.guns.rest.modular.auth.controller.dto.CinemaReq;
import com.stylefeng.guns.rest.modular.auth.controller.dto.CinemaResp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xf
 * @Date: 2019/6/4 21:53
 */
@RestController
public class CinemaController {

    @RequestMapping("/cinema/getCinemas")
    public CinemaResp getCinema(CinemaReq cinemaReq){

        return null;
    }
}
