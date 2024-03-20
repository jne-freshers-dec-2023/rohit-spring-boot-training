package com.example.rest.webservice.restfulwebservice.jpa;

import com.example.rest.webservice.restfulwebservice.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
