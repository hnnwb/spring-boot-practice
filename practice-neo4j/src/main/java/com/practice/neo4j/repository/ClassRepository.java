package com.practice.neo4j.repository;

import com.practice.neo4j.model.Class;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

/**
 * @author wb
 */
public interface ClassRepository extends Neo4jRepository<Class, String> {
    /**
     * 根据班级名称查询班级信息
     *
     * @param name 班级名称
     * @return 班级信息
     */
    Optional<Class> findByName(String name);
}