package com.practice.codegen.utils;

import com.practice.codegen.entity.TableRequest;
import com.zaxxer.hikari.HikariDataSource;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * 数据库工具类
 */
@Slf4j
@UtilityClass
public class DbUtil {
    public HikariDataSource buildFromTableRequest(TableRequest request) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(request.getPrepend() + request.getUrl());
        dataSource.setUsername(request.getUsername());
        dataSource.setPassword(request.getPassword());
        return dataSource;
    }

}