package com.practice.rbac.security.payload;

import lombok.Data;

/**
 * 分页请求参数
 * @author wb
 */
@Data
public class PageCondition {
    /**
     * 当前页码
     */
    private Integer currentPage;

    /**
     * 每页条数
     */
    private Integer pageSize;

}