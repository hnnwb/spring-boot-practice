package com.practice.mapper;

import com.practice.config.MyMapper;
import com.practice.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 */
@Mapper
public interface UserMapper extends MyMapper<User> {
}