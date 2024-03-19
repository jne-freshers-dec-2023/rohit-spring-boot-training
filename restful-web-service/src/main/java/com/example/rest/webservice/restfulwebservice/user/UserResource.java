package com.example.rest.webservice.restfulwebservice.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users" )
    public List<User> retrieveAllUsers()
    {
        return userDaoService.getAllUsers();
    }

    //Hateoase
    @GetMapping("/user/{id}")
    public EntityModel<User> getUser(@PathVariable int id)
    {
        User user=userDaoService.getUser((id-1));

        EntityModel<User> entityModel=EntityModel.of(user);

        WebMvcLinkBuilder link= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());

        entityModel.add(link.withRel("all-users"));

        if(user == null) {

            throw new UserNotFoundException("id: " + id);
        }

        return entityModel;
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user)
    {
         userDaoService.saveUser(user);

        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return  ResponseEntity.created(location).build();
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> removeUser(@PathVariable int id)
    {
        User user=userDaoService.deleteUser((id-1));
        if(user == null)
        {
            throw new UserNotFoundException("id: "+id);
        }

        return ResponseEntity.ok().build();
    }



}
