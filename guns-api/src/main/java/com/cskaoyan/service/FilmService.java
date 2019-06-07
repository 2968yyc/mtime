package com.cskaoyan.service;


import com.cskaoyan.bean.film.FilmConditionVo;
import com.cskaoyan.bean.film.FilmGetVo;
import com.cskaoyan.bean.vo.Vo;

/**
 * @Author: Qiu
 * @Date: 2019/6/4 20:23
 */
public interface FilmService {
    Vo getIndex();

    Vo getFilms(FilmGetVo filmGetVo);
    Vo getFilmDetails(String id,int searchType);

    Vo getConditionList(FilmConditionVo filmConditionVo);
}
