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
 * Description:
 *
 * ****************************************
 */

package hw01;

import java.util.Random;

public class GameManager {
    private static String gameSolution = "";

    private static int guessCount = 1;

    private static final int TOTAL_GUESSES = 12;

    private static final int GUESS_LENGTH = 4;
    private static Random random;

    public GameManager(){

    }

    public static int getGuessCount(){
        return guessCount;
    }

    public static String getGameSolution(){
        return gameSolution;
    }

    public static int getGuessLength(){
        return GUESS_LENGTH;
    }

    public static int getTotalGuesses(){
        return TOTAL_GUESSES;
    }
    public static String generateSolution(){
        random = new Random();
        for (int i = 0; i < GUESS_LENGTH; i++){
            int digit = random.nextInt(6)+1;
            gameSolution += Integer.toString(digit);
        }
        return gameSolution;
    }
    public static void increaseGuessCount(){
        guessCount++;
    }


}
