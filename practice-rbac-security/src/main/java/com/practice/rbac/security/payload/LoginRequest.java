package com.practice.rbac.security.payload;

import lombok.Data;

/**
 * 登录请求参数
 * @author wb
 */
@Data
public class LoginRequest {

    /**
     * 用户名或邮箱或手机号
     */
    //@NotBlank(message = "用户名不能为空")
    private String usernameOrEmailOrPhone;

    /**
     * 密码
     */
    //@NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 记住我
     */
    private Boolean rememberMe = false;

}
