package com.example.restdemo.dao;

import com.example.restdemo.service.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //@Query("SELECT s FROM Student s WHERE s.name = ?1") jpql
    Optional<Student> findStudentByName(String aLong);
}
