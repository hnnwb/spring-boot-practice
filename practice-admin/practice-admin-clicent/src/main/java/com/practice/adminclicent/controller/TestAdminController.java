package com.practice.adminclicent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wbnn
 * @Date: 2021/12/09/
 * @Description:
 */
@RestController
public class TestAdminController {

    @GetMapping("testAdmin")
    public String testAdmin(){
        return "这是一个 spring-boot-admin客户端";
    }
}
