package com.treeschool.spring.studentiSpring.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class StudentManager {

    List<Student> studenti = new ArrayList<>();

    @Autowired
    public StudentManager(List<Student> st){
        studenti = st;
    }

    public void add(Student st){
        studenti.add(st);
    }

}
