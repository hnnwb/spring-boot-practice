package com.practice.orm.mybatis;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.practice.orm.PracticeOrmMybatisMapperPageApplicationTests;
import com.practice.orm.mybatis.entity.User;
import com.practice.orm.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

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


    /**
     * 保存
     */
    @Test
    public void testInsert(){
        String simpleUUID = IdUtil.fastSimpleUUID();
        User user = User.builder().name("testSave").password(SecureUtil.md5("12345") + simpleUUID).salt(simpleUUID)
                .email("testSave" + "@practice.com").phoneNumber("17700000000").status(1)
                .lastLoginTime(new DateTime()).createTime(new DateTime()).lastUpdateTime(new DateTime()).build();
        userMapper.insertUseGeneratedKeys(user);
        Assertions.assertNotNull(user.getId());
        log.debug("【测试主键回写#user.getId()】= {}", user.getId());
    }


    /**
     * 批量保存
     */
    @Test
    public void testInsertList() {
        List<User> userList = Lists.newArrayList();
        for (int i = 4; i < 14; i++) {
            String simpleUUID = IdUtil.fastSimpleUUID();
            User user = User.builder().name("testSave" + i).password(SecureUtil.md5("12345") + simpleUUID).salt(simpleUUID)
                    .email("testSave" + i + "@practice.com").phoneNumber("17700000000" + i).status(1)
                    .lastLoginTime(new DateTime()).createTime(new DateTime()).lastUpdateTime(new DateTime()).build();
            userList.add(user);
        }
        int i = userMapper.insertList(userList);
        Assertions.assertEquals(userList.size(),i);
        List<Long> ids = userList.stream().map(User::getId).collect(Collectors.toList());
        log.debug("[测试。。。。。。]={}",ids);
    }

    /**
     * 删除
     */
    @Test
    public void testDelete(){
        Long key = 1L;
        int i = userMapper.deleteByPrimaryKey(key);
        Assertions.assertEquals(1,i);
        User user = userMapper.selectByPrimaryKey(key);
        Assertions.assertNull(user);
    }

    /**
     * 更新
     */
    @Test
    public void testUpdate(){
        Long key = 1L;
        User user = userMapper.selectByPrimaryKey(key);
        user.setName("冰墩墩");
        int i = userMapper.updateByPrimaryKey(user);
        Assertions.assertEquals(1,i);
        User user1 = userMapper.selectByPrimaryKey(key);
        Assertions.assertNotNull(user1);
        //Assertions.assertEquals("通用Mapper更新",user1.getName());
        log.debug("[谁]={}",user1);
    }

    /**
     * 查询全部
     */
    @Test
    public void testQueryAll(){
        List<User> userList = userMapper.selectAll();
        Assertions.assertTrue(CollUtil.isNotEmpty(userList));
    }

    /**
     * 分页排序
     */
    @Test
    public void testQueryByPageAndSort(){
        initData();
        int currentPage = 1;
        int pageSize = 5;
        String orderBy = "id desc";
        int count = userMapper.selectCount(null);
        PageHelper.startPage(currentPage,pageSize,orderBy);
        List<User> userList = userMapper.selectAll();
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        Assertions.assertEquals(5,userPageInfo.getSize());
        Assertions.assertEquals(count,userPageInfo.getTotal());
        log.debug("[userPageInfo]={}",userPageInfo);

    }

    /**
     * 条件查询
     */
    @Test
    public void testQueryByCondition(){
        initData();
        Example example = new Example(User.class);
        //过滤
        example.createCriteria().andLike("name","%Save1%").orEqualTo("phoneNumber","17700000009");
        //排序
        example.setOrderByClause("id desc");
        int count = userMapper.selectCountByExample(example);
        PageHelper.startPage(1,3);
        //查询
        List<User> userList = userMapper.selectByExample(example);
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        Assertions.assertEquals(3,userPageInfo.getSize());
        Assertions.assertEquals(count,userPageInfo.getTotal());
        log.debug("[userPageInfo]={}",userPageInfo);
    }

    /**
     * 初始化数据
     */
    private void initData(){
        testInsertList();
    }
}
