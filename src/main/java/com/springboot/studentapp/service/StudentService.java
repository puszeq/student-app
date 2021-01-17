package com.springboot.studentapp.service;

import com.springboot.studentapp.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(int id);

    void save(Student student);

    void deleteById(int id);

    List<Student> prepareStartData();
}
