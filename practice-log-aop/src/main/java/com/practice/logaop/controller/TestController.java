package com.practice.logaop.controller;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther: wbnn
 * @Date: 2021/12/20/
 * @Description:
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("/test")
    public Dict test(String who){
        return Dict.create().set("who", StrUtil.isBlank(who)?"me":who);
    }

    @PostMapping("/testJson")
    public Dict testJson(@RequestBody Map<String,Object> map){
        String jsonStr = JSONUtil.toJsonStr(map);
        log.info(jsonStr);
        return Dict.create().set("json",map);
    }
}
