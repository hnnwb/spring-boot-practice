package com.practice.mapper;

import com.practice.config.MyMapper;
import com.practice.model.DatasourceConfig;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据源配置
 * @author wb
 */
@Mapper
public interface DatasourceConfigMapper extends MyMapper<DatasourceConfig> {
}