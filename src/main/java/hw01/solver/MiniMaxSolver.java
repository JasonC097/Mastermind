/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Spring 2024
 * Instructor: Prof. Lily Romano / Prof. Joshua Stough
 *
 * Name: Jason Chung
 * Section: 02 / 61
 * Date: 3/20/2024
 * Time: 1:41 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: MiniMaxSolver
 *
 * Description: Teamwork Project
 *
 * ****************************************
 */
package hw01.solver;

import hw01.game.CodeMaker;
import hw01.solver.SolverCodeBreaker;

import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jason Chung
 * A solver class that solves the Mastermind game
 * in five guesses or fewer
 * Sources used:
 * <a href="https://github.com/NathanDuran/Mastermind-Five-Guess-Algorithm?tab=readme-ov-file">Nathan Duran Mastermind Five Guess Algorithm</a>
 */
public class MiniMaxSolver extends SolverCodeBreaker {
    /** The set containing all possible secret code */
    private TreeSet<Integer> setOfAnswers = new TreeSet<>();

    /** Constant for the "largest" secret code possible */
    private static final int LARGEST_NUM = 6666;

    /** Constant for the "smallest" secret code possible */
    private static final int SMALLEST_NUM = 1111;

    /** Kunth's first guess of each game for finding solution is "1122" */
    private static final String FIRST_GUESS = "1122";

    /** The number of guesses it takes for Minimax solver to solve*/
    private int numGuesses = 0;

    /** Game used each time it is played */
    private CodeMaker game;

    /**
     * @author Jason Chung
     * MiniMaxSolver constructor creates the game
     */
    public MiniMaxSolver() {
    }

    /**
     * @author Jason Chung
     * Method that generates the possible answers from 1111-6666
     */
    private void generateAllPossibleSolutions() {
        Pattern p = Pattern.compile("[1-6][1-6][1-6][1-6]");
        for (int i = SMALLEST_NUM; i <= LARGEST_NUM; i++) {
            Matcher matches = p.matcher(String.valueOf(i));
            if (matches.matches()) {
                setOfAnswers.add(i);
            }
        }
    }

    /**
     * @author Jason Chung
     * Getter method of getting the number of guesses it takes to find the answer
     * Used for JUnit testing
     * @return int of the number of guesses taken
     */
    public int getNumGuesses () {return this.numGuesses;}

    /**
     * @author Jason Chung
     * The infamous five guess algorithm by Donal Kunth in getting the code
     * for Mastermind in five guesses
     */
    @Override
    public void play() {
        //Step 1
        //Ensures each digit is 1 through 6
        startGame();
        String currentGuess = FIRST_GUESS; //Step 2
        TreeSet <Integer> unusedGuesses = new TreeSet<>();
        unusedGuesses.addAll(setOfAnswers);
        while (true) {
            String result = processGuess(currentGuess, unusedGuesses); //Step 3
            if (result.equals("****")) { //Step 4
                SolverCodeBreaker.numMoves.add(this.numGuesses);
                break;
            } else {
                // Step 5
                removeImpossibleGuesses(currentGuess, result);
                //Step 6
                TreeMap <String, Integer> findBestElim = maxHitOfGuessesRemaining(unusedGuesses);
                // Find the guesses with the smallest elimination to use next
                TreeSet <String> guessesWithMin = findGuessesWithMinElim(findBestElim);
                // Determine the next guess
                currentGuess = findNextGuess(currentGuess, guessesWithMin);
            }
        }
    }

    /**
     * @author Jason Chung
     * Helper method for starting up a new game
     */
    private void startGame() {
        generateAllPossibleSolutions();
        this.numGuesses = 0;
        this.game = new CodeMaker();
    }

    /**
     * @author Jason Chung
     * Helper method of using the guess in the game
     * @param currentGuess - String of the guess used for the game
     * @param unusedGuesses - Set of all the unused guesses made in the game
     * @return - String of the result from the guess
     */
    private String processGuess(String currentGuess, TreeSet<Integer> unusedGuesses) {
        String result = this.game.checkGuess(currentGuess); //Step 3
        unusedGuesses.remove(Integer.valueOf(currentGuess)); //currentGuess used to get result
        this.setOfAnswers.remove(Integer.valueOf(currentGuess));
        this.numGuesses = this.numGuesses + 1; //Did 1 guess
        return result;
    }

