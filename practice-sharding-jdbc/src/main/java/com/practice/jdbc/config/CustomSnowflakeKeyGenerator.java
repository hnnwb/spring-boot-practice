package com.practice.jdbc.config;

import cn.hutool.core.lang.Snowflake;
import io.shardingsphere.core.keygen.KeyGenerator;

/**
 * @author wb
 */
public class CustomSnowflakeKeyGenerator implements KeyGenerator {
    private Snowflake snowflake;

    public CustomSnowflakeKeyGenerator(Snowflake snowflake) {
        this.snowflake = snowflake;
    }

    @Override
    public Number generateKey() {
        return snowflake.nextId();
    }
}