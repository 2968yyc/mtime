package com.stylefeng.guns.rest.film.dao;

import com.cskaoyan.bean.filmNew.ActorVO;
import com.stylefeng.guns.rest.film.bean.MtimeActorT;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 演员表 Mapper 接口
 * </p>
 *
 * @author cskaoyan
 * @since 2019-06-04
 */
public interface MtimeActorTMapper extends BaseMapper<MtimeActorT> {
    List<ActorVO> getActors(String filmId);
}
