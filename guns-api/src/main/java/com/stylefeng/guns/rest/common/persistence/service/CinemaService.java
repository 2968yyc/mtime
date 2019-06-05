package com.stylefeng.guns.rest.common.persistence.service;

import com.stylefeng.guns.rest.common.persistence.vo.CinemaReq;
import com.stylefeng.guns.rest.common.persistence.vo.CinemaResp;

/**
 * @Author: xf
 * @Date: 2019/6/4 22:58
 */
public interface CinemaService {
    CinemaResp selectCinemaByOptions(CinemaReq cinemaReq);
    void test();


}
