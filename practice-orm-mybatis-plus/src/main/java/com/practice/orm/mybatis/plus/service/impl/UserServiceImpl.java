package com.practice.orm.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.practice.orm.mybatis.plus.entity.User;
import com.practice.orm.mybatis.plus.mapper.UserMapper;
import com.practice.orm.mybatis.plus.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}