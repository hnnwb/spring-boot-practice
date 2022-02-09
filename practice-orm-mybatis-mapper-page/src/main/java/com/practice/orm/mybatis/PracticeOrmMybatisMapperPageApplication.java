package com.practice.orm.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.practice.orm.mybatis.mapper")
public class PracticeOrmMybatisMapperPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeOrmMybatisMapperPageApplication.class, args);
    }

}
