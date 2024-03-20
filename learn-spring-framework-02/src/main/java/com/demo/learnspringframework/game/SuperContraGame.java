package com.demo.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifire")
public class SuperContraGame implements GameConsole{

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
        System.out.println("shoot bullet");
    }
}
