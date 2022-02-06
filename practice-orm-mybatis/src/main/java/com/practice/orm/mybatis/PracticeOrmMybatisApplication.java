package com.practice.orm.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.practice.orm.mybatis.mapper"})
@SpringBootApplication
public class PracticeOrmMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeOrmMybatisApplication.class, args);
        System.out.println("测试推送！！！！！！！！！");
    }

}
