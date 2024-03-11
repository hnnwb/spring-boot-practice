package com.practice.neo4j.repository;

import com.practice.neo4j.model.Teacher;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author wb
 */
public interface TeacherRepository extends Neo4jRepository<Teacher, String> {
}
