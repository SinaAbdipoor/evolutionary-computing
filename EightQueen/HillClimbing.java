package EightQueen;

import java.util.Random;

class HillClimbing {
    private int currentIteration = 0;
    private final int maxIterations;
    private final EightQueen board;
    private int cost;

    HillClimbing(int maxIterations) {
        if (maxIterations < 1) throw new IllegalArgumentException("Maximum iterations must be above zero.");
        this.maxIterations = maxIterations;
        // Start with a random board
        board = new EightQueen();
        randomizeBoard(board);
        cost = board.calcCost();
    }

    @Override
    public String toString() {
        return "HillClimbing{" + "currentIteration=" + currentIteration + ", maxIterations=" + maxIterations + ", board=\n" + board + ", cost=" + cost + '}';
    }

    private void randomizeBoard(EightQueen Board) {
        Random random = new Random();
        int size = board.getBoardLength();
        for (int col = 0; col < size; col++) {
            Board.placeQueen(col, random.nextInt(size));
        }
    }

    private void hillClimbing() {
        currentIteration++;
        EightQueen newBoard = new EightQueen();
        newBoard.copyFrom(board);
        int size = newBoard.getBoardLength();
        Random random = new Random();
        newBoard.placeQueen(random.nextInt(size), random.nextInt(size));
        int newCost = newBoard.calcCost();
        if (newCost <= cost) {
            cost = newCost;
            board.copyFrom(newBoard);
        }
    }


    int run(boolean debugMode) {
        while (currentIteration < maxIterations) {
            if (cost == 0) // Check if the best solution is found
                return currentIteration;
            hillClimbing(); // Run 1 iteration of random search
            if (debugMode) System.out.println(this);
        }
        return -1; // Best solution not found
    }
}