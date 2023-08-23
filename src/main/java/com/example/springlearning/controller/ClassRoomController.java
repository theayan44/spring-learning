package com.example.springlearning.controller;

import com.example.springlearning.model.ClassRoomModel;
import com.example.springlearning.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassRoomController {
    @Autowired
    ClassRoomService crs;

    @PostMapping("/addClass")
    public ClassRoomModel addClassRoom(@RequestBody ClassRoomModel crm){
        return crs.addClass(crm);
    }
}
