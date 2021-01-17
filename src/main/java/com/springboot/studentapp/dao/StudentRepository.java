package com.springboot.studentapp.dao;

import com.springboot.studentapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByOrderByLastNameAsc();

}
