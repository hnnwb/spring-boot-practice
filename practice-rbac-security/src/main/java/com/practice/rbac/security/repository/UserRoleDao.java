package com.practice.rbac.security.repository;

import com.practice.rbac.security.model.UserRole;
import com.practice.rbac.security.model.UserRoleKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 用户角色 DAO
 * @author wb
 */
public interface UserRoleDao extends JpaRepository<UserRole, UserRoleKey>, JpaSpecificationExecutor<UserRole> {

}
