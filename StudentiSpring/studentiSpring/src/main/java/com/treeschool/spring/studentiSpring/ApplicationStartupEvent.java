package com.treeschool.spring.studentiSpring;

import com.treeschool.spring.studentiSpring.model.Student;
import com.treeschool.spring.studentiSpring.model.StudentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class ApplicationStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private StudentManager sm;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        sm.add(new Student(1,2,"Mario", 23));
        sm.add(new Student(2,21,"Marco", 23));
        sm.add(new Student(3,22,"Marzo", 23));
        sm.add(new Student(4,23,"Marto", 23));
        sm.add(new Student(5,24,"Maro", 23));
        System.out.println(sm.getStudenti());

    }
}
