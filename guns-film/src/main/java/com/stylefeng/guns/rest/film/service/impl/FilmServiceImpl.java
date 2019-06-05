package com.stylefeng.guns.rest.film.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cskaoyan.bean.film.FilmGetVo;
import com.cskaoyan.bean.vo.DataVo;
import com.cskaoyan.bean.vo.StatusVo;
import com.cskaoyan.bean.vo.Vo;
import com.cskaoyan.bean.vo.film.FilmIndexVo;
import com.cskaoyan.bean.vo.film.FilmQueryVo;
import com.cskaoyan.service.FilmService;
import com.stylefeng.guns.rest.film.bean.MtimeFilmT;
import com.stylefeng.guns.rest.film.bean.rebuild.*;

import com.stylefeng.guns.rest.film.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Author: Qiu
 * @Date: 2019/6/4 20:29
 */
@Component
@Service(interfaceClass = FilmService.class)
public class FilmServiceImpl implements FilmService {

    public FilmServiceImpl() {
        System.out.println("filmImpl");
    }

    @Autowired
    MtimeBannerTMapper mtimeBannerTMapper;
    @Autowired
    MtimeFilmTMapper mtimeFilmTMapper;
    @Autowired
    MtimeYearDictTMapper mtimeYearDictTMapper;
    @Autowired
    MtimeCatDictTMapper mtimeCatDictTMapper;
    @Autowired
    MtimeSourceDictTMapper mtimeSourceDictTMapper;

    @Override
    public Vo getIndex() {


        try {
            HashMap<Object, Object> map = new HashMap<>();
            //banner
            List<Banner> banners = mtimeBannerTMapper.queryAllBanner();
            if (banners == null || banners.size() == 0) {
                return new StatusVo(1, "查询失败，无banner可加载");
            }

            map.put("banners", banners);
            //hotFilm
            map = getHotFilm(map);
            //soonFilm
            map = getSoonFilm(map);
            //boxRanking
            map = getBoxRanking(map);
            //expectRanking
            map = getExpectRanking(map);
            //top100
            map = getTop100(map);

            return new FilmIndexVo("http://img.meetingshop.cn/",0,map);

        } catch (Exception e) {
            e.printStackTrace();
            return new StatusVo(999, "系统出现异常，请联系管理员");
        }


    }

    @Override
    public Vo getConditionList(String catId, String sourceId, String yearId) {

        DataVo dataVo = new DataVo();
        try {
            HashMap<Object, Object> map = new HashMap<>();

            map.put("flag",true);

            //yearInfo
            map = getYearInfo(yearId, map);

            //catInfo
            map = getCatInfo(catId, map);

            //SourceInfo
            map = getSourceInfo(sourceId, map);

            //-----------------------
            Boolean flag = (Boolean) map.get("flag");

            map.remove("flag");
            if (flag == false){

                return new StatusVo(1, "查询失败，无条件可加载");
            }
            //------------------------

            dataVo = new DataVo(0,map);

        }catch (Exception e){
            e.printStackTrace();
            return new StatusVo(999, "系统出现异常，请联系管理员");
        }

        return dataVo;

    }

    @Override
    public Vo getFilms(FilmGetVo filmGetVo) {

        List<FilmInfo> filmInfos = new ArrayList<>();

        EntityWrapper<MtimeFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status","1");
        if(filmGetVo.getSortId()==1){
            entityWrapper.orderBy("film_box_office");
        }else if (filmGetVo.getSortId()==2){
            entityWrapper.orderBy("film_date");
        }else if (filmGetVo.getSortId() == 3){
            entityWrapper.orderBy("film_score");
        }


        Page<MtimeFilmT> page =new Page<>(filmGetVo.getNowPage(),filmGetVo.getPageSize());
        if (filmGetVo.getSourceId()!=99){
           entityWrapper.eq("film_source",filmGetVo.getSourceId());
        }
        if (filmGetVo.getYearId()!=99){
            entityWrapper.eq("film_date",filmGetVo.getYearId());
        }
        if (filmGetVo.getCatId()!=99){
            String catStr = "%#"+filmGetVo.getCatId()+"#%";
            entityWrapper.like("film_cats",catStr);
        }
        List<MtimeFilmT> mtimeFilms = mtimeFilmTMapper.selectPage(page,entityWrapper);

        filmInfos = getFilmInfos(mtimeFilms,filmInfos);
        Integer totalCount = mtimeFilmTMapper.selectCount(entityWrapper);
        int totalPages = (totalCount/filmGetVo.getPageSize())+1;

        return new FilmQueryVo(0,"http://img.meetingshop.cn/",filmGetVo.getNowPage(),totalPages,filmInfos);

    }

