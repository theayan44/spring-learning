package com.example.springlearning.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
//@Table(name = "students")
public class Student {

    String name;

    @Id
    int roll;

    int marks;

    int age;

    @ManyToOne
    @JoinColumn
    ClassRoomModel classRoom;

    public String toString(){
        return "Name: " + this.name +
                "\nroll: "+ this.roll +
                "\nage: " + this.age +
                "\nmarks: " + this.marks +
                "\nClassRoom: " + this.classRoom.getId();
    }


}
