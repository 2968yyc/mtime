package com.stylefeng.guns.rest.film.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cskaoyan.bean.vo.StatusVo;
import com.cskaoyan.bean.vo.Vo;
import com.cskaoyan.bean.vo.film.FilmIndexVo;
import com.cskaoyan.service.FilmService;
import com.stylefeng.guns.rest.film.bean.rebuild.*;

import com.stylefeng.guns.rest.film.dao.MtimeBannerTMapper;
import com.stylefeng.guns.rest.film.dao.MtimeFilmTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
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
