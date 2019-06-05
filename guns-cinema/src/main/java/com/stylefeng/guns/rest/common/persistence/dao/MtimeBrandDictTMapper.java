package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimeBrandDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 品牌信息表 Mapper 接口
 * </p>
 *
 * @author xf
 * @since 2019-06-04
 */
public interface MtimeBrandDictTMapper extends BaseMapper<MtimeBrandDictT> {
    List<MtimeBrandDictT> selectBeanById(@Param("brandId") String id);

}
