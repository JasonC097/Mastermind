package hw01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomSolverTest {

    private static RandomSolver r;

    private static CodeMaker cm;

    @BeforeEach
    void setUp() {
        r = new RandomSolver();
        cm = new CodeMaker("4444");
    }

    @Test
    void play() {
    }

    @Test
    void testReset(){
        // reset game stats and make sure that guessCount is set to 0
        r.resetGameStats();
        assertEquals(false, r.isCorrect());
        assertEquals(0, r.getRandGuessCount());

    }

    @Test
    void testGenRandomGuess(){
        //Check that guess is initially an empty string
        assertEquals("", r.getGuess());

        //Generate a guess and check that is it of length 4, <= 6666
        r.genRandomGuess();
        assertEquals(4,r.getGuess().length());
        assertTrue(Integer.parseInt(r.getGuess())<=6666);
        assertEquals(1, r.getRandGuessCount());
    }
}