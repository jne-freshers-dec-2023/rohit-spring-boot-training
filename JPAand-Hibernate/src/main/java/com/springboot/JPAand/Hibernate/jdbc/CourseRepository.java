package com.springboot.JPAand.Hibernate.jdbc;

import com.springboot.JPAand.Hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String insertquery= """
            insert into Course(id,name,author) values(?,?,?);
            """;

    private static String deleteRecord= """
            delete from course where id=?;
            """;

    private static String fetchCourse= """
            select * from course where id=?;
            """;

    public void insert(Course course)
    {
        jdbcTemplate.update(insertquery,course.getId(),course.getName(),course.getAuthor());
    }

    public void delete(int id)
    {
        jdbcTemplate.update(deleteRecord,id);
    }

    public Course getCourse(int id)
    {
         return jdbcTemplate.queryForObject(fetchCourse,new BeanPropertyRowMapper<>(Course.class),id);
    }

}
