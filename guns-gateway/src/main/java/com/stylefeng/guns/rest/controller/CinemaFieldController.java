package com.stylefeng.guns.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cskaoyan.bean.cinema.CinemaInfoVo;
import com.cskaoyan.bean.cinema.FilmInfoVo;
import com.cskaoyan.bean.cinema.HallInfo;
import com.cskaoyan.bean.vo.DataVo;
import com.cskaoyan.bean.vo.StatusVo;
import com.cskaoyan.bean.vo.Vo;
import com.cskaoyan.service.CinemaFieldService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @Author:ZCH
 * @Date:2019/6/5 16:29
 */

@RestController
public class CinemaFieldController {

    @Reference(check = false)
    CinemaFieldService cinemaFieldService;

    @RequestMapping("cinema/getFields")
    public Vo getFields(int cinemaId){
        try {
            CinemaInfoVo cinemaInfo = cinemaFieldService.getCinemaInfo(cinemaId);
            List<FilmInfoVo> filmList = cinemaFieldService.getFilmInfoVo(cinemaId);
            HashMap<Object, Object> map = new HashMap<>();
            map.put("cinemaInfo",cinemaInfo);
            map.put("filmList",filmList);
            if (cinemaInfo != null && filmList != null){
                DataVo dataVo = new DataVo(0, map);
                dataVo.setImgPre("http://img.meetingshop.cn/");
                return dataVo;
            }else {
                return new StatusVo(1,"影院信息查询失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new StatusVo(999,"系统出现异常，请联系管理员");
        }
    }

    @RequestMapping("/cinema/getFieldInfo")
    public Vo getFieldInfo(int cinemaId, int fieldId){
        try {
            HallInfo hallInfo = cinemaFieldService.getHallInfo(fieldId);
            FilmInfoVo filmInfo = cinemaFieldService.getFilmInfoByCinemaIdAndFieldId(cinemaId, fieldId);
            CinemaInfoVo cinemaInfo = cinemaFieldService.getCinemaInfo(cinemaId);
            HashMap<String, Object> map = new HashMap<>();
            map.put("filmInfo",filmInfo);
            map.put("cinemaInfo",cinemaInfo);
            map.put("hallInfo",hallInfo);
            DataVo dataVo = new DataVo(0, map);
            dataVo.setImgPre("http://img.meetingshop.cn/");
            return dataVo;
        }catch (Exception e){
            e.printStackTrace();
            return new StatusVo(999,"系统出现异常，请联系管理员");
        }
    }
}
