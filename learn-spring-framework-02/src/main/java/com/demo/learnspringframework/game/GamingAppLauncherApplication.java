package com.demo.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


    @Configuration
    @ComponentScan("com.demo.learnspringframework.game")
    public class GamingAppLauncherApplication {

        //    @Bean
        //    public GameConsole game()
        //    {
        //        var game =new PacmanGame();
        //        return game;
        //    }

        //    @Bean
        //    public GameRunner gameRunner(GameConsole game)
        //    {
        //        System.out.println("Game:"+game);
        //        var gameRunner=new GameRunner(game);
        //        return gameRunner;
        //    }

        public static void main(String[] args) {

            try(var context=new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class);)
            {
                //            context.getBean(GameConsole.class).up();

                context.getBean(GameRunner.class).run();
            }


        }
    }

