package com.kai.babytun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kai.babytun.entity.GoodsParam;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kai
 * @since 2021-04-27
 */
public interface GoodsParamMapper extends BaseMapper<GoodsParam> {

    List<GoodsParam> findParamByGoodsId(Long goodsId);

}