    /**
     * @author Jason Chung
     * Helper method in finding the next guess to try
     * @param currentGuess - String of the guess used
     * @param guessesWithMin - set of all the guesses with the same minimum eliminations
     * @return String of the next guess to use by the Minimax Solver
     */
    private String findNextGuess(String currentGuess, TreeSet<String> guessesWithMin) {
        String oldGuess = currentGuess;
        // Prioritize a min guess that is in setOfAnswers
        for (String guess : guessesWithMin){
            if (setOfAnswers.contains(Integer.valueOf(guess))){
                currentGuess = guess;
                break;
            }
        }
        // Grabs the smallest best guess to use next in case none are in the setOfAnswers
        if (currentGuess.equals(oldGuess)){
            currentGuess = guessesWithMin.first();
        }
        return currentGuess;
    }

    /**
     * @author Jason Chung
     * Helper method to finding all the guesses that has the lowest minimum score
     * @param findBestElim - Map containing the maximum eliminations each guess gives
     * @return - Set of all the guesses with the same lowest elimination
     */
    private static TreeSet<String> findGuessesWithMinElim(TreeMap<String, Integer> findBestElim) {
        int smallestMaxScore = LARGEST_NUM;
        TreeSet<String> guessesWithMin = new TreeSet<>();
        for (String guess : findBestElim.keySet()){
            if (findBestElim.get(guess) < smallestMaxScore){
                smallestMaxScore = findBestElim.get(guess);
            }
        }
        for (String guess : findBestElim.keySet()){
            if (findBestElim.get(guess) == smallestMaxScore){
                guessesWithMin.add(guess);
            }
        }
        return guessesWithMin;
    }

    /**
     * @author Jason Chung
     * Helper method of removing the guesses that would NOT give the same
     * response to the one used to currently guess
     * @param currentGuess - the guess used currently
     * @param result
     */
    private void removeImpossibleGuesses(String currentGuess, String result) {
        //Helper game to find other with same result as the current guess
        CodeMaker helperGame = new CodeMaker(currentGuess);

        TreeSet<Integer> helperSet = new TreeSet<>();
        helperSet.addAll(setOfAnswers);
        for (Integer code : helperSet) {
            String helperResult = helperGame.checkGuess(Integer.toString(code));
            if (!helperResult.equals(result)) {
                setOfAnswers.remove(code);
            }
        }
    }

    /**
     * @author Jason Chung
     * Helper method to finding the maximum number of elimination of the remaining guesses not used
     * @param unusedGuesses - set of guesses the solver has not used yet
     * @return - Map of each response to the number of eliminations out of the remaining guesses unused
     */
    private TreeMap<String, Integer> maxHitOfGuessesRemaining(TreeSet<Integer> unusedGuesses) {
        TreeMap<String, Integer> findBestElim = new TreeMap<>();
        for (Integer code : unusedGuesses) {
            TreeMap<String, Integer> helperMap = new TreeMap<>();
            String strUnusedGuess = Integer.toString(code);
            CodeMaker helpGame = new CodeMaker(strUnusedGuess);
            for (Integer setCode : setOfAnswers) {
                String response = helpGame.checkGuess(Integer.toString(setCode));
                if (helperMap.containsKey(response)) {
                    helperMap.put(response, helperMap.get(response) + 1);
                } else {
                    helperMap.put(response, 1);
                }
            }
            // Finds the largest amount of elimination strUnusedGuess can find
            int score = 0;
            for (Integer value : helperMap.values()){
                if (value > score){
                    score = value;
                }
            }
            findBestElim.put(strUnusedGuess, score);
        }
        return findBestElim;
    }

    @Override
    public String getSolverName() {
        return "MiniMax Solver";
    }
}













