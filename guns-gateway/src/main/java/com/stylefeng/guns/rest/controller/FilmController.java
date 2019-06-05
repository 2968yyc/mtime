package com.stylefeng.guns.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cskaoyan.bean.StatusVo;
import com.cskaoyan.service.FilmService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    /**
     *   获取首页信息接口
     *    banner
     *    hotFilm
     *    soonFilm
     *    boxRank
     *    expectRank
     *    top100
     */
    @RequestMapping(value = "getIndex",method = RequestMethod.GET)
    public StatusVo getIndex(){
        return null;
    }

    /**
     *   影片条件列表查询接口
     *   catInfo
     *   sourceInfo
     *   yearInfo
     */
    @RequestMapping(value = "getConditionList",method = RequestMethod.GET)
    public StatusVo getConditionList(String catId,String sourceId,String yearId){
        return null;
    }

    /**
     *   影片查询接口
     */

}
