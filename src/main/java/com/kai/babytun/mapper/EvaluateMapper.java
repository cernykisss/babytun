package com.kai.babytun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kai.babytun.entity.Evaluate;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kai
 * @since 2021-04-27
 */
public interface EvaluateMapper extends BaseMapper<Evaluate> {

    List<Evaluate> findByGoodsId(Long gid);
}
