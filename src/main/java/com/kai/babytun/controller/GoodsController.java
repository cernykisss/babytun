package com.kai.babytun.controller;


import com.kai.babytun.entity.Goods;
import com.kai.babytun.entity.GoodsCover;
import com.kai.babytun.entity.GoodsDetail;
import com.kai.babytun.entity.GoodsParam;
import com.kai.babytun.service.IGoodsCoverService;
import com.kai.babytun.service.IGoodsDetailService;
import com.kai.babytun.service.IGoodsParamService;
import com.kai.babytun.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kai
 * @since 2021-04-27
 */
@Controller
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private IGoodsCoverService goodsCoverService;

    @Autowired
    private IGoodsDetailService goodsDetailService;

    @Autowired
    private IGoodsParamService goodsParamService;

    @GetMapping("/goods") //localhost:8080/goods?gid=xxx
    public ModelAndView toGoods(Long gid) {
        ModelAndView mav = new ModelAndView("/goods");
        Goods goods = goodsService.getGoods(gid);
        List<GoodsCover> covers = goodsCoverService.findCovers(gid);
        List<GoodsDetail> details = goodsDetailService.findDetailsById(gid);
        List<GoodsParam> params = goodsParamService.findParamByGoodsId(gid);
        mav.addObject("goods", goods);
        mav.addObject("covers", covers);
        mav.addObject("details", details);
        mav.addObject("param", params);
        return mav;
    }
}
