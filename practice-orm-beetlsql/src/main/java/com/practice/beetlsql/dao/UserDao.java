package com.practice.beetlsql.dao;

import com.practice.beetlsql.entity.User;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public interface UserDao extends BaseMapper<User> {

}
