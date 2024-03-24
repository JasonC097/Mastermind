package hw01;

import hw01.solver.NewSolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewSolverTest {

    private static NewSolver n;

    @BeforeEach
    void setUp() {
        n = new NewSolver();
    }

    @Test
    void resetGameStats() {
        //Check that game stats are properly set
        n.resetGameStats();
        assertEquals(1, n.getNewSolGuessCount());
    }

    @Test
    void guessAndCheck() {
    }
}