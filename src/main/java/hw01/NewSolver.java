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

/**
 * SolverCodeBreaker concrete class that uses a StringBuilder to
 * cycle through guesses until it the guess is correct.
 *
 * @author sarahdurkan
 */
public class NewSolver extends SolverCodeBreaker{

    /** Guess for each simulation*/
    private static StringBuilder guess;

    /** Number of guesses taken*/
    private static int newSolGuessCount;

    /** Instantiate CodeMaker for new Code*/
    private static CodeMaker cm;

    /** Scoring pegs from each guess*/
    private String scoringPegs;

    @Override
    public void play() {
        resetGameStats();
        guessAndCheck();
    }

    /**
     * Method to return the name of the solver being used
     * @return "Build Solver"
     *
     * @author sarahdurkan
     */
    @Override
    public String getSolverName() {
        return "Build Solver";
    }

    /**
     * Re-initialize the game components
     * @author sarahdurkan
     */
    private void resetGameStats() {
        newSolGuessCount = 1;
        guess = new StringBuilder();
        cm = MastermindMain.getMaker();
    }

    /**
     * Move through each number until the scoring pegs have an additional *
     * Increments the guess count even if the guess length is less than the solution length.
     * Continues until the guess is correct.
     *
     * @author sarahdurkan
     */
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
