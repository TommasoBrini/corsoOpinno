package com.treeschool.spring.studentiSpring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private int id;
    private int matricola;
    private String nome;
    private int età;
}
