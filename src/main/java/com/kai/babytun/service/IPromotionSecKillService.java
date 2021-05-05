package com.kai.babytun.service;

import com.kai.babytun.exception.SeckillException;
import org.springframework.stereotype.Service;

public interface IPromotionSecKillService {

    void processSeckill(Long psId, String userId, Integer num) throws SeckillException;
}
