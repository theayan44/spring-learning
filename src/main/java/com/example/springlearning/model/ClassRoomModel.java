package com.example.springlearning.model;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ClassRoomModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String classTeacher;

    int capacity;

    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL)
    List<Student> studentList;
}
