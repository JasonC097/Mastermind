/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Spring 2024
 * Instructor: Prof. Lily Romano / Prof. Joshua Stough
 *
 * Name: Sarah Durkan
 * Section: 02
 * Date: 3/5/24
 * Time: 3:27 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: CodeBreaker
 *
 * Description: Functions used by the player who is trying to guess the code in Mastermind.
 *
 * ****************************************
 */
package hw01.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sarahdurkan
 */
public class CodeBreaker {
    /** List to store guesses already made by user*/
    private static List<String> guessesMade = new ArrayList<>();

    /** Boolean value dependent on if a p;ayer has produced valid input*/
    private boolean isGoodGuess;

    /** Scanner object to read player input*/
    private Scanner scnr = new Scanner(System.in);

    /** Guess made by the player*/
    private static String breakerGuess;

    public CodeBreaker(){
    }

    /**
     * Method used to get a guess from a player.
     * Continues to ask for input until a guess with length 4,
     * using only digits 1 through 6 is entered. Increases the number of guesses used.
     *
     * @return String breakerGuess: the guess from the player
     * @author sarahdurkan
     */

    public String makeGuess(){
        isGoodGuess = false;
        while (!isGoodGuess){
            System.out.println("Guess " + (GameManager.getGuessCount() + 1) +": ");
            if (!scnr.hasNext("[1-6]{4}")){
                System.out.println("Invalid Guess. Please try again.");
                scnr.nextLine();
            }
            else {
                breakerGuess = scnr.next();
                GameManager.increaseGuessCount();
                isGoodGuess = true;
            }
        }
        return breakerGuess;
    }
}
