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
     * Goes through a user's guess and compares it to the answer
     *
     * @param breakGuess - a String of numbers that the user guesses is the answer
     * @return - a String that shows how many numbers in the user's guess that are
     * in the right spot, contained in the answer, or not part of the answer
     */
    public String checkGuess(String breakGuess){
        String response = "";
        String answerCopy = this.codeAnswer;
        // Finds numbers in right spot first and exclude them in the copy of the answer
        for (int i = 0; i < breakGuess.length(); i++) {
            char checkNum = breakGuess.charAt(i);
            if (checkNum == this.codeAnswer.charAt(i)) {
                response = response.concat("*");
                answerCopy = rewriteAnswerCopy(answerCopy.indexOf(checkNum), answerCopy);
            }
        }
        // Checks to see if remaining numbers are in the guess but not in the right spot
        for (int i = 0; i < breakGuess.length(); i++){
            String checkNum = Character.toString(breakGuess.charAt(i));
            if (answerCopy.contains(checkNum)) {
                response = response.concat("+");
                answerCopy = rewriteAnswerCopy(answerCopy.indexOf(checkNum), answerCopy);
            }
        }
        // Fill the rest of response with numbers in the code with "+" and/or wrong numbers with "-"
        for (int i = 0; i < answerCopy.length(); i++){
            response = response.concat("-");
        }
        return response;
    }

    /**
     * Helper method to rewrite answer to follow along what was checked already
     *
     * @param locationOfNum - index of the number in the answer code
     * @param answerCopy1 - the rewritten answer copy that updates what has been checked
     * @return - new updated copy of the answerCopy to help follow along what was checked
     */
    private static String rewriteAnswerCopy(int locationOfNum, String answerCopy1) {

        if (locationOfNum + 1 < answerCopy1.length()) {
            answerCopy1 = answerCopy1.substring(0, locationOfNum) + answerCopy1.substring(locationOfNum + 1);
        } else {
            answerCopy1 = answerCopy1.substring(0, locationOfNum);
        }
        return answerCopy1;
    }
}