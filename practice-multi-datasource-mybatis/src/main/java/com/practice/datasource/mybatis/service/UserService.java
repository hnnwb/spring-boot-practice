package com.practice.datasource.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.practice.datasource.mybatis.model.User;

/**
 * @author wb
 */
public interface UserService extends IService<User> {

    /**
     * 添加 User
     *
     * @param user 用户
     */
    void addUser(User user);
}
