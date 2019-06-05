package com.stylefeng.guns.rest.modular.field.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cskaoyan.bean.cinema.CinemaInfoVo;
import com.cskaoyan.bean.cinema.FilmInfoVo;
import com.cskaoyan.service.CinemaFieldService;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeCinemaT;
import com.stylefeng.guns.rest.modular.field.service.IMtimeCinemaTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author:ZCH
 * @Date:2019/6/5 16:05
 */
@Component
@Service(interfaceClass = CinemaFieldService.class)
public class CinemaFieldServiceImpl implements CinemaFieldService {

    @Autowired
    IMtimeCinemaTService mtimeCinemaTService;

    @Autowired
    MtimeFieldTMapper mtimeFieldTMapper;

    @Override
    public CinemaInfoVo getCinemaInfo(Integer cinemaId){
        MtimeCinemaT mtimeCinemaT = mtimeCinemaTService.selectById(cinemaId);
        CinemaInfoVo cinemaInfoVo = new CinemaInfoVo();
        cinemaInfoVo.setCinemaId(mtimeCinemaT.getUuid() + "");
        cinemaInfoVo.setImgUrl(mtimeCinemaT.getImgAddress());
        cinemaInfoVo.setCinemaName(mtimeCinemaT.getCinemaName());
        cinemaInfoVo.setCinemaAdress(mtimeCinemaT.getCinemaAddress());
        cinemaInfoVo.setCinemaPhone(mtimeCinemaT.getCinemaPhone());
        return cinemaInfoVo;
    }

    @Override
    public List<FilmInfoVo> getFilmInfoVo(Integer cinemaId){
        List<FilmInfoVo> filmInfoVos = mtimeFieldTMapper.selectFilmInfoByCinemaId(cinemaId);
        return filmInfoVos;
    }

}
