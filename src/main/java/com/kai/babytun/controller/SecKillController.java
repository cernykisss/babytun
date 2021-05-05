package com.kai.babytun.controller;

import com.kai.babytun.entity.PromotionSecKill;
import com.kai.babytun.exception.SeckillException;
import com.kai.babytun.service.impl.PromotionSeckillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SecKillController {

    @Autowired
    private PromotionSeckillServiceImpl promotionSeckillService;

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
            result.put("code", "0");
            result.put("message", "success");
        } catch (SeckillException e) {
            result.put("code", "500");
            result.put("message", e.getMessage());
        }
        return result;
    }
}
