package com.treeschool.spring.studentiSpring;

import com.treeschool.spring.studentiSpring.configuration.ApplicationConfig;
import com.treeschool.spring.studentiSpring.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class StudentiSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentiSpringApplication.class, args);

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		StudentManager sm = (StudentManager) ctx.getBean("studentManager");
		System.out.println(sm.getStudenti());
	}

}
