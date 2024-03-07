package hw01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CodeBreakerTest {

    private CodeBreaker breaker;

    private GameManager mgr;


    @BeforeEach
    void setUp() {
        breaker = new CodeBreaker();
        mgr = new GameManager();
    }

    @Test
    void makeGuess() {
        // First check that breakerGuess is an empty String
        assertEquals(null, breaker.getBreakerGuess());

        // Make a guess - this code sets the guess made by the user to be "4444"
        String guess = "4444";
        InputStream in = new ByteArrayInputStream(guess.getBytes());
        System.setIn(in);

//        breaker.makeGuess();
//        // Assert that this makes isGoodGuess true
//        assertTrue(breaker.getIsGoodGuess());
//
//        //Assert that guess count has increased to 2
//        assertEquals(2, mgr.getGuessCount());
    }
}