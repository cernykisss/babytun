package com.kai.babytun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kai.babytun.entity.Goods;

import java.util.List;

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

    List<Goods> findAll();

    List<Goods> findLast5M();
}
