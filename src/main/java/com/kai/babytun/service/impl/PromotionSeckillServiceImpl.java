package com.kai.babytun.service.impl;

import com.kai.babytun.entity.Order;
import com.kai.babytun.entity.PromotionSecKill;
import com.kai.babytun.exception.SeckillException;
import com.kai.babytun.mapper.PromotionSecKillMapper;
import com.kai.babytun.service.IPromotionSecKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PromotionSeckillServiceImpl implements IPromotionSecKillService {

    @Autowired
    private PromotionSecKillMapper promotionSecKillMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void processSeckill(Long psId, String userId, Integer num) throws SeckillException {
        PromotionSecKill ps = promotionSecKillMapper.findById(psId);
        if (ps == null) {
            throw new SeckillException("秒杀活动不存在");
        }
        if (ps.getStatus() == 0) {
            throw new SeckillException("秒杀活动还未开始");
        } else if (ps.getStatus() == 2) {
            throw new SeckillException("秒杀活动已经结束");
        }
        //秒杀list弹出商品
        Integer goodsId = (Integer) redisTemplate.opsForList().leftPop("seckill:count:" + ps.getPsId());
        //在抢到的用户set中添加用户
        if (goodsId != null) {
            Boolean isExisted = redisTemplate.opsForSet().isMember("seckill:users:" + ps.getPsId(), userId);
            //判断是否已经抢购 判断set中有没有
            if (isExisted) {
                //把预减的商品放回来
                redisTemplate.opsForList().rightPush("seckill:count:" + ps.getPsId(), ps.getGoodsId());
                throw new SeckillException("重复抢购");
            } else {
            //没有往set里加
                System.out.println("success");
                redisTemplate.opsForSet().add("seckill:users:" + ps.getPsId(), userId);
            }
        } else {
            throw new SeckillException("没抢到");
        }
    }

}
