package com.kai.babytun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kai.babytun.entity.Order;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kai
 * @since 2021-05-06
 */
public interface OrderMapper extends BaseMapper<Order> {

    Order findByOrderNo(String orderNo);

}
