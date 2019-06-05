package com.stylefeng.guns.rest.film.dao;

import com.stylefeng.guns.rest.film.bean.MtimeSourceDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.film.bean.rebuild.Source;

import java.util.List;

/**
 * <p>
 * 区域信息表 Mapper 接口
 * </p>
 *
 * @author cskaoyan
 * @since 2019-06-04
 */
public interface MtimeSourceDictTMapper extends BaseMapper<MtimeSourceDictT> {

    /**
     * queryAllSource
     *
     * @return
     */
    List<Source> queryAllSource();
}
