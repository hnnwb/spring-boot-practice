package com.practice.template.beetl.controller;

import com.practice.template.beetl.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: wbnn
 * @Date: 2021/12/23/
 * @Description:
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @PostMapping("/login")
    public ModelAndView login(User user, HttpServletRequest request){
        ModelAndView view = new ModelAndView();

        view.addObject(user);
        view.setViewName("redirect:/");

        request.getSession().setAttribute("user",user);
        return view;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("page/login.btl");
    }
}
