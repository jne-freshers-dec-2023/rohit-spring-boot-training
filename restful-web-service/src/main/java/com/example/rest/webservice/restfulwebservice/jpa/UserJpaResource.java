package com.example.rest.webservice.restfulwebservice.jpa;

import com.example.rest.webservice.restfulwebservice.user.Post;
import com.example.rest.webservice.restfulwebservice.user.User;
import com.example.rest.webservice.restfulwebservice.user.UserDaoService;
import com.example.rest.webservice.restfulwebservice.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {

    UserDaoService userDaoService;
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;


    @GetMapping("jpa/users")
    public ResponseEntity<List<User>> retrieveAllUsers() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity(users,HttpStatus.OK);
    }


//
//    //Hateoase
    @GetMapping("/jpa/user/{id}")
    public EntityModel<User> getUser(@PathVariable int id)
    {
        Optional<User> user =userRepository.findById(id);

        if(user.isEmpty()) {

            throw new UserNotFoundException("id: " + id);
        }

        EntityModel<User> entityModel=EntityModel.of(user.get());

        WebMvcLinkBuilder link= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());

        entityModel.add(link.withRel("all-users"));



        return entityModel;
    }
//
    @PostMapping("/jpa/saveuser")
    public void createUser(@Valid @RequestBody User user)
    {
        userRepository.save(user);
    }
//
    @DeleteMapping("/jpa/removeuser/{id}")
    public void removeUser(@PathVariable int id)
    {
        userRepository.deleteById(id);

    }

    @GetMapping("/jpa/userpost/{id}/posts")
    public List<Post> retrivePostForUser(@PathVariable int id)
    {
        Optional<User> user=userRepository.findById(id);

        if(user.isEmpty())
        {
            throw new UserNotFoundException("id "+id);
        }

            return user.get().getPosts();

    }


    @PostMapping("/jpa/setposttouser/{id}/posts")
    public ResponseEntity<Object> craetePostForUser(@PathVariable int id,@RequestBody Post post)
    {
        Optional<User> user=userRepository.findById(id);

        if(user.isEmpty())
        {
            throw new UserNotFoundException("id "+id);
        }

        post.setUser(user.get());

        postRepository.save(post);

        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


}
