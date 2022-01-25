package com.practice.orm.mybatis;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.practice.orm.PracticeOrmMybatisMapperPageApplicationTests;
import com.practice.orm.mybatis.entity.User;
import com.practice.orm.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: wbnn
 * @Date: 2022/01/25/
 * @Description:
 */
@Slf4j
public class UserMapperTest extends PracticeOrmMybatisMapperPageApplicationTests {

    @Autowired
    UserMapper userMapper;


    @Test
    public void testInsert(){
        String simpleUUID = IdUtil.fastSimpleUUID();
        User user = User.builder().name("testSave").password(SecureUtil.md5("12345") + simpleUUID).salt(simpleUUID)
                .email("testSave" + "@practice.com").phoneNumber("17700000000").status(1)
                .lastLoginTime(new DateTime()).createTime(new DateTime()).lastUpdateTime(new DateTime()).build();
        userMapper.insertUseGeneratedKeys(user);
        Assert.assertNotNull(user.getId());
        log.debug("【测试主键回写#user.getId()】= {}", user.getId());
    }


    /**
     * 批量保存
     */
    @org.junit.Test
    private void testInsertList() {
        List<User> userList = Lists.newArrayList();
        for (int i = 4; i < 14; i++) {
            String simpleUUID = IdUtil.fastSimpleUUID();
            User user = User.builder().name("testSave" + i).password(SecureUtil.md5("12345") + simpleUUID).salt(simpleUUID)
                    .email("testSave" + i + "@practice.com").phoneNumber("17700000000" + i).status(1)
                    .lastLoginTime(new DateTime()).createTime(new DateTime()).lastUpdateTime(new DateTime()).build();
            userList.add(user);
        }
        int i = userMapper.insertList(userList);
        Assert.assertEquals(userList.size(),i);
        List<Long> ids = userList.stream().map(User::getId).collect(Collectors.toList());
        log.debug("[测试。。。。。。]={}",ids);
    }

    /**
     * 初始化数据
     */
    private void initData(){
        testInsertList();
    }
}
