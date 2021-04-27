package com.kai.babytun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kai.babytun.entity.GoodsDetail;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kai
 * @since 2021-04-27
 */
public interface GoodsDetailMapper extends BaseMapper<GoodsDetail> {

    List<GoodsDetail> findDetailsById(Long goodsId);

}
