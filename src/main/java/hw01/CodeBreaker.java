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

public class CodeBreaker {
    private static List<String> guessesMade = new ArrayList<>();
    private boolean isGoodGuess;

    private Scanner scnr = new Scanner(System.in);

    private static String breakerGuess;

    public CodeBreaker(){
    }

    /**
     * Method used to get a guess from a player.
     * Continues to ask for input until a guess with length 4,
     * using only digits 1 through 6 is entered. Increases the number of guesses used.
     *
     * @return String breakerGuess: the guess from the player
     */

    //TODO finish
    public String makeGuess(){
        isGoodGuess = false;
        while (!isGoodGuess){
            System.out.println("Guess "+ GameManager.getGuessCount()+": ");
            if (!scnr.hasNext("[1-6]{4}")){
                System.out.println("Invalid Guess. Please try again.");
                scnr.nextLine();
            }
            else if (!(guessesMade.isEmpty()) && guessesMade.contains(scnr.nextLine())){
                System.out.println("Guess already made. Try again");
                scnr.nextLine();
            }
            else{ //TODO edit this statement to handle the guess if it is correct
                GameManager.increaseGuessCount();
                guessesMade.add(scnr.nextLine());
                isGoodGuess = true;
            }

        }
        breakerGuess = scnr.nextLine();
        return breakerGuess;
    }
}
