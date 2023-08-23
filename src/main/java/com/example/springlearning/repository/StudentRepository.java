package com.example.springlearning.repository;

import com.example.springlearning.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    public List<Student> findByName(String name);

    @Query(value = "select * from student where marks > :marks", nativeQuery = true)
    public List<Student> findByCustomMarks(int marks);
}
