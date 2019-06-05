package com.stylefeng.guns.rest.modular.field.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.cskaoyan.service.CinemaFieldService;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFieldT;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 放映场次表 前端控制器
 * </p>
 *
 * @author alan
 * @since 2019-06-04
 */
@RestController
@RequestMapping("/cinema")
public class MtimeFieldTController {

    @Reference
    CinemaFieldService cinemaFieldService;

    @RequestMapping("getFields")
    public MtimeFieldT getFields(Integer cinemaId){
        return null;
    }

}

