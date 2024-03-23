package hw01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiniMaxSolverTest {
    private MiniMaxSolver game;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void play() {
        // Play 100 games and sees if number of guesses are at most 5
        for (int i = 0; i < 100; i++){
            this.game = new MiniMaxSolver(); //Create new unique game
            this.game.play();
            int numGuesses = game.getNumGuesses();
            assertTrue(numGuesses <= 5);
        }
    }
}