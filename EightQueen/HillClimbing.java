package EightQueen;

import java.util.Random;

public class HillClimbing {
    private final int size;
    private int currentIteration = 0;
    private final int maxIteration;
    private int fitness = 100000;
    private int[] bestBoard;
    private int[] board;
    private int cost = 100000;
    private Random random = new Random();
    private int index;

    HillClimbing(int size, int maxIteration) {
        this.size = size;
        bestBoard = new int[size];
        board = new int[size];
        this.maxIteration = maxIteration;
    }

    void createBoard() {
        for (int col=0; col<size;col++) {
            board[col] = random.nextInt(size);//[0,size)
        }
        EightQueen randomQueen = new EightQueen(board);
        cost = randomQueen.calcCost();
    }

    private void hillClimbing() {
        index = random.nextInt(size);// Choose a column
        int tempB, tempC;
        tempB = board[index];
        tempC = cost;
        board[index] = random.nextInt(size);//Choose a row
        EightQueen randomQueen = new EightQueen(board);
        cost = randomQueen.calcCost();
        if (cost >= tempC) {
            cost = tempC;
            board[index] = tempB;
        }
    }

    int run(boolean deBugMode) {
        createBoard();
        while (currentIteration < maxIteration) {
            if (fitness > cost) {
                fitness = cost;
                bestBoard = board.clone();
            }
            hillClimbing();
            currentIteration++;
        }
        if (deBugMode) System.out.println(this);
        return fitness;
    }

    @Override
    public String toString() {
        for (int i = 0;i < size;i++) {
            for (int j = 0;j < size;j++) {
                if (bestBoard[j] == i) System.out.print(" Q ");
                else System.out.print(" . ");
            }
            System.out.println();
        }
        return "Fitness: " + fitness;
    }
}
