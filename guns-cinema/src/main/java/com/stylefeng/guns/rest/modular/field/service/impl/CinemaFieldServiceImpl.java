package com.stylefeng.guns.rest.modular.field.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cskaoyan.bean.cinema.CinemaInfoVo;
import com.cskaoyan.bean.cinema.FilmInfoVo;
import com.cskaoyan.bean.cinema.HallInfo;
import com.cskaoyan.service.CinemaFieldService;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeCinemaT;
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
    MtimeCinemaTMapper mtimeCinemaTMapper;

    @Autowired
    MtimeFieldTMapper mtimeFieldTMapper;

    @Override
    public CinemaInfoVo getCinemaInfo(int cinemaId){
        MtimeCinemaT mtimeCinemaT = mtimeCinemaTMapper.selectById(cinemaId);
        CinemaInfoVo cinemaInfoVo = new CinemaInfoVo();
        cinemaInfoVo.setCinemaId(mtimeCinemaT.getUuid() + "");
        cinemaInfoVo.setImgUrl(mtimeCinemaT.getImgAddress());
        cinemaInfoVo.setCinemaName(mtimeCinemaT.getCinemaName());
        cinemaInfoVo.setCinemaAdress(mtimeCinemaT.getCinemaAddress());
        cinemaInfoVo.setCinemaPhone(mtimeCinemaT.getCinemaPhone());
        return cinemaInfoVo;
    }

    @Override
    public List<FilmInfoVo> getFilmInfoVo(int cinemaId){
        List<FilmInfoVo> filmInfoVos = mtimeFieldTMapper.selectFilmInfoByCinemaId(cinemaId);
        return filmInfoVos;
    }

    @Override
    public HallInfo getHallInfo(int fieldId){
        HallInfo hallInfo = mtimeFieldTMapper.selectHallInfoByFieldId(fieldId);
        hallInfo.setSoldSeats("1,2,3,5,12");
        return hallInfo;
    }

    @Override
    public FilmInfoVo getFilmInfoByCinemaIdAndFieldId(int cinemaId, int fieldId){
        FilmInfoVo filmInfoVo = mtimeFieldTMapper.selectFilmInfoByCinemaIdAndFieldId(cinemaId, fieldId);
        return filmInfoVo;
    }

    @Override
    public String getSeatsByFieldId(int fieldId) {
        String seatsByFieldId = mtimeFieldTMapper.getSeatsByFieldId(fieldId);
        return seatsByFieldId;
    }
}
