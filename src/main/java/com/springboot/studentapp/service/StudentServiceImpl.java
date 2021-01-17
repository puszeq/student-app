package com.springboot.studentapp.service;

import com.springboot.studentapp.dao.StudentRepository;
import com.springboot.studentapp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Student findById(int id) {
        Optional<Student> result = studentRepository.findById(id);

        Student student = null;

        if(result.isPresent()){
            student = result.get();
        }
        else {
            throw new RuntimeException("Did not find student id - " + id);
        }

        return student;
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> prepareStartData(){

        if (findAll().isEmpty()) {

            Student student1 = new Student(
                    "Student1",
                    "Student1",
                    "student1@mail.com"
            );

            Student student2 = new Student(
                    "Student2",
                    "Student2",
                    "student2@mail.com"
            );

            Student student3 = new Student(
                    "Student3",
                    "Student3",
                    "student3@mail.com"
            );

            List<Student> list = new ArrayList<>();
            list.add(student1);
            list.add(student2);
            list.add(student3);

            save(student1);
            save(student2);
            save(student3);

            return list;
        }

        return null;
    }
}
