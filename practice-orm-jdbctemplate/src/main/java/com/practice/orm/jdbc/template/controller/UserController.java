package com.practice.orm.jdbc.template.controller;

import cn.hutool.core.lang.Dict;
import com.practice.orm.jdbc.template.entity.User;
import com.practice.orm.jdbc.template.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: wbnn
 * @Date: 2021/12/24/
 * @Description:
 */
@RestController
@Slf4j
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/user")
    public Dict save(@RequestBody User user){
        Boolean save = userService.save(user);
        return Dict.create().set("code",save?200:500).set("msg",save?"成功":"失败").set("data",save?user:null);
    }

    @DeleteMapping("/user/{id}")
    public Dict delete(@PathVariable Long id){
        Boolean delete = userService.delete(id);
        return Dict.create().set("code",delete?200:500).set("msg",delete?"成功":"失败");
    }

    @PutMapping("/user/{id}")
    public Dict update(@RequestBody User user,@PathVariable Long id){
        Boolean update = userService.update(user,id);
        return Dict.create().set("code",update?200:500).set("msg",update?"成功":"失败").set("data",update?user:null);
    }

    @GetMapping("/user/{id}")
    public Dict getUser(@PathVariable Long id){
        User user = userService.getUser(id);
        return Dict.create().set("code",200).set("msg","成功").set("data",user);
    }

    @GetMapping("/user")
    public Dict getUserList(User user){
        List<User> userList = userService.getUserList(user);
        return Dict.create().set("code",200).set("msg","成功").set("data",userList);
    }
}
