package com.practice.codegen.service;

import cn.hutool.db.Entity;
import com.practice.codegen.common.PageResult;
import com.practice.codegen.entity.GenConfig;
import com.practice.codegen.entity.TableRequest;

/**
 * 代码生成器
 * @author wb
 */
public interface CodeGenService {
    /**
     * 生成代码
     *
     * @param genConfig 生成配置
     * @return 代码压缩文件
     */
    byte[] generatorCode(GenConfig genConfig);

    /**
     * 分页查询表信息
     *
     * @param request 请求参数
     * @return 表名分页信息
     */
    PageResult<Entity> listTables(TableRequest request);
}