package com.practice.oauth.repostiory;

import com.practice.oauth.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 用户信息仓库
 * @author wb
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    /**
     * 通过用户名查找用户.
     *
     * @param username 用户名
     * @return 结果
     */
    Optional<SysUser> findFirstByUsername(String username);

}
