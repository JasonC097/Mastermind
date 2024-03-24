/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Spring 2024
 * Instructor: Prof. Lily Romano / Prof. Joshua Stough
 *
 * Name: Sarah Durkan
 * Section: 02
 * Date: 3/5/24
 * Time: 3:19 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: GameManager
 *
 * Description: Simple class to store game information such as the length of the solution,
 * how many guesses have been made, and generate the game solution.
 *
 * ****************************************
 */

package hw01.game;

import java.util.Random;

/**
 * @author sarahdurkan
 */
public class GameManager {
    /** String that represents the secret code*/
    private static String gameSolution = "";

    /** Stores the number of guesses a player has made*/
    private static int guessCount = 0;

    /** Total number of guesses a player can make to get a solution*/
    private static final int TOTAL_GUESSES = 12;

    /** The length of a proper guess*/
    private static final int GUESS_LENGTH = 4;

    /** Random generator used to create the solution*/
    private static Random random;

    public GameManager(){

    }

    /**
     * Access the number of guesses made
     * @author sarahdurkan
     */
    public static int getGuessCount(){
        return guessCount;
    }

    /**
     * Access the game solution
     * @author sarahdurkan
     */
    public static String getGameSolution(){
        return gameSolution;
    }

    /**
     * Access the guess length
     * @author sarahdurkan
     */
    public static int getGuessLength(){
        return GUESS_LENGTH;
    }

    /**
     * Access the total number of guesses allowed per game
     * @author sarahdurkan
     */
    public static int getTotalGuesses(){
        return TOTAL_GUESSES;
    }

    /**
     * Generates a 4-digit solution for a Mastermind game
     *
     * @return a String representation of the game solution
     * @author sarahdurkan
     */
    public static String generateSolution(){
        gameSolution = "";
        random = new Random();
        for (int i = 0; i < GUESS_LENGTH; i++){
            int digit = random.nextInt(6)+1;
            gameSolution += Integer.toString(digit);
        }
        return gameSolution;
    }

    /**
     * Increment the number of guesses made by a player as they make guesses
     *
     * @author sarahdurkan
     */
    public static void increaseGuessCount(){
        guessCount++;
    }

    /**
     * Function to manually set the number of guesses
     *
     * @param numGuesses the number that guessCount should be set to
     * @author sarahdurkan
     */
    public static void setGuessCount(int numGuesses){
        guessCount = numGuesses;
    }


}
