package com.practice.exceptionhandler.controller;

import com.practice.exceptionhandler.constant.Status;
import com.practice.exceptionhandler.exception.JsonException;
import com.practice.exceptionhandler.exception.PageException;
import com.practice.exceptionhandler.model.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: wbnn
 * @Date: 2021/12/20/
 * @Description:
 */
@RestController
public class TestController {

    @GetMapping("/json")
    @ResponseBody
    public ApiResult jsonException(){
        throw new JsonException(Status.ERROR);
    }

    @GetMapping("/page")
    public ModelAndView pageException(){
        throw new PageException(Status.ERROR);
    }
}
