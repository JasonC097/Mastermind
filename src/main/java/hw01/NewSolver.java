/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Spring 2024
 * Instructor: Prof. Lily Romano / Prof. Joshua Stough
 *
 * Name: Sarah Durkan
 * Section: 02
 * Date: 3/21/24
 * Time: 3:07 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: NewSolver
 *
 * Description:
 *
 * ****************************************
 */
package hw01;

import java.util.Random;

public class NewSolver extends SolverCodeBreaker{

    private static StringBuilder guess;

    private boolean correct;

    private static int newSolGuessCount;

    private static CodeMaker cm;
    private String scoringPegs;

    @Override
    public void play() {
        resetGameStats();
        guessAndCheck();
    }

    @Override
    public String getSolverName() {
        return "Build Solver";
    }

    private void resetGameStats() {
        correct = false;
        newSolGuessCount = 0;
        guess = new StringBuilder();
        cm = MastermindMain.getMaker();
    }

    private void guessAndCheck() {

        guess.append("1");
        scoringPegs = cm.checkGuess(String.valueOf(guess));
        while (!scoringPegs.equals("*")) {
            int nextGuess = Integer.parseInt(String.valueOf(guess)) + 1;
            guess = new StringBuilder(String.valueOf(nextGuess));
            scoringPegs = cm.checkGuess(String.valueOf(guess));
            newSolGuessCount++;
        }

        guess.append("1");
        scoringPegs = cm.checkGuess(String.valueOf(guess));
        while (!scoringPegs.equals("**")) {
            int nextGuess = Integer.parseInt(String.valueOf(guess)) + 1;
            guess = new StringBuilder(String.valueOf(nextGuess));
            scoringPegs = cm.checkGuess(String.valueOf(guess));
            newSolGuessCount++;
        }

        guess.append("1");
        scoringPegs = cm.checkGuess(String.valueOf(guess));
        while (!scoringPegs.equals("***")) {
            int nextGuess = Integer.parseInt(String.valueOf(guess)) + 1;
            guess = new StringBuilder(String.valueOf(nextGuess));
            scoringPegs = cm.checkGuess(String.valueOf(guess));
            newSolGuessCount++;
        }

        guess.append("1");
        scoringPegs = cm.checkGuess(String.valueOf(guess));
        while (!scoringPegs.equals("****")) {
            int nextGuess = Integer.parseInt(String.valueOf(guess)) + 1;
            guess = new StringBuilder(String.valueOf(nextGuess));
            scoringPegs = cm.checkGuess(String.valueOf(guess));
            newSolGuessCount++;
        }

        //Add number of moves taken to the list of all moves
        numMoves.add(newSolGuessCount);
    }
}
