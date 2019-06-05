package com.stylefeng.guns.rest.film.dao;

import com.stylefeng.guns.rest.film.bean.MtimeFilmT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.film.bean.rebuild.*;

import java.util.List;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author cskaoyan
 * @since 2019-06-04
 */
public interface MtimeFilmTMapper extends BaseMapper<MtimeFilmT> {

    /**
     * hotFilmCount
     * @param status
     *
     * @return
     */
    int queryHotFilmCount(int status);

    /**
     * hotFilm
     * @param status
     *
     * @return
     */
    List<HotFilm> queryHotFilm(int status);

    /**
     * soonFilmCount
     * @param status
     *
     * @return
     */
    int querySoonFilmCount(int status);
    /**
     * soonFilm
     * @param status
     *
     * @return
     */
    List<SoonFilm> querySoonFilm(int status);

    /**
     * boxRankFilm
     * @return
     */
    List<BoxRankFilm> queryBoxRankFilm();

    /**
     * expectRankFilm
     * @return
     */
    List<ExpectRankFilm> getExpectRankFilm();

    /**
     * top100Film
     * @return
     */
    List<TopFilm> getTopFilm();
}
