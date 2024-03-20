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

public abstract class SolverCodeBreaker {
    private Integer[] numMoves;
    private int totalMoves = 0;
    private int shortest;
    private int longest;
    private double average;

    private double totalTime;

    public abstract void play();

    public String reportStatistics(){
        for (int i : numMoves){
            totalMoves += i;
        }
        //todo need a way to get total games played
        //todo need comparator to compare every number in the numMoves list
        average = totalMoves;
        shortest = 0;
        longest = 0;
        return String.format("RESULTS:\n " +
                "solverName - Statistics:\n"+
                "Number of games: "  + "getNumGames\n"+
                "Average: %.1f turns%n" + average +
                "Shortest: %n" + shortest + " turns"+
                "Longest: %n" + longest + " turns"+
                "Total time: %.2f %n" + totalTime +
                "Goodbye!");
    }
}
