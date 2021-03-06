package com.stylefeng.guns.rest.film.dao;

import com.cskaoyan.bean.filmNew.FilmDetailVO;
import com.stylefeng.guns.rest.film.bean.MtimeFilmT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.film.bean.rebuild.*;

import java.util.List;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author yyc
 * @since 2019-06-04
 */
public interface MtimeFilmTMapper extends BaseMapper<MtimeFilmT> {

    FilmDetailVO getFilmDetailByName(String filmName);
    FilmDetailVO getFilmDetailById(String uuid);

}
