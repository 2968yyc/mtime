package com.cskaoyan.service;


import com.cskaoyan.bean.film.FilmConditionVo;
import com.cskaoyan.bean.film.FilmGetVo;
import com.cskaoyan.bean.filmNew.ActorVO;
import com.cskaoyan.bean.filmNew.FilmDescVO;
import com.cskaoyan.bean.filmNew.FilmDetailVO;
import com.cskaoyan.bean.filmNew.ImgVO;
import com.cskaoyan.bean.vo.Vo;

import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/6/4 20:23
 */
public interface FilmService {
    Vo getIndex();

    Vo getFilms(FilmGetVo filmGetVo);
    Vo getFilmDetails(String id,int searchType);

    Vo getConditionList(FilmConditionVo filmConditionVo);

    //根据影片名称或id获取影片信息
    FilmDetailVO getFilmDetail(String searchParam,int searchType);
    //获取影片相关的其他信息【演员表，图片地址】
    //获取影片描述信息
    FilmDescVO getFilmDesc(String filmId);
    //获取图片信息
    ImgVO getImgs(String filmId);
    //获取演员信息
    ActorVO getDirectorDesc(String filmId);
    List<ActorVO> getActors(String filmId);
}
