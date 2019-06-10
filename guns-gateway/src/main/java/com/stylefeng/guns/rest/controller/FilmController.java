package com.stylefeng.guns.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cskaoyan.bean.film.FilmConditionVo;
import com.cskaoyan.bean.film.FilmGetVo;
import com.cskaoyan.bean.filmNew.*;
import com.cskaoyan.bean.vo.StatusVo;
import com.cskaoyan.bean.vo.Vo;

import com.cskaoyan.bean.vo.film.FilmIndexVo;
import com.cskaoyan.service.FilmService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/6/4 20:23
 */
@RestController
@RequestMapping("film")
public class FilmController {

    @Reference(check = false)
    FilmService filmService;

    /**
     *   获取首页信息接口
     *    banner
     *    hotFilm
     *    soonFilm
     *    boxRank
     *    expectRank
     *    top100
     */
    @RequestMapping(value = "getIndex",method = RequestMethod.GET)
    public Vo getIndex(){
        Vo index = new Vo();
        try {
           index = filmService.getIndex();
        }catch (Exception e){
            e.printStackTrace();
        }

        return index;
    }

    /**
     *   影片条件列表查询接口
     *   catInfo
     *   sourceInfo
     *   yearInfo
     */
    @RequestMapping(value = "getConditionList",method = RequestMethod.GET)
    public Vo getConditionList(FilmConditionVo filmConditionVo){



        return filmService.getConditionList(filmConditionVo);
    }

    /**
     *   影片查询接口
     */

    @RequestMapping(value = "getFilms",method = RequestMethod.GET)
    public Vo getFilms(FilmGetVo filmGetVo){
        return filmService.getFilms(filmGetVo);
    }

    /**
     * 影片详情接口
     * yyc重写该方法
     * 测试通过。有少量图片加载不出来
     */
    @RequestMapping(value = "films/{id}",method = RequestMethod.GET)
    public Vo getFilms(@PathVariable("id")String id,Integer searchType){
//        return filmService.getFilmDetails(id,searchType);
        try {
            FilmDetailVO filmDetailVO = filmService.getFilmDetail(id, searchType);
            if (filmDetailVO==null){
                return new StatusVo(1,"查询失败，无影片可加载");
            }
            InfoResponseVO infoResponseVO = new InfoResponseVO();
            //获取影片描述信息
            String filmId = filmDetailVO.getFilmId();
            FilmDescVO filmDesc = filmService.getFilmDesc(filmId);
            //获取图片信息
            ImgVO imgs = filmService.getImgs(filmId);
            //获取演员信息
            ActorVO directorDesc = filmService.getDirectorDesc(filmId);
            List<ActorVO> actors = filmService.getActors(filmId);
            ActorResponseVO actorResponseVO = new ActorResponseVO();
            actorResponseVO.setActors(actors);
            actorResponseVO.setDirector(directorDesc);

            infoResponseVO.setActors(actorResponseVO);
            infoResponseVO.setBiography(filmDesc.getBiography());
            infoResponseVO.setFilmId(filmId);
            infoResponseVO.setImgVO(imgs);

            filmDetailVO.setInfo04(infoResponseVO);
            return new FilmIndexVo("http://img.meetingshop.cn/", 0, filmDetailVO);
        }catch(Exception e){
            e.printStackTrace();
            return new StatusVo(999,"系统出现异常，请联系管理");
        }
    }

}
