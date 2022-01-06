package com.practice.ormjpa.repository;

import com.practice.ormjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Auther: wbnn
 * @Date: 2022/01/06/
 * @Description:
 */
@Repository
public interface UserDao extends JpaRepository<User,Long> {
}
