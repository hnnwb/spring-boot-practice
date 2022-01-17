package com.practice.orm.mybatis.mapper;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.practice.orm.mybatis.PracticeOrmMybatisApplicationTests;
import com.practice.orm.mybatis.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: wbnn
 * @Date: 2022/01/17/
 * @Description:
 */
@Slf4j
public class UserMapperTest extends PracticeOrmMybatisApplicationTests {

    @Resource
    UserMapper userMapper;

    /**
     * 测试查所有
     */
    @Test
    public void selectAllUser(){
        List<User> userList = userMapper.selectAllUser();
        Assertions.assertTrue(CollUtil.isNotEmpty(userList));
        log.debug("[userList]={}",userList);
    }

    /**
     * 测试根据主键查询单个用户
     */
    @Test
    public void selectUserById(){
        User user = userMapper.selectUserById(1L);
        Assertions.assertNotNull(user);
        log.debug("[user]={}",user);
    }

    /**
     * 测试保存
     */
    @Test
    public void saveUser(){
        String simpleUUID = IdUtil.fastSimpleUUID();
        User qing666 = User.builder().name("qing666")
                .password(SecureUtil.md5("123456" + simpleUUID)).salt(simpleUUID)
                .email("qing123@163.com").phoneNumber("17766666666")
                .status(1).lastLoginTime(new DateTime()).createTime(new DateTime())
                .lastUpdateTime(new DateTime()).build();
        int i = userMapper.saveUser(qing666);
        Assertions.assertEquals(1,i);
    }

    /**
     * 根据主键删除
     */
    @Test
    public void deleteById(){
        int i = userMapper.deleteById(1L);
        Assertions.assertEquals(1,i);
    }
}
