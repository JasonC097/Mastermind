package hw01;

import hw01.game.GameManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {

    private GameManager gameMgr;

    @BeforeEach
    void setUp(){
        gameMgr = new GameManager();
    }

    @Test
    void generateSolution() {
        //Assert that the solution is currently an empty String
        assertEquals("", gameMgr.getGameSolution());

        //Generate a solution and check that it matches the parameters
        //Must be length 4 and only contain digits 1 through 6
        String solution = gameMgr.generateSolution();
        Pattern solutionPattern = Pattern.compile("[1-6]{4}");
        Matcher solutionMatcher = solutionPattern.matcher(solution);
        assertTrue(solutionMatcher.matches());
    }

    @Test
    void increaseGuessCount() {
        // Check that at beginning, guess count is 1
        assertEquals(1, gameMgr.getGuessCount());

        // increase guesses twice, check that it equals 3
        gameMgr.increaseGuessCount();
        gameMgr.increaseGuessCount();
        assertEquals(3, gameMgr.getGuessCount());
    }
}