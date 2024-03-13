package com.practice.codegen.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 分页结果集
 * @author wb
 */
@Data
@AllArgsConstructor
public class PageResult<T> {
    /**
     * 总条数
     */
    private Long total;

    /**
     * 页码
     */
    private int pageNumber;

    /**
     * 每页结果数
     */
    private int pageSize;

    /**
     * 结果集
     */
    private List<T> list;
}
