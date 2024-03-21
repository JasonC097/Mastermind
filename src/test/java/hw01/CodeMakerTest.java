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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeMakerTest {
    /** CodeMaker initializer*/
    private CodeMaker codeMaker;


    @BeforeEach
    void setUp() {
        // Test answer being used
        this.codeMaker = new CodeMaker("4613");
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Tries random user tests and compares the result of checkGuess with
     * expected results
     */
    @Test
    void checkGuess() {
        String userGuess = "1331";
        String expectedResponse = "++--";
        String response = codeMaker.checkGuess(userGuess);
        assertEquals(expectedResponse, response);

        userGuess = "4231";
        expectedResponse = "*++-";
        response = codeMaker.checkGuess(userGuess);
        assertEquals(expectedResponse, response);

        userGuess = "1643";
        expectedResponse = "**++";
        response = codeMaker.checkGuess(userGuess);
        assertEquals(expectedResponse, response);

        userGuess = "4613";
        expectedResponse = "****";
        response = codeMaker.checkGuess(userGuess);
        assertEquals(expectedResponse, response);

        userGuess = "5555";
        expectedResponse = "----";
        response = codeMaker.checkGuess(userGuess);
        assertEquals(expectedResponse, response);

        userGuess = "3164";
        expectedResponse = "++++";
        response = codeMaker.checkGuess(userGuess);
        assertEquals(expectedResponse, response);

        CodeMaker test = new CodeMaker("2421");
        assertEquals("*+++", test.checkGuess("1224"));
    }
}