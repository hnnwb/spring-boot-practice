package com.practice.jdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.practice.jdbc.model.Order;
import org.springframework.stereotype.Component;

/**
 * @author wb
 */
@Component
public interface OrderMapper extends BaseMapper<Order> {
}