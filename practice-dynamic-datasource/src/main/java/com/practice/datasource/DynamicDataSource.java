package com.practice.datasource;

import com.practice.model.DatasourceConfig;
import com.practice.utils.SpringUtil;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 动态数据源
 * @author wb
 */
@Slf4j
public class DynamicDataSource extends HikariDataSource {
    @Override
    public Connection getConnection() throws SQLException {
        // 获取当前数据源 id
        Long id = DatasourceConfigContextHolder.getCurrentDatasourceConfig();
        // 根据当前id获取数据源
        HikariDataSource datasource = DatasourceHolder.INSTANCE.getDatasource(id);

        if (null == datasource) {
            datasource = initDatasource(id);
        }

        return datasource.getConnection();
    }

    /**
     * 初始化数据源
     *
     * @param id 数据源id
     * @return 数据源
     */
    private HikariDataSource initDatasource(Long id) {
        HikariDataSource dataSource = new HikariDataSource();

        // 判断是否是默认数据源
        if (DatasourceHolder.DEFAULT_ID.equals(id)) {
            // 默认数据源根据 application.yml 配置的生成
            DataSourceProperties properties = SpringUtil.getBean(DataSourceProperties.class);
            dataSource.setJdbcUrl(properties.getUrl());
            dataSource.setUsername(properties.getUsername());
            dataSource.setPassword(properties.getPassword());
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        } else {
            // 不是默认数据源，通过缓存获取对应id的数据源的配置
            DatasourceConfig datasourceConfig = DatasourceConfigCache.INSTANCE.getConfig(id);

            if (datasourceConfig == null) {
                throw new RuntimeException("无此数据源");
            }

            dataSource.setJdbcUrl(datasourceConfig.buildJdbcUrl());
            dataSource.setUsername(datasourceConfig.getUsername());
            dataSource.setPassword(datasourceConfig.getPassword());
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        }
        // 将创建的数据源添加到数据源管理器中，绑定当前线程
        DatasourceHolder.INSTANCE.addDatasource(id, dataSource);
        return dataSource;
    }
}