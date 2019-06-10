package com.stylefeng.guns.rest.film.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cskaoyan.bean.film.FilmConditionVo;
import com.cskaoyan.bean.film.FilmGetVo;
import com.cskaoyan.bean.vo.DataVo;
import com.cskaoyan.bean.vo.StatusVo;
import com.cskaoyan.bean.vo.Vo;
import com.cskaoyan.bean.vo.film.FilmIndexVo;
import com.cskaoyan.bean.vo.film.FilmQueryVo;
import com.cskaoyan.service.FilmService;
import com.stylefeng.guns.rest.film.bean.*;
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
    @Autowired
    AllFilmInfoMapper allFilmInfoMapper;


    /**
     * 首页
     *
     * @return
     */
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

            return new FilmIndexVo("http://img.meetingshop.cn/", 0, map);

        } catch (Exception e) {
            e.printStackTrace();
            return new StatusVo(999, "系统出现异常，请联系管理员");
        }


    }

    /**
     * 查询接口
     *
     * @param conditionVo
     * @return
     */
    @Override
    public Vo getConditionList(FilmConditionVo conditionVo) {

        DataVo dataVo = new DataVo();
        try {
            HashMap<Object, Object> map = new HashMap<>();

            map.put("flag", true);

            //yearInfo
            map = getYearInfo(conditionVo.getYearId(), map);

            //catInfo
            map = getCatInfo(conditionVo.getCatId(), map);

            //SourceInfo
            map = getSourceInfo(conditionVo.getSourceId(), map);

            //-----------------------
            Boolean flag = (Boolean) map.get("flag");

            map.remove("flag");
            if (flag == false) {

                return new StatusVo(1, "查询失败，无条件可加载");
            }
            //------------------------

            dataVo = new DataVo(0, map);

        } catch (Exception e) {
            e.printStackTrace();
            return new StatusVo(999, "系统出现异常，请联系管理员");
        }

        return dataVo;

    }

    /**
     * 查询
     *
     * @param filmGetVo
     * @return
     */
    @Override
    public Vo getFilms(FilmGetVo filmGetVo) {

        List<FilmInfo> filmInfos = new ArrayList<>();

        EntityWrapper<MtimeFilmT> entityWrapper = new EntityWrapper<>();

        if (filmGetVo.getSortId() == 1) {
            entityWrapper.orderBy("film_box_office");
        } else if (filmGetVo.getSortId() == 2) {
            entityWrapper.orderBy("film_date");
        } else if (filmGetVo.getSortId() == 3) {
            entityWrapper.orderBy("film_score");
        }
        entityWrapper.eq("film_status",filmGetVo.getShowType());

        Page<MtimeFilmT> page = new Page<>(filmGetVo.getNowPage(), filmGetVo.getPageSize());
        if (filmGetVo.getSourceId() != 99){
            entityWrapper.eq("film_source", filmGetVo.getSourceId());
        }
        if (filmGetVo.getYearId()!=99){
            entityWrapper.eq("film_date", filmGetVo.getYearId());
        }
        if (filmGetVo.getCatId()!=99){
            String catStr = "#" + filmGetVo.getCatId() + "#";
            entityWrapper.like("film_cats", catStr);
        }



        List<MtimeFilmT> mtimeFilms = mtimeFilmTMapper.selectPage(page, entityWrapper);

        filmInfos = getFilmInfos(mtimeFilms, filmInfos);
        Integer totalCount = mtimeFilmTMapper.selectCount(entityWrapper);
        int totalPages = (totalCount / filmGetVo.getPageSize()) + 1;

        return new FilmQueryVo(0, "http://img.meetingshop.cn/", filmGetVo.getNowPage(), totalPages, filmInfos);

    }

    /**
     * 影片详情
     *
     * @param id
     * @param searchType
     * @return
     */
    @Override
    public Vo getFilmDetails(String id, int searchType) {
        int filmId = 0;
        String name = null;
        if (id == null) {
            return new StatusVo(999, "系统出现异常，请联系管理员");
        }
        if (searchType == 0) {
            filmId = Integer.parseInt(id);
        } else {
            name = "%" + id + "%";
        }
        AllFilmInfo allFilmInfo = null;
        try {
            allFilmInfo = allFilmInfoMapper.getFilmDetails(name, filmId);
        } catch (Exception e) {
            e.printStackTrace();
            return new StatusVo(1, "查询失败，无影片可加载");
        }

        FilmDetails filmDetails = null;
        try {
            filmDetails = getDetails(allFilmInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new StatusVo(999, "系统出现异常，请联系管理员");
        }

        FilmIndexVo filmIndexVo = new FilmIndexVo("http://img.meetingshop.cn/", 0, filmDetails);
        return filmIndexVo;
    }

    /**
     * 重新封装filmDetails
     *
     * @return
     */
    private FilmDetails getDetails(AllFilmInfo allFilmInfo) {
        FilmDetails filmDetails = new FilmDetails();
        filmDetails.setFilmId(allFilmInfo.getFilmId());
        filmDetails.setFilmName(allFilmInfo.getFilmName());
        filmDetails.setFilmEnName(allFilmInfo.getFilmEnName());
        filmDetails.setImgAddress("img/"+allFilmInfo.getImgAddress());
        //filmDetails.setImgAddress("img/films/23412.jpg");
        filmDetails.setScore(allFilmInfo.getScore());
        filmDetails.setScoreNum(String.valueOf(allFilmInfo.getScoreNum()) + " 万人评分");
        filmDetails.setTotalBox((String.valueOf(allFilmInfo.getTotalBox() * 1.0 / 10000)) + " 亿");

        String[] cats = allFilmInfo.getCats().split("#");
        List<Integer> ids = new ArrayList<>();
        for (int i = 1; i < cats.length; i++) {
            ids.add(Integer.parseInt(cats[i]));
        }
        String info = mtimeCatDictTMapper.queryNameById(ids).toString();
        String info01 = info.substring(1, info.length() - 1);

        filmDetails.setInfo01(info01);
        String info02 = allFilmInfo.getFilmSource() + " / " + allFilmInfo.getFilmLength() + " 分钟";
        String info03 = allFilmInfo.getFilmTime().toString() + allFilmInfo.getFilmArea() + "上映";
        filmDetails.setInfo02(info02);
        filmDetails.setInfo03(info03);
        //info04下的actors
        Map<String, Object> info04 = new HashMap<>();
        info04.put("biography", allFilmInfo.getBiography());
        //actors下的director
        Map<String, Object> director = new HashMap<>();
        int idddd=allFilmInfo.getDirectorId();
        MtimeActorT dire_actor =allFilmInfoMapper.getDirectorById(idddd) ;
        director.put("directorName", dire_actor.getActorName());
        director.put("imgAddress0", dire_actor.getActorImg());

        //所有的actor
        List<Actor> allActors = allFilmInfoMapper.getActorsById(Integer.valueOf(allFilmInfo.getFilmId()),allFilmInfo.getDirectorId());
        Map<String, Object> actors = new HashMap<>();
        actors.put("director ", director);
        actors.put("actors", allActors);

        info04.put("actors", actors);
        filmDetails.setInfo04(info04);

        //imgVo
        Map<String, String> imgVo = new HashMap<>();
        String[] imgs = allFilmInfo.getImgVo().split(",");
        for (int i = 0; i < imgs.length; i++) {
            if (i == 0) {
                imgVo.put("mainImg", imgs[i]);
            } else {
                imgVo.put("img0" + i, imgs[i]);
            }
        }
        filmDetails.setImgVo(imgVo);
        return filmDetails;
    }

    /**
     * 重新封装filmInfo
     *
     * @param mtimeFilms
     * @param filmInfos
     * @return
     */
    private List<FilmInfo> getFilmInfos(List<MtimeFilmT> mtimeFilms, List<FilmInfo> filmInfos) {
        for (MtimeFilmT f : mtimeFilms) {
            FilmInfo filmInfo = new FilmInfo(f.getUuid(), f.getFilmType(), f.getImgAddress(), f.getFilmName(), f.getFilmScore());
            filmInfos.add(filmInfo);
        }
        return filmInfos;
    }

    /**
     * sourceInfo
     *
     * @param sourceId
     * @param map
     * @return
     */
    private HashMap<Object, Object> getSourceInfo(Integer sourceId, HashMap<Object, Object> map) {
        List<Source> sourceInfo = new ArrayList<>();
        EntityWrapper<MtimeSourceDictT> entityWrapper = new EntityWrapper<>();
        entityWrapper.orderBy("UUID");
        List<MtimeSourceDictT> mtimeSourceDictTS = mtimeSourceDictTMapper.selectList(entityWrapper);
        for (MtimeSourceDictT m : mtimeSourceDictTS) {
            boolean flag = false;
            if (m.getUuid().equals(sourceId)) {
                flag = true;
            }
            Source source = new Source(m.getUuid(), m.getShowName(), flag);
            sourceInfo.add(source);
        }


        if (sourceInfo.size() == 0) {
            map.replace("flag", false);
        }

        map.put("sourceInfo", sourceInfo);
        return map;
    }

    /**
     * catInfo
     *
     * @param catId
     * @param map
     * @return
     */
    private HashMap<Object, Object> getCatInfo(Integer catId, HashMap<Object, Object> map) {

        EntityWrapper<MtimeCatDictT> entityWrapper = new EntityWrapper<>();

        entityWrapper.orderBy("UUID");

        List<MtimeCatDictT> mtimeCatDictTS = mtimeCatDictTMapper.selectList(entityWrapper);

        List<Cat> catInfo = new ArrayList<>();

        for (MtimeCatDictT m : mtimeCatDictTS) {
            boolean flag = false;
            if (m.getUuid().equals(catId)) {
                flag = true;
            }

            Cat cat = new Cat(m.getUuid(), m.getShowName(), flag);
            catInfo.add(cat);
        }

        if (catInfo.size() == 0) {
            map.replace("flag", false);
        }

        map.put("catInfo", catInfo);
        return map;
    }

    /**
     * yearInfo
     *
     * @param yearId
     * @param map
     * @return
     */
    private HashMap<Object, Object> getYearInfo(Integer yearId, HashMap<Object, Object> map) {

        EntityWrapper<MtimeYearDictT> entityWrapper = new EntityWrapper<>();

        entityWrapper.orderBy("UUID");

        List<MtimeYearDictT> mtimeYearDictTS = mtimeYearDictTMapper.selectList(entityWrapper);

        List<Year> yearInfo = new ArrayList<>();

        for (MtimeYearDictT m : mtimeYearDictTS) {
            boolean flag = false;
            if (m.getUuid().equals(yearId)) {
                flag = true;
            }
            Year year = new Year(m.getUuid(), m.getShowName(), flag);
            yearInfo.add(year);
        }
        if (yearInfo.size() == 0) {
            map.replace("flag", false);
        }

        map.put("yearInfo", yearInfo);
        return map;
    }

    /**
     * top100
     *
     * @param map
     * @return
     */
    private HashMap<Object, Object> getTop100(HashMap<Object, Object> map) {

        List<TopFilm> top100 = new ArrayList<>();
        EntityWrapper<MtimeFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.ne("film_status", 2);
        entityWrapper.orderBy("film_score",false);
        Page<MtimeFilmT> page = new Page<>(0, 100);
        List<MtimeFilmT> mtimeFilmTS = mtimeFilmTMapper.selectPage(page, entityWrapper);
        for (MtimeFilmT m : mtimeFilmTS) {
            TopFilm topFilm = new TopFilm(m.getUuid(), m.getImgAddress(), m.getFilmName(), m.getFilmScore());
            top100.add(topFilm);
        }
        map.put("top100", top100);
        return map;
    }

    /**
     * expectRanking
     *
     * @param map
     * @return
     */
    private HashMap<Object, Object> getExpectRanking(HashMap<Object, Object> map) {


        List<ExpectRankFilm> expectRanking = new ArrayList<>();
        EntityWrapper<MtimeFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status", 2);
        entityWrapper.orderBy("film_preSaleNum", false);
        List<MtimeFilmT> mtimeFilmTS = mtimeFilmTMapper.selectList(entityWrapper);
        for (MtimeFilmT m : mtimeFilmTS) {
            ExpectRankFilm expectRankFilm = new ExpectRankFilm(m.getUuid(), m.getImgAddress(), m.getFilmName(), m.getFilmPresalenum());
            expectRanking.add(expectRankFilm);
        }
        map.put("expectRanking", expectRanking);
        return map;
    }

    /**
     * BoxRanking
     *
     * @param map
     * @return
     */
    private HashMap<Object, Object> getBoxRanking(HashMap<Object, Object> map) {
        List<BoxRankFilm> boxRanking = new ArrayList<>();
        EntityWrapper<MtimeFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.orderBy("film_box_office", false);
        entityWrapper.eq("film_status", 1);
        List<MtimeFilmT> mtimeFilmTS = mtimeFilmTMapper.selectList(entityWrapper);
        for (MtimeFilmT m : mtimeFilmTS) {
            BoxRankFilm boxRankFilm = new BoxRankFilm(m.getUuid(), m.getImgAddress(), m.getFilmName(), m.getFilmBoxOffice());
            boxRanking.add(boxRankFilm);
        }
        map.put("boxRanking", boxRanking);
        return map;
    }

    /**
     * soonFilm
     *
     * @param map
     * @return
     */
    private HashMap<Object, Object> getSoonFilm(HashMap<Object, Object> map) {

        List<SoonFilm> filmInfo = new ArrayList<>();
        EntityWrapper<MtimeFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status", 2);
        Integer filmNum = mtimeFilmTMapper.selectCount(entityWrapper);
        entityWrapper.orderBy("film_time");
        List<MtimeFilmT> mtimeFilmTS = mtimeFilmTMapper.selectList(entityWrapper);
        for (MtimeFilmT m : mtimeFilmTS) {
            SoonFilm soonFilm = new SoonFilm(m.getUuid(), m.getFilmType(), m.getImgAddress(), m.getFilmName(), m.getFilmPresalenum(), m.getFilmTime());
            filmInfo.add(soonFilm);
        }


        HashMap<Object, Object> soonFilms = new HashMap<>();
        if (filmInfo.size() == 0 && filmNum == 0) {
            soonFilms.put("filmNum", 0);
            soonFilms.put("filmInfo", null);
        } else {
            soonFilms.put("filmNum", filmNum);
            soonFilms.put("filmInfo", filmInfo);
        }

        map.put("soonFilms", soonFilms);
        return map;
    }

    /**
     * hotFilm
     *
     * @param map
     * @return
     */
    private HashMap<Object, Object> getHotFilm(HashMap<Object, Object> map) {


        EntityWrapper<MtimeFilmT> entityWrapper = new EntityWrapper<>();

        entityWrapper.eq("film_status", 1);
        entityWrapper.ge("film_score", 8.5);

        Integer filmNum = mtimeFilmTMapper.selectCount(entityWrapper);
        entityWrapper.orderBy("film_box_office", false);
        List<MtimeFilmT> mtimeFilmTS = mtimeFilmTMapper.selectList(entityWrapper);
        List<HotFilm> filmInfo = new ArrayList<>();
        for (MtimeFilmT m : mtimeFilmTS) {
            HotFilm hotFilm = new HotFilm(m.getUuid(), m.getFilmType(), m.getImgAddress(), m.getFilmName(), m.getFilmScore());
            filmInfo.add(hotFilm);
        }

        HashMap<Object, Object> hotFilms = new HashMap<>();
        hotFilms.put("filmInfo", filmInfo);
        hotFilms.put("filmNum", filmNum);
        map.put("hotFilms", hotFilms);
        return map;


    }

}
