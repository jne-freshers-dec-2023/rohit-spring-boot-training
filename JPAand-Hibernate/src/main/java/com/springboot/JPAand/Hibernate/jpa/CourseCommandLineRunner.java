package com.springboot.JPAand.Hibernate.jpa;

import com.springboot.JPAand.Hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    CourseJpaRepository courseJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJpaRepository.insert(new Course(2,"pratik jpa","abc"));
        courseJpaRepository.fetchCourse(1);

    }
}
