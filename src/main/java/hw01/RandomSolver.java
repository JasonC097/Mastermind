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
package hw01;

import java.util.Random;

public class RandomSolver extends SolverCodeBreaker{

    private String guess = "";

    private boolean correct = false;
    /** Random generator used to create the solution*/
    private static Random random;

    @Override
    public void play() {
        do{
            // generate a random guess
            random = new Random();
            for (int i = 0; i < GameManager.getGuessLength(); i++){
                int digit = random.nextInt(6)+1;
                guess += Integer.toString(digit);
            }

            // check if the guess is the solution
            if (guess.equals(GameManager.getGameSolution())){
                correct = true;
            }

        } while (!correct);
    }
}
