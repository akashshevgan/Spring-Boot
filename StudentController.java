package com.boo.springboottest.controller;

import com.boo.springboottest.model.Student;
import com.boo.springboottest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {


    @Autowired
    StudentService studentService;


    @GetMapping("/list")
    public List<Student> list() {
        List<Student> studentList = studentService.getAllStudents();
        return studentList;
    }



    @PostMapping ("/addStudent")
    public ResponseEntity<Student> addStudent() {

        ModelAndView model = new ModelAndView();
        Student student = new Student();
        studentService.addStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }



    @GetMapping(value="/getStudent/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


    @DeleteMapping(value="/deleteStudent/{id}")
    public ResponseEntity<Student> delete(@PathVariable("id") int id) {

        studentService.deleteStudent(id);
        return new ResponseEntity<>(new Student(), HttpStatus.OK);
    }
}
