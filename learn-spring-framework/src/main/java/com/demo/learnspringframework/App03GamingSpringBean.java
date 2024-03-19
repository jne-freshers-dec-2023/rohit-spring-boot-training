package com.demo.learnspringframework;

import com.demo.learnspringframework.game.GameConsole;
import com.demo.learnspringframework.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBean {

    public static void main(String[] args) {

        try(var context=new AnnotationConfigApplicationContext(GamingConfiguration.class);)
        {
            context.getBean(GameConsole.class).up();

            context.getBean(GameRunner.class).run();
        }


    }
}
