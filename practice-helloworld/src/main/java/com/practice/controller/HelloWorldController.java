package com.practice.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wbnn
 * @Date: 2021/12/07/
 * @Description:
 */
@RestController
public class HelloWorldController {


    @GetMapping("/hello")
    public String helloWorld(@RequestParam(required = false) String name){
        if (ObjectUtil.isEmpty(name)) {
            name = "world";
        }
        return StrUtil.format("Hello,{}",name);
    }
}
