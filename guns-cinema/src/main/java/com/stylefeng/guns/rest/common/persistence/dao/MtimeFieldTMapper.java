package com.stylefeng.guns.rest.common.persistence.dao;

import com.cskaoyan.bean.cinema.FilmInfoVo;
import com.cskaoyan.bean.cinema.HallInfo;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFieldT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 放映场次表 Mapper 接口
 * </p>
 *
 * @author alan
 * @since 2019-06-04
 */
public interface MtimeFieldTMapper extends BaseMapper<MtimeFieldT> {

    List<FilmInfoVo> selectFilmInfoByCinemaId(@Param("cinemaId") int cinemaId);

    HallInfo selectHallInfoByFieldId(@Param("fieldId") int fieldId);

    FilmInfoVo selectFilmInfoByCinemaIdAndFieldId(@Param("cinemaId") int cinemaId, @Param("fieldId") int fieldId);

    String getSeatsByFieldId(@Param("fieldId") int fieldId);
}
