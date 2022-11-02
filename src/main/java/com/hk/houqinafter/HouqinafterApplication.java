package com.hk.houqinafter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hk.houqinafter.mapper")
public class HouqinafterApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouqinafterApplication.class, args);
    }

}