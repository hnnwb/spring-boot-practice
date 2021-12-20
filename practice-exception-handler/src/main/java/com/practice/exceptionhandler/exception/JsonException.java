package com.practice.exceptionhandler.exception;

import com.practice.exceptionhandler.constant.Status;
import lombok.Getter;

/**
 * @Auther: wbnn
 * @Date: 2021/12/20/
 * @Description:JSON异常
 */
@Getter
public class JsonException extends BaseException{

    public JsonException(Status status) {
        super(status);
    }

    public JsonException(Integer code, String message) {
        super(code, message);
    }
}
