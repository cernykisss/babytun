package com.kai.babytun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kai.babytun.entity.Goods;
import com.kai.babytun.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kai
 * @since 2021-04-27
 */
public interface IGoodsService extends IService<Goods> {

    public Goods getGoods(long goodsId);

}
