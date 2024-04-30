package com.th1enlm02.studentsystem.service;

import com.th1enlm02.studentsystem.model.Student;
import com.th1enlm02.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
