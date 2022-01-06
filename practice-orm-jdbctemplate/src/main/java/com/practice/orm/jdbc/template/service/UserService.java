package com.practice.orm.jdbc.template.service;

import com.practice.orm.jdbc.template.entity.User;

import java.util.List;

/**
 * @Auther: wbnn
 * @Date: 2021/12/24/
 * @Description:
 */
public interface UserService {
    /**
     * 保存用户
     * @param user
     * @return
     */
    Boolean save(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    Boolean delete(Long id);

    /**
     * 更新用户
     * @param user
     * @param id
     * @return
     */
    Boolean update(User user, Long id);

    /**
     * 获取用户
     * @param id
     * @return
     */
    User getUser(Long id);

    /**
     * 根据条件获取用户
     * @param user
     * @return
     */
    List<User> getUserList(User user);
}
