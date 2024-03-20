package com.springboot.JPAand.Hibernate.jdbc;

import com.springboot.JPAand.Hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseRepositoryCommandLineRunner implements CommandLineRunner {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
         courseRepository.insert(new Course(1,"java","games"));
//         courseRepository.delete(1);
        System.out.println(courseRepository.getCourse(1));
    }
}
