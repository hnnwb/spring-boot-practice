package com.practice.neo4j.repository;

import com.practice.neo4j.model.Lesson;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author wb
 */
public interface LessonRepository extends Neo4jRepository<Lesson, String> {
}