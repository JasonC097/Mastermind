/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Spring 2024
 * Instructor: Prof. Lily Romano / Prof. Joshua Stough
 *
 * Name: Sarah Durkan
 * Section: 02
 * Date: 3/5/24
 * Time: 3:33 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: MastermindMain
 *
 * Description:
 *
 * ****************************************
 */
package hw01;

import java.util.Scanner;

public class MastermindMain {

    private static final GameManager mgr = new GameManager();

    private static CodeBreaker breaker = new CodeBreaker();

    public static void main(String[] args){
        startGame();
        makeGuesses();
    }

    private static void makeGuesses() {
        while(GameManager.getGuessCount() < GameManager.getTotalGuesses()){
            breaker.makeGuess();
        }
    }

    public static void startGame(){
        GameManager.generateSolution();
        System.out.println(GameManager.getGameSolution()); //TODO get rid of this line
        System.out.println("Guess the code, using numbers between 1 and 6. You have 12 guesses.");
    }
}
