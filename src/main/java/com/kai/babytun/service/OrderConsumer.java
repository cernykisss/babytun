package com.kai.babytun.service;

import com.kai.babytun.entity.Order;
import com.kai.babytun.mapper.OrderMapper;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Component
public class OrderConsumer {

    @Autowired
    private OrderMapper orderMapper;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "queue-order"),
                    exchange = @Exchange(value = "exchange-order", type = "fanout")
            )
    )
    @RabbitHandler
    public void handleMessage(@Payload Map data, Channel channel,
                              @Headers Map<String, Object> headers) {
        //消息确认
        try {
            try {
                //对接支付宝 物流平台 日志
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获取订单数据" + data);
            Order order = new Order();
            order.setOrderNo(data.get("orderNo").toString());
            order.setOrderStatus(0);
            order.setUserId(data.get("userId").toString());
            order.setRecvName("XXX");
            order.setRecvMobile("1234254352");
            order.setRecvAddress("fdafsdf");
            order.setAmount(19.8f);
            order.setPostage(0f);
            order.setCreateTime(new Date());
            orderMapper.insert(order);
            Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
            channel.basicAck(tag, false);
            System.out.println("订单" + order.getOrderNo() + "已创建");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
