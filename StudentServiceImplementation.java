package com.boo.springboottest.services;

import java.util.List;

import com.boo.springboottest.model.Student;
import com.boo.springboottest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class StudentServiceImplementation implements StudentService {

    @Autowired
    StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

}
