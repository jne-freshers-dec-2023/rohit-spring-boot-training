package com.springboot.JPAand.Hibernate.jpa;

import com.springboot.JPAand.Hibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course)
    {
        entityManager.persist(course);
    }

    public Course fetchCourse(int id)
    {
        return entityManager.find(Course.class,id);
    }

    public void deleteById(int id)
    {
        Course course=entityManager.find(Course.class,id);
        entityManager.remove(course);
    }
}
