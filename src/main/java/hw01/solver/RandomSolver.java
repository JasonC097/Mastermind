/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Spring 2024
 * Instructor: Prof. Lily Romano / Prof. Joshua Stough
 *
 * Name: Sarah Durkan
 * Section: 02
 * Date: 3/20/24
 * Time: 2:05 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: RandomSolver
 *
 * Description:
 *
 * ****************************************
 */
package hw01.solver;

import hw01.game.GameManager;
import hw01.solver.SolverCodeBreaker;

import java.util.Random;

/**
 * @author sarahdurkan
 *
 * A solver class that uses randomization to make guesses
 * in order to solve the Mastermind game.
 */
public class RandomSolver extends SolverCodeBreaker {

    /** Initialize an empty guess*/
    private String guess = "";

    /** Boolean value to determine whether a guess is correct*/
    private boolean correct;

    /** Random generator used to create the solution*/
    private static Random random;

    /** The number of guesses taken for a single simulated game*/
    private static int randGuessCount;

    @Override
    public void play() {
        resetGameStats();
        do{
            genRandomGuess();
            checkRandomGuess();
        } while (!correct);
    }

    /**
     * Method to return the name of the solver being used
     * @return "Build Solver"
     *
     * @author sarahdurkan
     */
    @Override
    public String getSolverName() {
        return "Random Solver";
    }

    /**
     * Re-initialize the game components
     * @author sarahdurkan
     */
    public void resetGameStats() {
        correct = false;
        randGuessCount = 0;
    }

    /**
     * Method to check whether a guess is equal to the Mastermind solution
     *
     * @author sarahdurkan
     */
    public void checkRandomGuess() {
        // check if the guess is the solution
        if (guess.equals(GameManager.getGameSolution())){
            SolverCodeBreaker.numMoves.add(randGuessCount);
            correct = true;
        }
    }

    /**
     * Method used to generate a single random guess
     * Increments the number of guesses taken in a single game.
     *
     * @author sarahdurkan
     */
    public void genRandomGuess() {
        //reset guess to an empty string
        guess = "";

        // generate a random guess
        random = new Random();
        for (int i = 0; i < GameManager.getGuessLength(); i++){
            int digit = random.nextInt(6)+1;
            guess += Integer.toString(digit);
        }

        //Increase the guess count
        randGuessCount++;
    }

    /**
     * Getter method to return whether a guess is correct
     *
     * @author sarahdurkan
     */
    public boolean isCorrect() {
        return correct;
    }

    /**
     * Getter method to return the random guess made
     *
     * @author sarahdurkan
     */
    public String getGuess() {
        return guess;
    }

    /**
     * Getter method to return the number of guesses taken
     *
     * @author sarahdurkan
     */
    public static int getRandGuessCount() {
        return randGuessCount;
    }
}
