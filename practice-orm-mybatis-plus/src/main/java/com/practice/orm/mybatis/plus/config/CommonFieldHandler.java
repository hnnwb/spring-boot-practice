package com.practice.orm.mybatis.plus.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2022/02/14/
 * @Description:通用字段填充
 */
@Slf4j
@Component
public class CommonFieldHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert field ....");
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("lastUpdateTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.setFieldValByName("lastUpdateTime",new Date(),metaObject);
    }
}
