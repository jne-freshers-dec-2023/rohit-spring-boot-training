package com.demo.learnspringframework;

import com.demo.learnspringframework.game.GameConsole;
import com.demo.learnspringframework.game.GameRunner;
import com.demo.learnspringframework.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GameConsole game()
    {
        var game =new PacmanGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(GameConsole game)
    {
        var gameRunner=new GameRunner(game);
        return gameRunner;
    }

}
