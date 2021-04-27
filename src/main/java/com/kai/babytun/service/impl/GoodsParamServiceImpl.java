package com.kai.babytun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kai.babytun.entity.GoodsParam;
import com.kai.babytun.mapper.GoodsParamMapper;
import com.kai.babytun.service.IGoodsParamService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class GoodsParamServiceImpl extends ServiceImpl<GoodsParamMapper, GoodsParam> implements IGoodsParamService {

    @Autowired
    private GoodsParamMapper goodsParamMapper;

    @Override
    public List<GoodsParam> findParamByGoodsId(Long goodsId) {
        return goodsParamMapper.findParamByGoodsId(goodsId);
    }
}
