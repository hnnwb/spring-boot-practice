package com.practice.orm.mybatis.mapper;

import com.practice.orm.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: wbnn
 * @Date: 2022/01/17/
 * @Description:
 */
@Mapper
@Component
public interface UserMapper {

    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("SELECT * FROM orm_user")
    List<User> selectAllUser();


    @Select("SELECT * FROM orm_user WHERE id = #{id} ")
    User selectUserById(@Param("id") long id);

    int saveUser(@Param("user") User qing666);

    int deleteById(@Param("id") long l);
}
