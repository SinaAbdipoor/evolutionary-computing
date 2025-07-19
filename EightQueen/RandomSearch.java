package EightQueen;

import java.util.Random;

class RandomSearch {
    private int currentIteration = 0;
    private final int maxIterations;
    private EightQueen board;
    private int cost;

    RandomSearch(int maxIterations) {
        if (maxIterations < 1) throw new IllegalArgumentException("Maximum iterations must be above zero.");
        this.maxIterations = maxIterations;
        // Start with a random board
        board = new EightQueen();
        randomizeBoard(board);
        cost = board.calcCost();
    }

    @Override
    public String toString() {
        return "RandomSearch{" + "currentIteration=" + currentIteration + ", maxIterations=" + maxIterations + ", board=\n" + board + ", cost=" + cost + '}';
    }

    private void randomizeBoard(EightQueen board) {
        Random random = new Random();
        int size = board.getBoardLength();
        for (int col = 0; col < size; col++) {
            board.placeQueen(col, random.nextInt(size));
        }
    }

    private void randomSearch() {
        currentIteration++;
        EightQueen newBoard = new EightQueen();
        randomizeBoard(newBoard);
        int newCost = newBoard.calcCost();
        if (newCost < cost) {
            cost = newCost;
            board.copyFrom(newBoard);
        }
    }


    int run(boolean debugMode) {
        while (currentIteration < maxIterations) {
            if (cost == 0) // Check if the best solution is found
                return currentIteration;
            randomSearch(); // Run 1 iteration of random search
            if (debugMode) System.out.println(this);
        }
        return -1; // Best solution not found
    }
}