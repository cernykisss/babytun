package com.kai.babytun.controller;

import com.kai.babytun.entity.Order;
import com.kai.babytun.entity.PromotionSecKill;
import com.kai.babytun.exception.SeckillException;
import com.kai.babytun.service.IOrderService;
import com.kai.babytun.service.impl.PromotionSeckillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SecKillController {

    @Autowired
    private PromotionSeckillServiceImpl promotionSeckillService;

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/seckillIndex")
    public String secKillPage() {
        return "seckill";
    }

    @RequestMapping("/seckill")
    @ResponseBody
    public Map seckill(Long psId, String userId) {
        HashMap<Object, Object> result = new HashMap<>();
        try {
            //成功
            promotionSeckillService.processSeckill(psId, userId,1);
            String orderNo = orderService.sendOrderToQueue(userId);
            HashMap<Object, Object> data = new HashMap<>();
            data.put("orderNo", orderNo);
            result.put("data", data);
            result.put("code", "0");
            result.put("message", "success");
        } catch (SeckillException e) {
            result.put("code", "500");
            result.put("message", e.getMessage());
        }
        return result;
    }

    @GetMapping("/checkorder")
    public ModelAndView checkOrder(String orderNo) {
        Order order = orderService.findByOrderNo(orderNo);
        ModelAndView mav = new ModelAndView();
        if (order != null) {
            mav.addObject("order", order);
            mav.setViewName("/order");
        } else {
            mav.addObject("orderNo", orderNo);
            mav.setViewName("/waiting");
        }
        return mav;
    }
}
