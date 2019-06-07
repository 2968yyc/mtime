package com.stylefeng.service;

import com.cskaoyan.bean.vo.Vo;
import com.stylefeng.guns.rest.common.persistence.vo.CinemaReq;

/**
 * @Author: xf
 * @Date: 2019/6/4 22:58
 */
public interface CinemaService {
    Vo selectCinemaByOptions(CinemaReq cinemaReq);
    void test();
    Vo selectConditionByOptions(CinemaReq cinemaReq);


}
