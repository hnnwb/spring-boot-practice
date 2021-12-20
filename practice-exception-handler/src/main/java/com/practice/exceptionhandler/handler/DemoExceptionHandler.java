package com.practice.exceptionhandler.handler;

import com.practice.exceptionhandler.exception.JsonException;
import com.practice.exceptionhandler.exception.PageException;
import com.practice.exceptionhandler.model.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: wbnn
 * @Date: 2021/12/20/
 * @Description:
 */
@ControllerAdvice
@Slf4j
public class DemoExceptionHandler {

    private static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 统一JSON异常处理
     * @param jsonException
     * @return
     */
    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public ApiResult jsonErrorHandler(JsonException jsonException){
        log.error("[JsonException]:{}",jsonException.getMessage());
        return ApiResult.ofException(jsonException);
    }

    /**
     * 统一页面异常处理
     * @param pageException
     * @return
     */
    public ModelAndView pageException(PageException pageException){
        log.error("[PageException]:{}",pageException.getMessage());
        ModelAndView view = new ModelAndView();
        view.addObject("message",pageException.getMessage());
        view.setViewName(DEFAULT_ERROR_VIEW);
        return view;
    }
}
