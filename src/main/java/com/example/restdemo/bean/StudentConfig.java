package com.example.restdemo.bean;

import com.example.restdemo.dao.StudentRepository;
import com.example.restdemo.service.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository) {
      return args -> {
          Student paul = new Student(1, "Paul", 21);
          Student mary = new Student(2, "Mary", 20);
          studentRepository.saveAll(Arrays.asList(paul, mary));
      };
    }
}
