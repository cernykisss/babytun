package com.kai.babytun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kai.babytun.entity.Evaluate;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kai
 * @since 2021-04-27
 */
public interface IEvaluateService extends IService<Evaluate> {

    List<Evaluate> findEvalsByGoodsId(Long gid);

}
