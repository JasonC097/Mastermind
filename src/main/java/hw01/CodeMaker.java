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
 * Description: Teamwork project
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

    /**
     * Normally called CodeMaker that calls GameManager.generateSolution for generating solution
     */
    public CodeMaker(){
        // Call GameManager's generate solution to
        this.codeAnswer = GameManager.generateSolution();
    }
    /**
     * Constructor to help with JUnit tests
     */
    public CodeMaker(String manualCode){
        this.codeAnswer = manualCode;
    }

    /**
     * Getter function to access the code answer.
     *
     * @return the code to break
     * @author sarahdurkan
     */
    public String getCodeAnswer(){
        return codeAnswer;
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
        StringBuilder answerCopy = new StringBuilder(this.codeAnswer);
        // Finds numbers in right spot first and exclude them in the copy of the answer
        for (int i = 0; i < breakGuess.length(); i++) {
            char checkNum = breakGuess.charAt(i);
            if (checkNum == this.codeAnswer.charAt(i)) {
                response = response.concat("*");
                answerCopy.setCharAt(i, 'n'); //n is place holder
            }
        }
        // Checks to see if remaining numbers are in the guess but not in the right spot
        String answerCopyStr = answerCopy.toString(); //To use .contains method from String class
        for (int i = 0; i < breakGuess.length(); i++){
            String checkNum = Character.toString(breakGuess.charAt(i));
            if (answerCopyStr.contains(checkNum)) {
                response = response.concat("+");
                StringBuilder answerCopyTemp = new StringBuilder(answerCopyStr);
                answerCopyTemp.setCharAt(answerCopyStr.indexOf(checkNum), 'n'); //n is place holder
                answerCopyStr = answerCopyTemp.toString();
            }
        }
        // Fill the rest of response with numbers in the code with "+" and/or wrong numbers with "-"
        for (int i = 0; i < answerCopyStr.length(); i++){
            if (answerCopyStr.charAt(i) != 'n') {
                response = response.concat("-");
            }
        }
        return response;
    }
}