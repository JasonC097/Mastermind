/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Spring 2024
 * Instructor: Prof. Lily Romano / Prof. Joshua Stough
 *
 * Name: Sarah Durkan
 * Section: 02
 * Date: 3/19/24
 * Time: 9:21 AM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: SolverCodeBreaker
 *
 * Description:
 *
 * ****************************************
 */
package hw01.solver;

import hw01.game.MastermindMain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class SolverCodeBreaker {

    /** List to sure the number of moves taken in each game to correctly guess the game solution*/
    protected static List<Integer> numMoves = new ArrayList<Integer>() {
    };

    /** Total number of moves taken in a single simulation*/
    private int totalMoves = 0;

    /** Shortest number of guesses taken to guess the solution in {@code numMoves}*/
    private int shortest;

    /** Longest number of guesses taken to guess the solution in {@code numMoves}*/
    private int longest;

    /** Average number of guesses from all simulations taken to guess the Mastermind solution*/
    private double average;

    /**
     * Abstract method used to run simulations
     *
     * @author sarahdurkan
     */
    public abstract void play();

    /**
     * Abstract method used to access the name of the solver being used for simulations
     *
     * @return the name of the solver
     * @author sarahdurkan
     */
    public abstract String getSolverName();

    /**
     * Displays the statistics from the simulation by sorting the
     * numMoves list to obtain the shortest, longest, and average number of guesses
     * taken to guess the correct Mastermind solution
     *
     * @return a formatted String displaying the simulation statistics
     * @author sarahdurkan
     */
    public String reportStatistics(){
        // calculate the total number of moves takes for all games
        for (int i : numMoves){
            totalMoves += i;
        }

        //calculate the average moves taken for all games
        average = (double) totalMoves / MastermindMain.getNumGames();

        // sort the list of number of moves taken per game in ascending order
        Collections.sort(numMoves);

        // first element is the shortest game, last is the longest
        shortest = numMoves.get(0);
        longest = numMoves.get(numMoves.size()-1);

        return String.format("RESULTS:%n" +
                getSolverName() + " - Statistics:%n"+
                "Number of games: " + MastermindMain.getNumGames() +"%n"+
                "Average: " + average + " turns%n"+
                "Shortest: "+ shortest+" turns%n"+
                "Longest: "+ longest +" turns%n"+
                "Total time: "+ MastermindMain.getTotalRuntime() + " s%n"+
                "Goodbye!");
    }
}
