package com.example.restdemo.service;

import com.example.restdemo.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
//        return Arrays.asList(
//                new Student(1, "Paul", 21),
//                new Student(2, "Mary", 20));
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByName(student.getName());
        if (studentByEmail.isPresent()) {
            System.out.println("Name is taken!");
            throw new IllegalArgumentException("Name is already taken");
        }
        System.out.println("MY log: " + student.getName());
        studentRepository.save(student);
    }


    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("student with id " + id + "does not exist.");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, Integer age) {
        Student student = studentRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("no student with id " + id));
        student.setName(name);
        if (age != null) {
            student.setAge(age);
        }

    }
}
