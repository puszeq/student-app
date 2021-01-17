package com.springboot.studentapp.controller;

import com.springboot.studentapp.entity.Student;
import com.springboot.studentapp.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String listStudent(Model model){
        List<Student> students = studentService.findAll();

        if(students.isEmpty()) {
            students = studentService.prepareStartData();
        }

        model.addAttribute("students", students);

        return "students/list-students";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Student student = new Student();
        model.addAttribute("student", student);

        return "students/students-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int id, Model model){

        Student student = studentService.findById(id);
        model.addAttribute("student", student);

        return "students/students-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int id){
        studentService.deleteById(id);

        return "redirect:/students/list";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.save(student);

        return "redirect:/students/list";
    }
}
