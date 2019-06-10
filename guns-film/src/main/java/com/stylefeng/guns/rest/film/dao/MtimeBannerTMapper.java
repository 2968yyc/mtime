package com.stylefeng.guns.rest.film.dao;

import com.stylefeng.guns.rest.film.bean.rebuild.Banner;
import com.stylefeng.guns.rest.film.bean.MtimeBannerT;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * banner信息表 Mapper 接口
 * </p>
 *
 * @author cskaoyan
 * @since 2019-06-04
 */
public interface MtimeBannerTMapper extends BaseMapper<MtimeBannerT> {


    List<Banner> queryAllBanner();
    List<Banner> selectAllBanner();
}
