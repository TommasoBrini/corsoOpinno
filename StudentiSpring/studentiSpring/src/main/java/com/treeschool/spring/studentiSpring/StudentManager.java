package com.treeschool.spring.studentiSpring;

import com.treeschool.spring.studentiSpring.model.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StudentManager {

    List<Student> studenti = new ArrayList<>();

    public void add(Student st){
        studenti.add(st);
    }

}
