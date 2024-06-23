package com.twShop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.twShop.dao")
public class TwShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwShopApplication.class, args);
    }

}
