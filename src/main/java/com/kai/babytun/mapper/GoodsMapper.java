package com.kai.babytun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kai.babytun.entity.Goods;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kai
 * @since 2021-04-27
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    Goods findById(Long goodsId);

}
