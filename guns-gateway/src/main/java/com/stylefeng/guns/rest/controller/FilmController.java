package com.stylefeng.guns.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cskaoyan.bean.StatusVo;
import com.cskaoyan.service.FilmService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Qiu
 * @Date: 2019/6/4 20:23
 */
@RestController
@RequestMapping("film")
public class FilmController {

    @Reference
    FilmService filmService;

    @RequestMapping("getIndex")
    public StatusVo getIndex(){
        return filmService.getIndex();
    }
}
