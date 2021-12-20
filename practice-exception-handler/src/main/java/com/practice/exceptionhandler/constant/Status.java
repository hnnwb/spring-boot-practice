package com.practice.exceptionhandler.constant;

import lombok.Getter;

/**
 * @Auther: wbnn
 * @Date: 2021/12/20/
 * @Description:
 */
@Getter
public enum Status {

    OK(200,"操作成功"),

    ERROR(500,"找不到服务了！");

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 内容
     */
    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

