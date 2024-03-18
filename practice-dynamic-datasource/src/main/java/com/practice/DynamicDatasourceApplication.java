package com.practice;

import com.practice.datasource.DatasourceConfigCache;
import com.practice.datasource.DatasourceConfigContextHolder;
import com.practice.mapper.DatasourceConfigMapper;
import com.practice.model.DatasourceConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * Hello world!
 *
 * @author wb
 */
@SpringBootApplication
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class DynamicDatasourceApplication implements CommandLineRunner {
    private final DatasourceConfigMapper configMapper;

    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // 设置默认的数据源
        DatasourceConfigContextHolder.setDefaultDatasource();
        // 查询所有数据库配置列表
        List<DatasourceConfig> datasourceConfigs = configMapper.selectAll();
        System.out.println("加载其余数据源配置列表: " + datasourceConfigs);
        // 将数据库配置加入缓存
        datasourceConfigs.forEach(config -> DatasourceConfigCache.INSTANCE.addConfig(config.getId(), config));
    }
}
