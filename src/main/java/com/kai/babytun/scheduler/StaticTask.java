package com.kai.babytun.scheduler;

import com.kai.babytun.entity.Goods;
import com.kai.babytun.service.IGoodsCoverService;
import com.kai.babytun.service.IGoodsDetailService;
import com.kai.babytun.service.IGoodsParamService;
import com.kai.babytun.service.IGoodsService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

//自动静态化
@Component //组件类 IOC容器扫描到后会自动实例加载
public class StaticTask {

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

    //* * * * * ?每秒钟执行一次
    //秒 分钟 小时 日 月 星期
    //* 代表所有时间
    @Scheduled(cron = "* * * * * ?")
    public void doStatic() throws IOException, TemplateException {
        Template template = freemarkerConfig.getTemplate("goods.html");
        List<Goods> updatedGoods = goodsService.findLast5M();
        for (Goods goods: updatedGoods) {
            Long gid = goods.getGoodsId();
            HashMap<Object, Object> map = new HashMap<>();
            map.put("goods", goods);
            map.put("details", goodsDetailService.findDetailsById(gid));
            map.put("covers", goodsCoverService.findCovers(gid));
            map.put("param", goodsParamService.findParamByGoodsId(gid));
            File target = new File("d:/IdeaProjects/babytun-static/" + gid + ".html");
            FileWriter fileWriter = new FileWriter(target);
            template.process(map, fileWriter);
            fileWriter.close();
            System.out.println(gid + "已被生成");
        }
    }
}
