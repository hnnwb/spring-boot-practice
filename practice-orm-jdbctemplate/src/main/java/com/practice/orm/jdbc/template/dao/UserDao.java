package com.practice.orm.jdbc.template.dao;

import com.practice.orm.jdbc.template.base.BaseDao;
import com.practice.orm.jdbc.template.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: wbnn
 * @Date: 2021/12/24/
 * @Description:
 */
@Repository
public class UserDao extends BaseDao<User,Long> {

    public UserDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    public Integer insert(User user){
        return super.insert(user,true);
    }

    /**
     * 根据主键删除用户
     * @param id
     * @return
     */
    public Integer delete(Long id){
        return super.deleteById(id);
    }

    /**
     * 更新用户
     * @param user
     * @param id
     * @return
     */
    public Integer update(User user,Long id){
        return super.updateById(user,id,true);
    }

    /**
     * 根据主键获取用户
     * @param id
     * @return
     */
    public User selectById(Long id){
        return super.findOneById(id);
    }

    /**
     * 根据查询条件获取用户列表
     * @param user
     * @return
     */
    public List<User> selectUserList(User user){
        return super.findByObj(user);
    }
}