    /**
     * 重新封装filmInfo
     * @param mtimeFilms
     * @param filmInfos
     * @return
     */
    private List<FilmInfo> getFilmInfos(List<MtimeFilmT> mtimeFilms, List<FilmInfo> filmInfos) {
        for (MtimeFilmT f : mtimeFilms) {
            FilmInfo filmInfo = new FilmInfo(f.getUuid(),f.getFilmType(),f.getImgAddress(),f.getFilmName(),f.getFilmScore());
            filmInfos.add(filmInfo);
        }
        return filmInfos;
    }

    /**
     * filmCat
     * @param filmGetVo
     * @return
     */


    /**
     * sourceInfo
     * @param sourceId
     * @param map
     * @return
     */
    private HashMap<Object,Object> getSourceInfo(String sourceId, HashMap<Object, Object> map) {
        int source = 99;
        if (sourceId !=null){
            source = Integer.parseInt(sourceId);
        }
        List<Source> sourceInfo = mtimeSourceDictTMapper.queryAllSource();

        if (sourceInfo.size() == 0){
            map.replace("flag",false);
        }

        for (Source s : sourceInfo) {
            if (s.getSourceId() == source){
                s.setActive(true);
            }else {
                s.setActive(false);
            }
        }
        map.put("sourceInfo",sourceInfo);
        return map;
    }

    /**
     * catInfo
     * @param catId
     * @param map
     * @return
     */
    private HashMap<Object, Object> getCatInfo(String catId, HashMap<Object, Object> map) {
        int cat = 99;
        if (catId != null){
            cat= Integer.parseInt(catId);
        }
        List<Cat> catInfo = mtimeCatDictTMapper.queryAllCat();

        if (catInfo.size() == 0){
            map.replace("flag",false);
        }

        for (Cat c : catInfo) {
            if (c.getCatId() == cat){
                c.setActive(true);
            }else {
                c.setActive(false);
            }
        }
        map.put("catInfo",catInfo);
        return map;
    }

    /**
     * yearInfo
     * @param yearId
     * @param map
     * @return
     */
    private HashMap<Object, Object> getYearInfo(String yearId, HashMap<Object, Object> map) {
        int year = 99;
        if (yearId != null){
            year = Integer.parseInt(yearId);
        }
        List<Year> yearInfo = mtimeYearDictTMapper.queryAllYear();
        if (yearInfo.size() == 0){
            map.replace("flag",false);
        }

        for (Year y : yearInfo) {
            if (y.getYearId()==year){
                y.setActive(true);
            }else {
                y.setActive(false);
            }
        }
        map.put("yearInfo",yearInfo);
        return map;
    }

    /**
     * top100
     * @param map
     * @return
     */
    private HashMap<Object, Object> getTop100(HashMap<Object, Object> map) {

        List<TopFilm> top100 = mtimeFilmTMapper.getTopFilm();

        map.put("top100",top100);
        return map;
    }

    /**
     * expectRanking
     * @param map
     * @return
     */
    private HashMap<Object, Object> getExpectRanking(HashMap<Object, Object> map) {
        List<ExpectRankFilm> expectRanking = mtimeFilmTMapper.getExpectRankFilm();
        return map;
    }

    /**
     * BoxRanking
     * @param map
     * @return
     */
    private HashMap<Object, Object> getBoxRanking(HashMap<Object, Object> map) {
        List<BoxRankFilm> boxRanking = mtimeFilmTMapper.queryBoxRankFilm();
        map.put("boxRanking",boxRanking);
        return map;
    }

    /**
     * soonFilm
     * @param map
     * @return
     */
    private HashMap<Object, Object> getSoonFilm(HashMap<Object, Object> map) {
        int filmNum = mtimeFilmTMapper.querySoonFilmCount(2);
        List<SoonFilm> filmInfo = mtimeFilmTMapper.querySoonFilm(2);
        HashMap<Object, Object> soonFilms = new HashMap<>();
        soonFilms.put("filmNum",filmNum);
        soonFilms.put("filmInfo",filmInfo);
        map.put("soonFilms",soonFilms);
        return map;
    }

    /**
     * hotFilm
     * @param map
     * @return
     */
    private HashMap<Object, Object> getHotFilm(HashMap<Object, Object> map) {

        int filmNum = mtimeFilmTMapper.queryHotFilmCount(1);
        List<HotFilm> filmInfo = mtimeFilmTMapper.queryHotFilm(1);
        HashMap<Object, Object> hotFilms = new HashMap<>();
        hotFilms.put("filmInfo", filmInfo);
        hotFilms.put("filmNum", filmNum);
        map.put("hotFilms", hotFilms);
        return map;
    }

}
