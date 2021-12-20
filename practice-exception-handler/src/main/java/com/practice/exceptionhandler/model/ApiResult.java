package com.practice.exceptionhandler.model;

import com.practice.exceptionhandler.constant.Status;
import com.practice.exceptionhandler.exception.BaseException;
import lombok.Data;

/**
 * @Auther: wbnn
 * @Date: 2021/12/20/
 * @Description:
 */
@Data
public class ApiResult {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 内容
     */
    private String message;
    /**
     * 数据
     */
    private Object data;

    /**
     * 无参
     */
    public ApiResult() {
    }

    /**
     * 全参
     * @param code
     * @param message
     * @param data
     */
    public ApiResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 自定义API返回
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static ApiResult of(Integer code,String message,Object data){
        return new ApiResult(code,message,data);
    }

    /**
     * 构造一个成功且带数据的API返回
     * @param data
     * @return
     */
    public static ApiResult ofSuccess(Object data){
        return ofStatus(Status.OK,data);
    }

    /**
     * 构造一个成功且自定义消息的API返回
     * @param message
     * @return
     */
    public static ApiResult ofMessage(String message){
        return of(Status.OK.getCode(), message,null);
    }

    /**
     * 构造一个有状态的API返回
     * @param status
     * @return
     */
    public static ApiResult ofStatus(Status status){
        return ofStatus(status,null);
    }

    /**
     * 构造一个有状态且带数据的API返回
     * @param status
     * @param data
     * @return
     */
    private static ApiResult ofStatus(Status status, Object data) {
        return of(status.getCode(),status.getMessage(),data);
    }

    /**
     * 构造一个异常且带数据的API返回
     * @param t
     * @param data
     * @param <T>
     * @return
     */
    public static <T extends BaseException>  ApiResult ofException(T t,Object data){
        return of(t.getCode(),t.getMessage(),data);
    }

    /**
     * 构造一个异常且带数据的API返回
     * @param t
     * @param <T>
     * @return
     */
    public static <T extends BaseException> ApiResult ofException(T t){
        return ofException(t,null);
    }
}

