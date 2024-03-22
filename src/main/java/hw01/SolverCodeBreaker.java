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
package hw01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class SolverCodeBreaker {
    protected static List<Integer> numMoves = new ArrayList<Integer>() {
    };
    private int totalMoves = 0;
    private int shortest;
    private int longest;
    private double average;

    public abstract void play();

    public abstract String getSolverName();

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
