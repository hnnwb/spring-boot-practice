package com.practice.session.config;

import com.practice.session.interceptor.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author nn
 * WebMvc 配置类
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration sessionInterceptorRegistry = registry.addInterceptor(sessionInterceptor);
        // 排除不需要拦截的路径
        sessionInterceptorRegistry.excludePathPatterns("/page/login");
        sessionInterceptorRegistry.excludePathPatterns("/page/doLogin");
        sessionInterceptorRegistry.excludePathPatterns("/error");

        // 需要拦截的路径
        sessionInterceptorRegistry.addPathPatterns("/**");
    }
}
