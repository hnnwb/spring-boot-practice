package com.practice.rbac.security.repository;

import com.practice.rbac.security.model.RolePermission;
import com.practice.rbac.security.model.RolePermissionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 角色-权限 DAO
 * @author wb
 */
public interface RolePermissionDao extends JpaRepository<RolePermission, RolePermissionKey>, JpaSpecificationExecutor<RolePermission> {
}
