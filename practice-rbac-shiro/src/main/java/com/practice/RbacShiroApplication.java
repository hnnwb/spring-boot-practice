package com.practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author nn
 */
@SpringBootApplication
@MapperScan("com.practice.rbac.shiro.mapper")
public class RbacShiroApplication {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}