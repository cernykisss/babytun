package com.kai.babytun.scheduler;

import com.kai.babytun.entity.PromotionSecKill;
import com.kai.babytun.mapper.PromotionSecKillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecKillTask {

    @Autowired
    private PromotionSecKillMapper promotionSecKillMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    //任务调度 自动扫描数据库
    @Scheduled(cron = "0/5 * * * * ?")
    public void startSecKill() {
        List<PromotionSecKill> unstartedSecKill = promotionSecKillMapper.findUnstartedSecKill();
        for (PromotionSecKill ps : unstartedSecKill) {
            System.out.println(ps.getPsId() + "is starting");
            //删除过期活动
            redisTemplate.delete("seckill:count:" + ps.getPsId());
            //有几个库存商品 初始化几个list对象
            for (Integer i = 0; i < ps.getPsCount(); i++) {
                redisTemplate.opsForList().rightPush("seckill:count:" + ps.getPsId(),
                        ps.getGoodsId());
            }
            ps.setStatus(1);
            promotionSecKillMapper.update(ps);
        }
    }

    //结束过期秒杀
    @Scheduled(cron = "0/5 * * * * ?")
    public void endExpiredSeckill() {
        List<PromotionSecKill> expiredSeckills = promotionSecKillMapper.findExpiredSeckill();
        for (PromotionSecKill expiredSeckill : expiredSeckills) {
            System.out.println(expiredSeckill.getPsId() + "已经结束");
            expiredSeckill.setStatus(2);
            promotionSecKillMapper.update(expiredSeckill);
            redisTemplate.delete("seckill:count:" + expiredSeckill.getPsId());
        }
    }
}
