package com.stylefeng.guns.rest.film.dao;

import com.stylefeng.guns.rest.film.bean.MtimeCatDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.film.bean.rebuild.Cat;

import java.util.List;

/**
 * <p>
 * 类型信息表 Mapper 接口
 * </p>
 *
 * @author cskaoyan
 * @since 2019-06-04
 */
public interface MtimeCatDictTMapper extends BaseMapper<MtimeCatDictT> {

    /**
     * queryAllCat
     * @return
     */
    List<Cat> queryAllCat();
}
