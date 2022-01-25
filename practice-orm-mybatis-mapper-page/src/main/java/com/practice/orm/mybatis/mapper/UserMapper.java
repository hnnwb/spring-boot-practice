package com.practice.orm.mybatis.mapper;

import com.practice.orm.mybatis.entity.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Auther: wbnn
 * @Date: 2022/01/25/
 * @Description:
 */
@Component
public interface UserMapper extends Mapper<User>, MySqlMapper<User> {

}
