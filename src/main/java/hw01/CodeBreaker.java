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
 * Description:
 *
 * ****************************************
 */
package hw01;

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
    private static boolean isGoodGuess;

    /** Scanner object to read player input*/
    private Scanner scnr = new Scanner(System.in);

    /** Guess made by the player*/
    private static String breakerGuess;

    public CodeBreaker(){
    }

    /**
     * Access the guess made
     * @author sarahdurkan
     */
    public static String getBreakerGuess(){
        return breakerGuess;
    }

    /**
     * Manually set the guess made by the breaker
     * @author sarahdurkan
     */
    public static void setBreakerGuess(String guess){
        breakerGuess = guess;
    }

    public static boolean getIsGoodGuess(){
        return isGoodGuess;
    }

    /**
     * Method used to get a guess from a player.
     * Continues to ask for input until a guess with length 4,
     * using only digits 1 through 6 is entered. Increases the number of guesses used.
     *
     * @return String breakerGuess: the guess from the player
     */

    public String makeGuess(){
        isGoodGuess = false;
        while (!isGoodGuess){
            System.out.println("Guess "+ GameManager.getGuessCount()+": ");
            if (!scnr.hasNext("[1-6]{4}")){
                System.out.println("Invalid Guess. Please try again.");
                scnr.nextLine();
            }
            else {
                breakerGuess = scnr.nextLine();
                GameManager.increaseGuessCount();
                isGoodGuess = true;
            }
        }
        return breakerGuess;
    }
}
