package com.demo.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class PacmanGame implements GameConsole{

    public void up()
    {
        System.out.println("up");
    }
    public  void down()
    {
        System.out.println("down");
    }
    public void left()
    {
        System.out.println("left");
    }
    public void right()
    {
        System.out.println("right");
    }

}
