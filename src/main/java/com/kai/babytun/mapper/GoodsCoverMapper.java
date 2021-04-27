package com.kai.babytun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kai.babytun.entity.GoodsCover;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kai
 * @since 2021-04-27
 */
public interface GoodsCoverMapper extends BaseMapper<GoodsCover> {

    List<GoodsCover> findByGoodsId(Long goodsId);

}
