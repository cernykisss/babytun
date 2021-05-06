package com.kai.babytun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kai.babytun.entity.Order;
import com.kai.babytun.mapper.OrderMapper;
import com.kai.babytun.service.IOrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kai
 * @since 2021-05-06
 */
@Service
@Primary
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public String sendOrderToQueue(String userId) {
        System.out.println("准备向队列发送消息");
        //订单基本信息
        HashMap<Object, Object> data = new HashMap<>();
        data.put("userId", userId);
        String orderNo = UUID.randomUUID().toString();
        data.put("orderNo", orderNo);
        rabbitTemplate.convertAndSend("exchange-order", null, data);
        return orderNo;
    }

    @Override
    public Order findByOrderNo(String orderNo) {
        return orderMapper.findByOrderNo(orderNo);
    }
}
