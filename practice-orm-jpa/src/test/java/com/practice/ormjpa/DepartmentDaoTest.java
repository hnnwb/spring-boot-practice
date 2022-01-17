package com.practice.ormjpa;


import cn.hutool.json.JSONUtil;
import com.practice.PracticeOrmJpaApplicationTests;
import com.practice.ormjpa.entity.Department;
import com.practice.ormjpa.entity.User;
import com.practice.ormjpa.repository.DepartmentDao;
import com.practice.ormjpa.repository.UserDao;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @Auther: wbnn
 * @Date: 2022/01/17/
 * @Description:
 */
@Slf4j
public class DepartmentDaoTest extends PracticeOrmJpaApplicationTests {

    @Resource
    private DepartmentDao departmentDao;
    @Resource
    private UserDao userDao;

    @Test
    @Transactional
    public void testSave(){
        Collection<Department> departmentList = departmentDao.findDepartmentsByLevels(0);

        if (departmentList.size() == 0) {
            Department testSave1 = Department.builder().name("testSave1").orderNo(0).levels(0).superior(null).build();
            Department testSave1_1 = Department.builder().name("testSave1_1").orderNo(0).levels(1).superior(testSave1).build();
            Department testSave1_2 = Department.builder().name("testSave1_2").orderNo(0).levels(1).superior(testSave1).build();
            Department testSave1_1_1 = Department.builder().name("testSave1_1_1").orderNo(0).levels(2).superior(testSave1_1).build();
            departmentList.add(testSave1);
            departmentList.add(testSave1_1);
            departmentList.add(testSave1_2);
            departmentList.add(testSave1_1_1);
            departmentDao.saveAll(departmentList);

            List<Department> departments = departmentDao.findAll();
            log.debug("[部门]={}", JSONArray.toJSONString((List)departments));
        }

        userDao.findById(1L).ifPresent(user->{
            user.setName("添加部门");
            Department dept = departmentDao.findById(2L).get();
            user.setDepartmentList(departmentList);
            userDao.save(user);
        });

        log.debug("用户部门={}", JSONUtil.toJsonStr(userDao.findById(1L).get().getDepartmentList()));

        departmentDao.findById(2L).ifPresent(department -> {
            Collection<User> userList = department.getUserList();
            //关联关系由user维护中间表，department userList不会发生变化，可以增加查询方法来处理，重写getUserList方法
            log.debug("部门下用户={}",JSONUtil.toJsonStr(userList));
        });

        userDao.findById(1L).ifPresent(user -> {
            user.setName("清空部门");
            user.setDepartmentList(null);
            userDao.save(user);
        });

        log.debug("用户部门={}",userDao.findById(1L).get().getDepartmentList());

    }
}
