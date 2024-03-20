package com.springboot.JPAand.Hibernate.springdatajpa;

import com.springboot.JPAand.Hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseSpringJpaCommadLineRunner implements CommandLineRunner {

    @Autowired
    CourseSpringDataJpaRepository courseSpringDataJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        courseSpringDataJpaRepository.save(new Course(3,"Rahul","xyz"));

//        System.out.println(courseSpringDataJpaRepository.findById(3l));

//        System.out.println(courseSpringDataJpaRepository.findAll());

        System.out.println(courseSpringDataJpaRepository.count());

        System.out.println(courseSpringDataJpaRepository.findByAuthor("xyz"));
    }
}
