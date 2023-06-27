package com.treeschool.spring.studentiSpring.configuration;

import com.treeschool.spring.studentiSpring.StudentManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public StudentManager studentManager(){
        return new StudentManager();
    }

}
