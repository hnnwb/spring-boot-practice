package com.practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 * @author wb
 */
@SpringBootApplication
@MapperScan(basePackages = "com.practice.datasource.mybatis.mapper")
public class PracticeMultiDatasourceMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeMultiDatasourceMybatisApplication.class, args);
    }

}