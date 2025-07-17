package EightQueen;

import java.util.Random;
class RandomSearch {
    private final int size;
    private int currentIteration = 0;
    private final int maxIteration;
    private int fitness = 100000;
    private int[] bestBoard;
    private int[] board;
    private int cost = 100000;
    private Random random = new Random();
    RandomSearch(int size, int maxIteration) {
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
//        return board;
//        return cost;
    }

    int run(boolean deBugMode) {
        while (currentIteration < maxIteration) {
            if (fitness > cost) {
                fitness = cost;
                bestBoard = board.clone();
//                if (deBugMode) System.out.println(this);
            }
            createBoard();
//            System.out.println(fitness);
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
