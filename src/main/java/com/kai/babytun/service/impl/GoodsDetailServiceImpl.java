package com.kai.babytun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kai.babytun.entity.GoodsDetail;
import com.kai.babytun.mapper.GoodsDetailMapper;
import com.kai.babytun.service.IGoodsDetailService;
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
public class GoodsDetailServiceImpl extends ServiceImpl<GoodsDetailMapper, GoodsDetail> implements IGoodsDetailService {

    @Autowired
    private GoodsDetailMapper goodsDetailMapper;

    @Override
    public List<GoodsDetail> findDetailsById(Long goodsId) {
        return goodsDetailMapper.findDetailsById(goodsId);
    }
}
