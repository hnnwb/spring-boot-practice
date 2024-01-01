package com.practice.rbac.shiro.controller;


import com.practice.rbac.shiro.common.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author nn
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("")
    public R test() {
        return R.success();
    }
}
