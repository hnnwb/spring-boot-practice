package com.practice.neo4j.config;

import cn.hutool.core.util.IdUtil;
import org.neo4j.ogm.id.IdStrategy;

/**
 * 自定义主键策略
 * @author wb
 */
public class CustomIdStrategy implements IdStrategy {
    @Override
    public Object generateId(Object o) {
        return IdUtil.fastUUID();
    }
}
