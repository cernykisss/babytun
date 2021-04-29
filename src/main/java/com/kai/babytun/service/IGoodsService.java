package com.kai.babytun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kai.babytun.entity.Goods;
import com.kai.babytun.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kai
 * @since 2021-04-27
 */
public interface IGoodsService extends IService<Goods> {

    Goods getGoods(long goodsId);

    List<Goods> findAll();

    List<Goods> findLast5M();

}
