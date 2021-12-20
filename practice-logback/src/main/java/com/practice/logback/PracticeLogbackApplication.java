package com.practice.logback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class PracticeLogbackApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PracticeLogbackApplication.class, args);
        int length = context.getBeanDefinitionNames().length;
        log.trace("spring boot启动初始化了{}个bean",length);
        log.debug("spring boot启动初始化了{}个bean",length);
        log.info("spring boot启动初始化了{}个bean",length);
        log.warn("spring boot启动初始化了{}个bean",length);
        log.error("spring boot启动初始化了{}个bean",length);
        try {
            int i = 0;
            //int j = 1/i;
        } catch (Exception e) {
            log.error("PracticeLogbackApplication启动异常：",e);
        }
    }

}
