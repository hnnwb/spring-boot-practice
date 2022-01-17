package com.practice.ormjpa;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.practice.PracticeOrmJpaApplicationTests;
import com.practice.ormjpa.entity.User;
import com.practice.ormjpa.repository.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Auther: wbnn
 * @Date: 2022/01/06/
 * @Description:
 */
@Slf4j
public class UserDaoTest extends PracticeOrmJpaApplicationTests {

    @Resource
    private UserDao userDao;

    /**
     * 保存
     */
    @Test
    public void testSave(){
        String simpleUUID = IdUtil.fastSimpleUUID();
        User save66 = User.builder().name("testSave66")
                .password(SecureUtil.md5("123456" + simpleUUID)).salt(simpleUUID)
                .email("testSave66@qq.com").phoneNumber("17766666666")
                .status(1).lastLoginTime(new DateTime()).build();
        userDao.save(save66);
        Assertions.assertNotNull(save66.getId());
        Optional<User> byId = userDao.findById(save66.getId());
        Assertions.assertTrue(byId.isPresent());
        log.debug("[byId]={}",byId.get());
    }

    /**
     * 测试删除
     */
    @Test
    public void testDelete(){
        long count = userDao.count();
        userDao.deleteById(1L);
        long count1 = userDao.count();
        Assertions.assertEquals(count-1,count1);
    }

    /**
     * 修改
     */
    @Test
    public void testUpdate(){
        userDao.findById(1L).ifPresent(user -> {
            user.setName("JPA修改666");
            userDao.save(user);
        });
        Assertions.assertEquals("JPA修改666",userDao.findById(1L).get().getName());
    }

    /**
     * 查询单个
     */
    @Test
    public void testQueryOne(){
        Optional<User> byId = userDao.findById(1L);
        Assertions.assertTrue(byId.isPresent());
        log.debug("[byId]={}",byId.get());
    }

    /**
     * 查询所有
     */
    @Test
    public void testQueryAll(){
        List<User> userList = userDao.findAll();
        Assertions.assertEquals(0,userList.size());
        log.debug("[UserList]={}",userList);
    }

    /**
     * 测试分页排序查询
     */
    @Test
    public void testQueryPage(){
        initData();
        //JPA分页时候起始页是页码-1
        Integer currentPage=0;
        Integer pageSize = 5;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize, sort);
        Page<User> userPage = userDao.findAll(pageRequest);

        Assertions.assertEquals(5,userPage.getSize());
        Assertions.assertEquals(userDao.count(),userPage.getTotalElements());
        log.debug("[id]={}",userPage.getContent().stream().map(User::getId).collect(Collectors.toList()));
    }

    /**
     * 初始化数据
     */
    private void initData(){
        List<User> userList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            String uuid = IdUtil.fastSimpleUUID();
            int index = 3+i;
            User user = User.builder().name("testUser" + index)
                    .password(SecureUtil.md5("123456" + uuid)).salt(uuid)
                    .email("testEmail" + index + "@163.com").phoneNumber("1776000000" + index)
                    .status(1).lastLoginTime(new DateTime()).build();
            userList.add(user);
        }
        userDao.saveAll(userList);
    }
}
