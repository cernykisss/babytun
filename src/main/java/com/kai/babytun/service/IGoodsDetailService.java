package com.kai.babytun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kai.babytun.entity.GoodsDetail;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kai
 * @since 2021-04-27
 */
public interface IGoodsDetailService extends IService<GoodsDetail> {

    List<GoodsDetail> findDetailsById(Long goodsId);

}
