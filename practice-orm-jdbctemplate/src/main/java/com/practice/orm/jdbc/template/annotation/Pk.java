package com.practice.orm.jdbc.template.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: wbnn
 * @Date: 2021/12/23/
 * @Description: 主键
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Pk {

    /**
     * 自增，默认true
     * @return
     */
    boolean auto() default true;
}
