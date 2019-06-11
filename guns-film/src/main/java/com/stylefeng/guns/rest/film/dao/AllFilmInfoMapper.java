package com.stylefeng.guns.rest.film.dao;

import com.stylefeng.guns.rest.film.bean.MtimeActorT;
import com.stylefeng.guns.rest.film.bean.rebuild.Actor;
import com.stylefeng.guns.rest.film.bean.rebuild.AllFilmInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/6/6 17:21
 */
public interface AllFilmInfoMapper {
    AllFilmInfo getFilmDetails(@Param("filmName") String name,@Param("filmId") int id);
    MtimeActorT getDirectorById(int id);
    List<Actor> getActorsById(@Param("id1") int id1,@Param("id2") int id2);
}
