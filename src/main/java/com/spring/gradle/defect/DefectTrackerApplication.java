package com.spring.gradle.defect;

import com.spring.gradle.defect.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DefectTrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DefectTrackerApplication.class, args);
    }

    @Bean
    public User user() {
        return new User();
    }

}
