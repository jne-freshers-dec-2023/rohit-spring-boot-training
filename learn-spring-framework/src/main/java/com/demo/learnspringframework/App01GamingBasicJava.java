package com.demo.learnspringframework;

import com.demo.learnspringframework.game.GameRunner;
import com.demo.learnspringframework.game.PacmanGame;

public class App01GamingBasicJava {

    public static void main(String[] args) {

//        var game=new MarioGame();

        var game=new PacmanGame();
//        var game=new SuperContraGame();
        var gameRunner=new GameRunner(game); //game dependant of gamerunner

        gameRunner.run();
    }
}
