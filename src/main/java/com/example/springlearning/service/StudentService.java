package com.example.springlearning.service;

import com.example.springlearning.model.ClassRoomModel;
import com.example.springlearning.model.Student;
import com.example.springlearning.repository.ClassRoomRepository;
import com.example.springlearning.repository.StudentRepository;
import com.example.springlearning.requestDto.AddStudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClassRoomRepository classRoomRepository;

    public String addStudent(AddStudentDto studentDto) {
        ClassRoomModel classRoomModel = classRoomRepository.findById(studentDto.getClassId()).get();

        Student student = new Student();
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        student.setRoll(studentDto.getRoll());
        student.setMarks(studentDto.getMarks());
        student.setClassRoom(classRoomModel);
        Student savedStudent = studentRepository.save(student);

        classRoomModel.getStudentList().add(savedStudent);
        classRoomRepository.save(classRoomModel);
        return savedStudent.toString();

    }

    public Student viewStudent(int roll){
        Optional<Student> obj= studentRepository.findById(roll);
        if(obj.isPresent()){
            return obj.get();
        }else{
            return null;
        }
    }

    public Student updateStudent(Student student) {
        Optional<Student> obj=studentRepository.findById(student.getRoll());
        if(obj.isPresent()){
            Student updateValue = obj.get();
            updateValue.setName(student.getName());
            return studentRepository.save(updateValue);
        }else{
            return null;
        }
    }

    public String deleteStudent(int roll) {
        Optional<Student> obj= studentRepository.findById(roll);
        if(obj.isPresent()){
            studentRepository.deleteById(roll);
            return "Deleted Successfully";
        }else{
            return "Data not found";
        }
    }

    public List<Student> getByName(String name) {
        List<Student> obj=studentRepository.findByName(name);
        if(obj.size() == 0)
            return null;
        return obj;
    }

    public List<Student> getByMoreThanMarks(int marks) {
//        List<Student> studentList=studentRepository.findAll();
//        List<Student> newList=new ArrayList<>();
//        for(Student s:studentList){
//            if(s.getMarks()>=marks)
//                newList.add(s);
//        }
//        return newList;
        List<Student> studentList = studentRepository.findByCustomMarks(marks);
        return studentList;
    }
}
