package com.springboot.JPAand.Hibernate.springdatajpa;

import com.springboot.JPAand.Hibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course,Long> {

    List<Course> findByAuthor(String author);
}
