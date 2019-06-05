package com.stylefeng.guns.rest.common.persistence.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeCinemaT;
import com.stylefeng.guns.rest.common.persistence.service.CinemaService;
import com.stylefeng.guns.rest.common.persistence.vo.CinemaReq;
import com.stylefeng.guns.rest.common.persistence.vo.CinemaResp;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/6/4 23:01
 */
@org.springframework.stereotype.Service("cinemaServiceImpl")
@Service(interfaceClass = CinemaService.class)
public class CinemaServiceImpl implements CinemaService {

    @Reference
    MtimeCinemaTMapper mtimeCinemaTMapper;


    @Override
    public CinemaResp selectCinemaByOptions(CinemaReq cinemaReq) {
        String brandId="%"+cinemaReq.getBrandId()+"%";
        String districtId="%"+cinemaReq.getDistrictId()+"%";
        String hallType=cinemaReq.getHallType();
        List<MtimeCinemaT> lists=mtimeCinemaTMapper.selectCinemaByOptions(brandId,districtId,hallType);
        String  total=String.valueOf(lists.size());

        return new CinemaResp(cinemaReq.getNowPage(),total,lists);
    }

    @Override
    public void test() {
        System.out.println(666);
    }
}
