package com.practice.exceptionhandler.exception;

import com.practice.exceptionhandler.constant.Status;
import lombok.Getter;

/**
 * @Auther: wbnn
 * @Date: 2021/12/20/
 * @Description:页面异常
 */
@Getter
public class PageException extends BaseException{
    public PageException(Status status) {
        super(status);
    }

    public PageException(Integer code, String message) {
        super(code, message);
    }
}
