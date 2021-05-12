package com.kai.babytun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan("com.kai.babytun")
@EnableCaching//开启声明式缓存 利用注解开启缓存读写 配合@Cacheable注解使用
@EnableScheduling //启用任务调动
@EnableRedisHttpSession //redissession启用
public class BabytunApplication {

    public static void main(String[] args) {
        SpringApplication.run(BabytunApplication.class, args);
    }

}
