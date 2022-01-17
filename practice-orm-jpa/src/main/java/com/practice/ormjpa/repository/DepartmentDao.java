package com.practice.ormjpa.repository;

import com.practice.ormjpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @Auther: wbnn
 * @Date: 2022/01/06/
 * @Description:
 */
@Repository
public interface DepartmentDao extends JpaRepository<Department,Long> {

    /**
     * 根据层级查询
     * @param i
     * @return
     */
    Collection<Department> findDepartmentsByLevels(Integer i);
}
