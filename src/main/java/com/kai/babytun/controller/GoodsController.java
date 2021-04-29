package com.kai.babytun.controller;


import com.kai.babytun.entity.Goods;
import com.kai.babytun.entity.GoodsCover;
import com.kai.babytun.entity.GoodsDetail;
import com.kai.babytun.entity.GoodsParam;
import com.kai.babytun.service.IGoodsCoverService;
import com.kai.babytun.service.IGoodsDetailService;
import com.kai.babytun.service.IGoodsParamService;
import com.kai.babytun.service.IGoodsService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
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

    @Autowired
    private Configuration freemarkerConfig;

    @GetMapping("/goods/{gid}") //localhost:8080/goods?gid=xxx
    public ModelAndView toGoods(@PathVariable("gid") Long gid) {
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
    
    @GetMapping("/static/{gid}")
    @ResponseBody
    public String doStatic(@PathVariable("gid") Long gid) throws IOException, TemplateException {
        Template template = freemarkerConfig.getTemplate("goods.ftlh");
        HashMap<Object, Object> map = new HashMap<>();
        map.put("goods", goodsService.getGoods(gid));
        map.put("details", goodsDetailService.findDetailsById(gid));
        map.put("covers", goodsCoverService.findCovers(gid));
        map.put("param", goodsParamService.findParamByGoodsId(gid));
        File target = new File("d:/IdeaProjects/babytun-static/" + gid + ".html");
        FileWriter fileWriter = new FileWriter(target);
        template.process(map, fileWriter);
        return target.getPath();
    }

    @GetMapping("/static_all")
    @ResponseBody
    public String doStaticAll() throws IOException, TemplateException {
        Template template = freemarkerConfig.getTemplate("goods.ftlh");
        List<Goods> all = goodsService.findAll();
        for (Goods goods : all) {
            Long gid = goods.getGoodsId();
            HashMap<Object, Object> map = new HashMap<>();
            map.put("goods", goods);
            map.put("details", goodsDetailService.findDetailsById(gid));
            map.put("covers", goodsCoverService.findCovers(gid));
            map.put("param", goodsParamService.findParamByGoodsId(gid));
            File target = new File("d:/IdeaProjects/babytun-static/" + gid + ".html");
            FileWriter fileWriter = new FileWriter(target);
            template.process(map, fileWriter);
        }
        return "ok";
    }
}
