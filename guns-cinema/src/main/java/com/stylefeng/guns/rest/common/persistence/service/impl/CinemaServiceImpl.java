package com.stylefeng.guns.rest.common.persistence.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cskaoyan.bean.DataVo;
import com.cskaoyan.bean.StatusVo;
import com.cskaoyan.bean.Vo;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeAreaDictTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeBrandDictTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeHallDictTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeAreaDictT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeBrandDictT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeCinemaT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeHallDictT;
import com.stylefeng.guns.rest.common.persistence.vo.CondReq;
import com.stylefeng.service.CinemaService;
import com.stylefeng.guns.rest.common.persistence.vo.CinemaReq;
import com.stylefeng.guns.rest.common.persistence.vo.CinemaResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xf
 * @Date: 2019/6/4 23:01
 */

@Service(interfaceClass = CinemaService.class,version = "1.0")
@Component
@Transactional
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    MtimeCinemaTMapper mtimeCinemaTMapper;
    @Autowired
    MtimeBrandDictTMapper mtimeBrandDictTMapper;
    @Autowired
    MtimeAreaDictTMapper mtimeAreaDictTMapper;
    @Autowired
    MtimeHallDictTMapper mtimeHallDictTMapper;


    @Override
    public Vo selectCinemaByOptions(CinemaReq cinemaReq) {
        String brandId="%"+cinemaReq.getBrandId()+"%";
        String districtId="%"+cinemaReq.getDistrictId()+"%";
        String hallType="%"+cinemaReq.getHallType()+"%";

        List<MtimeCinemaT> lists= null;
        try {
            lists = mtimeCinemaTMapper.selectCinemaByOptions(brandId,districtId,hallType);
        } catch (Exception e) {
            e.printStackTrace();
            return new StatusVo(1,"影院信息查询失败");
        }
        String  total=String.valueOf(lists.size());
        List<List<MtimeCinemaT>> list=new ArrayList<>();
        list.add(lists);

        CinemaResp cinemaResp = new CinemaResp(Integer.parseInt(cinemaReq.getNowPage()), Integer.parseInt(total), list);
        return cinemaResp;
    }

    @Override
    public void test() {
        System.out.println(666);
    }

    public Vo selectConditionByOptions(CinemaReq cinemaReq){
        String brandId="%"+cinemaReq.getBrandId()+"%";
        String areaId="%"+cinemaReq.getAreaId()+"%";
        String hallType="%"+cinemaReq.getHallType()+"%";

        List<MtimeBrandDictT> list1=null;
        List<MtimeAreaDictT> list2=null;
        List<MtimeHallDictT> list3=null;
        try{
            list1=mtimeBrandDictTMapper.selectBeanById(brandId);
            list2=mtimeAreaDictTMapper.selectBeanById(areaId);
            list3=mtimeHallDictTMapper.selectBeanById(hallType);
        }catch (Exception e){
            e.printStackTrace();
            return new StatusVo(1,"影院信息查询失败");
        }
        Map<String ,List>  map=new HashMap<>();
        map.put("brandList",list1);
        map.put("areaList",list2);
        map.put("halltypeList",list3);
        return new DataVo(0,map);

    }
}
