package com.practice.neo4j.payload;

import com.practice.neo4j.model.Student;
import lombok.Data;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;

/**
 * @author wb
 */
@Data
@QueryResult
public class TeacherStudent {
    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 学生信息
     */
    private List<Student> students;
}