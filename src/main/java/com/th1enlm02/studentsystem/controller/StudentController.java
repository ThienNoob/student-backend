package com.th1enlm02.studentsystem.controller;

import com.th1enlm02.studentsystem.model.Student;
import com.th1enlm02.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/student")
@CrossOrigin (origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "New student is added";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Integer id) {
        try {
            Student student = studentService.getStudent(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Integer id) {
        try {
            Student existingStudent = studentService.getStudent(id);
            studentService.saveStudent(student);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            studentService.deleteStudent(id);
            return new ResponseEntity<>("Deleted student with id " + id, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
