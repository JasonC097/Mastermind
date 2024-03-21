/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Spring 2024
 * Instructor: Prof. Lily Romano / Prof. Joshua Stough
 *
 * Name: Sarah Durkan
 * Section: 02
 * Date: 3/5/24
 * Time: 3:33 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: MastermindMain
 *
 * Description: Contains the main method to run a simple game of Mastermind
 *
 * ****************************************
 */
package hw01;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MastermindMain {

    /** GameManager object to be used in each game*/
    private static final GameManager mgr = new GameManager();

    /** CodeBreaker object to represent a player to be used in each game*/
    private static CodeBreaker breaker = new CodeBreaker();

    /** CodeMaker object to be used in each game*/
    private static CodeMaker maker;

    /** Stores a single guess made by the CodeBreaker*/
    private static String guess;

    /** Stores the scoring pegs placed by the CodeMaker*/
    private static String result;

    /** Boolean to indicate whether a CodeBreaker wants to continue playing Mastermind*/
    private static boolean isDone = false;

    /** Scanner object used to capture CodeBreaker input*/
    private static Scanner scnr = new Scanner(System.in);
    private static SolverCodeBreaker s;
    private static int numGames;
    private static boolean isValidNum = false;
    private static long startTime;
    private static long totalRuntime;

    /**
     * Main method used to play a game of Mastermind.
     * Continues until the breaker indicates they want to stop.
     *
     * @author sarahdurkan
     */
    public static void main(String[] args){
        System.out.println("Run Mastermind in Solver mode or User mode? [s | u]");
        if (scnr.nextLine().strip().equalsIgnoreCase("s")) {
            askForSolverMethod();
            getNumGamesToSim();
            simAndReportStats();
        }
        else{
            playUserGameMode();
        }

    }

    private static void simAndReportStats() {
        startTime = System.nanoTime();

        //play the game numGames times
        for (int i = 0; i <= numGames; i++){
            maker = new CodeMaker(); //generate a new solution
            s.play();
        }

        //calculate the total runtime in seconds
        totalRuntime = (System.nanoTime()-startTime);

        //report the sim statistics
        System.out.println(s.reportStatistics());
    }

    private static void getNumGamesToSim() {
        do {
            System.out.println("How many games would you like to simulate?");
            if (scnr.hasNextInt()) {
                numGames = Integer.parseInt(scnr.nextLine());
                isValidNum = true;
            }
            else{
                System.out.println("Please enter an integer.");
                scnr.nextLine();
            }
        } while (!isValidNum);
    }

    private static void askForSolverMethod() {
        System.out.println("Choose solver to run (Random, Minimax, Genetic) [r | m | g]");
        if (scnr.nextLine().strip().equalsIgnoreCase("r")){
            s = new RandomSolver();
        }
        else if (scnr.nextLine().strip().equalsIgnoreCase("m")){
            s = new MiniMaxSolver();
        }
        else {
            s = new GeneticSolver();
        }
    }

    private static void playUserGameMode() {
        do {
            maker = new CodeMaker();
            startGame();
            makeAndCheckGuesses();
            endGame();
            askToPlayAgain();
        } while (!isDone);
    }

    /**
     * Method to display the rules of the game to the user
     * @author sarahdurkan
     */
    public static void startGame(){
        System.out.println("Guess the code, using numbers between 1 and 6. You have 12 guesses.");
    }

    /**
     * Method to allow a player to make guesses and have them checked.
     * Continues to ask for guesses until the player has either figured out the solution
     * or reached the limit for guesses.
     *
     * @author sarahdurkan
     */
    private static void makeAndCheckGuesses() {
        do {
            makeGuesses();
            result = maker.checkGuess(guess);
        } while (!(result.equals("****") || mgr.getGuessCount() > mgr.getTotalGuesses()));
    }

    /**
     * Message displayed at the end of a game (win or loss)
     *
     * @author sarahdurkan
     */
    public static void endGame(){
        if (mgr.getGuessCount() > mgr.getTotalGuesses()){
            System.out.println("Sorry, ran out of attempts!");
            System.out.println("The answer was " + maker.getCodeAnswer());
        }
        else if (result.equals("****")){
            System.out.println("You win!! You guessed the code in "+ mgr.getGuessCount()+ " moves.");
        }
    }

    /**
     * Method used to ask a player if they want to play another round of the game.
     * Ends the game if the player enters 'n'.
     * Resets the guess count if the player selects any other letter.
     *
     * @author sarahdurkan
     */
    public static void askToPlayAgain(){
        System.out.println("Play again? [y | n]");
        if (scnr.nextLine().strip().equalsIgnoreCase("n")) {
            System.out.println("Goodbye!");
            isDone = true;
        }
        else{
            mgr.setGuessCount(1);
        }
    }

    /**
     * Helper method for player to make guesses
     *
     * @author sarahdurkan
     */
    private static void makeGuesses() {
            guess = breaker.makeGuess();
            checkGuess();
    }

    /**
     * Helper method for code maker to check guesses and print the scoring pegs.
     *
     * @author sarahdurkan
     */
    public static void checkGuess(){
        String result = maker.checkGuess(guess);
        System.out.println(guess + " --> "+ result);
    }

    public static int getNumGames() {
        return numGames;
    }

    public static long getTotalRuntime() {
        return totalRuntime;
    }

}
