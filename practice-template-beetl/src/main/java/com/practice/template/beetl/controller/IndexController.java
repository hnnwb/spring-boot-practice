package com.practice.template.beetl.controller;

import cn.hutool.core.util.ObjectUtil;
import com.practice.template.beetl.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: wbnn
 * @Date: 2021/12/23/
 * @Description:
 */
@Controller
@Slf4j
public class IndexController {

    @GetMapping(value = {"","/"})
    public ModelAndView index(HttpServletRequest request){
        ModelAndView view = new ModelAndView();

        User user = (User) request.getSession().getAttribute("user");
        if (ObjectUtil.isEmpty(user)) {
            view.setViewName("redirect:/user/login");
        } else {
            view.setViewName("page/index.btl");
            view.addObject(user);
        }
        return view;
    }
}
