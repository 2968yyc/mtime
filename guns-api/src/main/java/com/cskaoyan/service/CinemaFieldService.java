package com.cskaoyan.service;

import com.cskaoyan.bean.cinema.CinemaInfoVo;
import com.cskaoyan.bean.cinema.FilmInfoVo;

import java.util.List;

/**
 * @Author:ZCH
 * @Date:2019/6/4 23:36
 */
public interface CinemaFieldService {

    CinemaInfoVo getCinemaInfo(int cinemaId);

    List<FilmInfoVo> getFilmInfoVo(int cinemaId);
}
