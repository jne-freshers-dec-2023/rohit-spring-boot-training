package com.demo.learnspringframework.game;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Comments;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GameConsole{

    public void up()
    {
        System.out.println("jump");
    }
    public  void down()
    {
        System.out.println("Go into a hole");
    }
    public void left()
    {
        System.out.println("Go Back");
    }
    public void right()
    {
        System.out.println("jump down");
    }
}
