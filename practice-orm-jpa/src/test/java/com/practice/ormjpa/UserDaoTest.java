package com.practice.ormjpa;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
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
import java.util.stream.Collectors;

/**
 * @Auther: wbnn
 * @Date: 2022/01/06/
 * @Description:
 */
@Slf4j
public class UserDaoTest extends PracticeOrmJpaApplicationTests{

    @Resource
    private UserDao userDao;

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
