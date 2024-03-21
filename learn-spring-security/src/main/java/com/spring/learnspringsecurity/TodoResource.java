package com.spring.learnspringsecurity;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.logging.Logger;


record Todo(String username,String description){}


@RestController
public class TodoResource {

//    private Logger logger= (Logger) LoggerFactory.getLogger(getClass());

    public static final List<Todo> todo_list=List.of(new Todo("rohit","Learn Spring Boot"),
            new Todo("nishant","Learn Java"));

    @GetMapping("/todos")
    public List<Todo> retriveAllTodos()
    {
        return todo_list;
    }

    @GetMapping("/users/{username}/todos")
    public Todo retriveTodosForSpecidficUser(@PathVariable String username)
    {
        return todo_list.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public String saveUser(@PathVariable String username ,@RequestBody Todo todo)
    {
            return "rohit";
    }
}
