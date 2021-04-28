package com.kai.babytun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kai.babytun.entity.GoodsCover;
import com.kai.babytun.mapper.GoodsCoverMapper;
import com.kai.babytun.service.IGoodsCoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

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
public class GoodsCoverServiceImpl extends ServiceImpl<GoodsCoverMapper, GoodsCover> implements IGoodsCoverService {

    @Autowired
    private GoodsCoverMapper goodsCoverMapper;

    @Override
    @Cacheable(value = "covers", key = "#goodsId")
    public List<GoodsCover> findCovers(Long goodsId) {
        return goodsCoverMapper.findByGoodsId(goodsId);
    }
}
