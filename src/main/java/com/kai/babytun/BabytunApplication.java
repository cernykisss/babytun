package com.kai.babytun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.kai.babytun")
public class BabytunApplication {

    public static void main(String[] args) {
        SpringApplication.run(BabytunApplication.class, args);
    }

}
