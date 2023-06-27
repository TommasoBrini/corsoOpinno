package com.treeschool.spring.studentiSpring;

import com.treeschool.spring.studentiSpring.configuration.ApplicationConfig;
import com.treeschool.spring.studentiSpring.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        StudentManager sm = (StudentManager) ctx.getBean("studentManager");
        sm.add(new Student(1, 2, "Marco", 23));
        sm.add(new Student(2, 21, "Andrea", 23));
        sm.add(new Student(3, 22, "Luigi", 23));
        sm.add(new Student(4, 23, "Mario", 23));
        sm.add(new Student(5, 24, "Matteo", 23));
        System.out.println(sm.getStudenti());
    }
}
