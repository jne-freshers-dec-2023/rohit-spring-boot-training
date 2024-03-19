package com.learn.learnspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retriveAllCouser()
    {
        return Arrays.asList(
                new Course(1,"learn spring boot" ,"xyz"),
                new Course(2,"learn sql","abc"),
                new Course(3,"learn sql teeo","adka"),
                new Course(4,"learn java ","adsad"),
                new Course(5,"learn java spring ","dhayugdha")
        );
    }
 }
