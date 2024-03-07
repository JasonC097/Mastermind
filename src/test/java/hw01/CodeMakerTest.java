package hw01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeMakerTest {

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
    }
}