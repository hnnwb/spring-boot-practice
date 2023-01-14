package com.practice.task.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Hello world!
 *
 * @author wb
 */
@MapperScan(basePackages = {"com.practice.task.quartz.mapper"})
@SpringBootApplication
public class PracticeTaskQuartzApplication {
     public static void main(String[] args) {
        SpringApplication.run(PracticeTaskQuartzApplication.class, args);
    }
}
