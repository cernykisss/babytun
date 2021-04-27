package com.kai.babytun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kai.babytun.entity.GoodsParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kai
 * @since 2021-04-27
 */
public interface IGoodsParamService extends IService<GoodsParam> {
    List<GoodsParam> findParamByGoodsId(Long goodsId);

}
