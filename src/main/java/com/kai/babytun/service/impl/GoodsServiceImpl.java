package com.kai.babytun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kai.babytun.entity.Goods;
import com.kai.babytun.mapper.GoodsMapper;
import com.kai.babytun.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kai
 * @since 2021-04-27
 */
@Service
@Primary
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    @Cacheable(value = "goods", key = "#goodsId")
    public Goods getGoods(long goodsId) {
        return goodsMapper.findById(goodsId);
    }
}
