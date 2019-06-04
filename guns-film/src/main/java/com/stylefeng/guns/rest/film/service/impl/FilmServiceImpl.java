package com.stylefeng.guns.rest.film.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cskaoyan.bean.StatusVo;
import com.cskaoyan.service.FilmService;
import org.springframework.stereotype.Component;

/**
 * @Author: Qiu
 * @Date: 2019/6/4 20:29
 */
@Component
@Service(interfaceClass = FilmService.class)
public class FilmServiceImpl implements FilmService{
    @Override
    public StatusVo getIndex() {
        return null;
    }
}
