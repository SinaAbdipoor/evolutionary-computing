package EightQueen;

import java.util.Random;

class HillClimbing {
    private int currentIteration = 0;
    private final int maxIterations;
    private EightQueen board;
    private int cost;

    HillClimbing(int maxIterations) {
        if (maxIterations < 1) throw new IllegalArgumentException("Maximum iterations must be above zero.");
        this.maxIterations = maxIterations;
        // Start with a random board
    }
}