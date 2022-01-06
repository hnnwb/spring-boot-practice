package com.practice.orm.jdbc.template.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.practice.orm.jdbc.template.constant.Const;
import com.practice.orm.jdbc.template.dao.UserDao;
import com.practice.orm.jdbc.template.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Auther: wbnn
 * @Date: 2021/12/24/
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    UserDao userDao;

    @Override
    public Boolean save(User user) {
        String password = user.getPassword();
        String uuid = IdUtil.simpleUUID();
        String md5 = SecureUtil.md5(password + Const.SALT_PREFIX + uuid);
        user.setPassword(md5);
        user.setSalt(uuid);
        return userDao.insert(user) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        return userDao.delete(id) > 0;
    }

    @Override
    public Boolean update(User user, Long id) {
        User user1 = userDao.selectById(id);
        if (ObjectUtil.isNotEmpty(user.getPassword())) {
            String password = user.getPassword();
            String uuid = IdUtil.simpleUUID();
            String md5 = SecureUtil.md5(password + Const.SALT_PREFIX + uuid);
            user.setPassword(md5);
            user.setSalt(uuid);
        }
        BeanUtil.copyProperties(user,user1, CopyOptions.create().setIgnoreNullValue(true));
        user1.setLastUpdateTime(new Date());
        return userDao.update(user1,id)>0;
    }

    @Override
    public User getUser(Long id) {
        return userDao.selectById(id);
    }

    @Override
    public List<User> getUserList(User user) {
        return userDao.selectUserList(user);
    }
}
