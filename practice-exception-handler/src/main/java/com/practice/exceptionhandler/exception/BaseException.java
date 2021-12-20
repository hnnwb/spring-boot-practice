package com.practice.exceptionhandler.exception;

import com.practice.exceptionhandler.constant.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Auther: wbnn
 * @Date: 2021/12/20/
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException{

    private Integer code;

    private String message;

    public BaseException(Status status) {
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BaseException(Integer code,String message){
        super(message);
        this.code = code;
        this.message = message;
    }
}
