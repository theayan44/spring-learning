package com.example.springlearning.service;

import com.example.springlearning.model.ClassRoomModel;
import com.example.springlearning.repository.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClassRoomService {

    @Autowired
    ClassRoomRepository classRoomRepository;

    public ClassRoomModel addClass(ClassRoomModel crm) {
        crm.setStudentList(new ArrayList<>());
        return classRoomRepository.save(crm);
    }
}
