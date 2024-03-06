/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Spring 2024
 * Instructor: Prof. Lily Romano / Prof. Joshua Stough
 *
 * Name: Jason Chung
 * Section: 02 / 61
 * Date: 3/6/2024
 * Time: 2:42 PM
 *
 * Project: csci205_hw
 * Package: hw01
 * Class: CodeMaker
 *
 * Description:
 *
 * ****************************************
 */
package hw01;

/**
 * @author Jason Chung
 * Class to call an answer for the game and comapres the 
 * user's guess with the answer
 */
public class CodeMaker {
    /** The answer from GameManager */
    private String codeAnswer;
    public CodeMaker(){
        // Call GameManager's generate solution to
        this.codeAnswer = GameManager.generateSolution();
    }

    /**
     * Goes through a user's guess and compares it to the answer
     *
     * @param breakGuess - a String of numbers that the user guesses is the answer
     * @return - a String that shows how many numbers in the user's guess that are
     * in the right spot, contained in the answer, or not part of the answer
     */
    public String checkGuess(String breakGuess){
        String response = "";
        int inCode = 0;
        // Go through the user's guess to find numbers in the right spot or user's guess contains the right number but in the wrong spot
        for (int i = 0; i < breakGuess.length(); i++){
            if (breakGuess.charAt(i) == this.codeAnswer.charAt(i)){
                response = response.concat("*");
            } else if (codeAnswer.contains(Character.toString(breakGuess.charAt(i)))) {
                inCode += 1;
            }
        }
        // Fill the rest of response with numbers in the code with "+" and/or wrong numbers with "-"
        for (int i = response.length(); i < breakGuess.length(); i++){
            if (inCode > 0){
                response = response.concat("+");
                inCode -= 1;
            } else {
                response = response.concat("-");
            }
        }
        return response;
    }
}