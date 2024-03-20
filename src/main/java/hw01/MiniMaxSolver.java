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
public class MiniMaxSolver {
    private TreeSet<Integer> s = new TreeSet<>();

    private static final int LARGEST_NUM = 6666;

    private static final int SMALLEST_NUM = 1111;

    private static final int FIRST_GUESS = 1122;

    public MiniMaxSolver() {
        Pattern p = Pattern.compile("[1-6][1-6][1-6][1-6]");
        for (int i = SMALLEST_NUM; i <= LARGEST_NUM; i++){
            Matcher matches = p.matcher(String.valueOf(i));
            if (matches.matches()) {
                s.add(i);
            }
        }
    }
}