package com.kai.babytun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kai.babytun.entity.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kai
 * @since 2021-05-06
 */
public interface IOrderService extends IService<Order> {

    String sendOrderToQueue(String userId);

    Order findByOrderNo(String orderNo);

}
