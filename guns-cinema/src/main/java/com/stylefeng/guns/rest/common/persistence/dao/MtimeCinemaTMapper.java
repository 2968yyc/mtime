package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimeCinemaT;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 影院信息表 Mapper 接口
 * </p>
 *
 * @author xf
 * @since 2019-06-04
 */
public interface MtimeCinemaTMapper extends BaseMapper<MtimeCinemaT> {
    List<MtimeCinemaT> selectCinemaByOptions(String brandId,String districtId,String hallType);

}
