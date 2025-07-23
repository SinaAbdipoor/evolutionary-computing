package EightQueen;

import java.util.Random;

class HillClimbing {
    private int currentIteration = 0;
    private final int maxIterations;
    private EightQueen board;
    private EightQueen newBoard;
    private EightQueen currentBoard;
    private int cost;
    private Random random = new Random();

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
        int size = board.getBoardLength();
        for (int col = 0; col < size; col++) {
            Board.placeQueen(col, random.nextInt(size));
        }
    }

    private void climbTo(EightQueen Board) {
        int size = Board.getBoardLength();
        int newColumn = random.nextInt(size);
        Board.placeQueen(newColumn, random.nextInt(size));
    }

    private void hillClimbing() {
        currentIteration++;
        currentBoard = newBoard;
        climbTo(newBoard);
        int newCost = newBoard.calcCost();
        if (newCost < cost) {
            cost = newCost;
            board.copyFrom(newBoard);
        }
        else {
            newBoard = currentBoard;
        }
    }


    int run(boolean debugMode) {
        newBoard = new EightQueen();
        randomizeBoard(newBoard);
        while (currentIteration < maxIterations) {
            if (cost == 0) // Check if the best solution is found
                return currentIteration;
            hillClimbing(); // Run 1 iteration of random search
            if (debugMode) System.out.println(this);
        }
        return -1; // Best solution not found
    }
}