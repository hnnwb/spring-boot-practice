package com.practice.orm.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.practice.orm.mybatis.mapper")
public class PracticeOrmMybatisMapperPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeOrmMybatisMapperPageApplication.class, args);
    }

}
