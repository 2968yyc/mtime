package com.stylefeng.guns.rest.modular.field.controller;


import com.stylefeng.guns.rest.common.persistence.model.MtimeFieldT;
import com.stylefeng.guns.rest.modular.field.service.IMtimeFieldTService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    IMtimeFieldTService mtimeFieldTService;

    @RequestMapping("getFields")
    public MtimeFieldT getFields(Integer cinemaId){
        return null;
    }

}

