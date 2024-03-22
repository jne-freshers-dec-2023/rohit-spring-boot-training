package com.spring.learnspringsecurity;

import jakarta.annotation.security.RolesAllowed;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.logging.Logger;


record Todo(String username,String description){}


@RestController
@EnableMethodSecurity(jsr250Enabled = true)
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
    @PreAuthorize("hasRole('user') and #username == authentication.name")
    @PostAuthorize("returnObject.username=='rohit'")
    @RolesAllowed({"admin","user"})
    public Todo retriveTodosForSpecidficUser(@PathVariable String username)
    {
        return todo_list.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public String saveUser(@PathVariable String username ,@RequestBody Todo todo)
    {
            return username;
    }
}
