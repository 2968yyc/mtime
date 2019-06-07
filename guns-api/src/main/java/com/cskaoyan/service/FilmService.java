package com.cskaoyan.service;


import com.cskaoyan.bean.film.FilmGetVo;
import com.cskaoyan.bean.vo.Vo;

/**
 * @Author: Qiu
 * @Date: 2019/6/4 20:23
 */
public interface FilmService {
    Vo getIndex();

    Vo getConditionList(String catId, String sourceId, String yearId);

    Vo getFilms(FilmGetVo filmGetVo);
    Vo getFilmDetails(String id,int searchType);
}
