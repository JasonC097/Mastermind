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
package hw01;

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

    /** Constant for the first guess of each game for finding solution */
    private static final String FIRST_GUESS = "1122";

    /** Game used each time it is played */
    private CodeMaker game;

    /**
     * @author Jason Chung
     * MiniMaxSolver constructor that creates the set of all possible solutions
     */
    public MiniMaxSolver() {
        //Step 1
        //Ensures each digit is 1 through 6
        generateAllPossibleSolutions();
        this.game = new CodeMaker();
    }

    /**
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
     * The infamous five guess algorithm by Donal Kunth in getting the code
     * for Mastermind in five guesses
     */
    @Override
    public void play() {
        String currentGuess = FIRST_GUESS; //Step 2
        while (true) {
            String result = this.game.checkGuess(currentGuess); //Step 3
            if (result.equals("****")) {
                break; //Step 4
            } else {
                //Helper game to find other with same result as the current guess
                CodeMaker helperGame = new CodeMaker(currentGuess);
                TreeSet<Integer> unusedGuesses = setOfAnswers;
                unusedGuesses.remove(Integer.valueOf(currentGuess)); //Exclude current guess since not right9o8i
                //Step 5
                for (Integer code : setOfAnswers) {
                    String helperResult = helperGame.checkGuess(Integer.toString(code));
                    if (!helperResult.equals(result)) {
                        setOfAnswers.remove(code);
                    }
                }
                //Step 6
                TreeMap<String, Integer> findBestElim = new TreeMap<>();
                for (Integer code : unusedGuesses) {
                    TreeMap<String, Integer> helperMap = new TreeMap<>();
                    String strUnusedGuess = Integer.toString(code);
                    CodeMaker helpGame = new CodeMaker(strUnusedGuess);
                    for (Integer setCode : setOfAnswers) {
                        String response = helpGame.checkGuess(Integer.toString(setCode));
                        if (!(helperMap.containsKey(response))) {
                            helperMap.put(response, 1);
                        } else {
                            helperMap.put(response, findBestElim.get(response) + 1);
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
                // Find the guess with the smallest elimination to use next
                int smallestMaxScore = LARGEST_NUM;
                for (String guess : findBestElim.keySet()){
                    if (findBestElim.get(guess) < smallestMaxScore){
                        currentGuess = guess;
                        smallestMaxScore = findBestElim.get(guess);
                    }
                }
            }
        }
    }
}













