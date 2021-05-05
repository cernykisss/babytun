package com.kai.babytun.mapper;

import com.kai.babytun.entity.PromotionSecKill;

import java.util.List;

public interface PromotionSecKillMapper {

    List<PromotionSecKill> findUnstartedSecKill();

    void update(PromotionSecKill promotionSecKill);

    PromotionSecKill findById(Long psId);
}
