package com.kai.babytun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kai.babytun.entity.GoodsCover;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kai
 * @since 2021-04-27
 */
public interface IGoodsCoverService extends IService<GoodsCover> {

    List<GoodsCover> findCovers(Long goodsId);

}
