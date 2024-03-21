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
public class MiniMaxSolver extends SolverCodeBreaker{
    /** The set containing all possible secret code */
    private TreeSet<Integer> setOfAnswers = new TreeSet<>();

    /** Constant for the "largest" secret code possible*/
    private static final int LARGEST_NUM = 6666;

    /** Constant for the "smallest" secret code possible*/
    private static final int SMALLEST_NUM = 1111;

    /** Constant for the first guess of each game for finding solution*/
    private static final String FIRST_GUESS = "1122";

    /**
     * @author Jason Chung
     * MiniMaxSolver constructor that creates the set of all possible solutions
     */
    public MiniMaxSolver() {
        //Ensures each digit is 1 through 6
        Pattern p = Pattern.compile("[1-6][1-6][1-6][1-6]");
        for (int i = SMALLEST_NUM; i <= LARGEST_NUM; i++){
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
    public void play(){
        CodeMaker game = new CodeMaker();
        String currentGuess = FIRST_GUESS;
        while (true){
            String result = game.checkGuess(currentGuess);
            if (result.equals("****")){
                break;
            }
            else {
                //Helper game to find other with same result as the current guess
                CodeMaker helperGame = new CodeMaker(currentGuess);
                TreeSet<Integer> helperSet = setOfAnswers;
                helperSet.remove(Integer.valueOf(currentGuess));
                for (Integer code : setOfAnswers){
                    String helperResult = helperGame.checkGuess(Integer.toString(code));
                    if (!helperResult.equals(result)){
                        setOfAnswers.remove(code);
                    }
                }
            }
        }
    }
}













