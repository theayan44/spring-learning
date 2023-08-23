package com.example.springlearning.controller;

import com.example.springlearning.model.Student;
import com.example.springlearning.requestDto.AddStudentDto;
import com.example.springlearning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody AddStudentDto studentDto){
        String response = studentService.addStudent(studentDto);
        return response;
    }


    @GetMapping("/get")
    public Student displayStudent(@RequestParam int roll){
        Student response = studentService.viewStudent(roll);
        return response;
    }


    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }


    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam int roll){
        return studentService.deleteStudent(roll);
    }

    @GetMapping("/getDataByName")
    public List<Student> getByName(@RequestParam String name){
        return studentService.getByName(name);
    }

    @GetMapping("/graterThenMarks")
    public List<Student> moreThanMarks(@RequestParam int marks){
        return studentService.getByMoreThanMarks(marks);
    }

}
