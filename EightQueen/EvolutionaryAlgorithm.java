package EightQueen;

import java.util.ArrayList;
import java.util.Random;

class EvolutionaryAlgorithm {
    private int currentIteration = 0;
    private final int maxIterations;
    private ArrayList<EightQueen> eightQueens = new ArrayList<>();
    private EightQueen solution;
    private int fitness = -1;

    private final int population = 100;
    private final double mutationRate = 0.8;
    private final double recombinationRate = 1.0;
    private final int boardLength = 8;
    private final int parentsNumber = 5;
    private final Random random = new Random();

    EvolutionaryAlgorithm(int maxIterations) {
        if (maxIterations < 1) throw new IllegalArgumentException("Maximum iterations must be above zero.");
        this.maxIterations = maxIterations;
        Initialize();
    }

    private void Initialize() {
        for (int individual = 0; individual <population; individual++) {
            EightQueen aBoard = new EightQueen();
            int size = aBoard.getBoardLength();

            for (int col=0; col<size; col++)
                aBoard.placeQueen(col, random.nextInt(size));

            int penalty = aBoard.calcCost();
            if (fitness == -1 || penalty<fitness) {
                fitness = penalty;
                solution = aBoard;
            }

            eightQueens.add(aBoard);
        }
    }

    @Override
    public String toString() {
        return "HillClimbing{" + "currentIteration=" + currentIteration + ", maxIterations=" + maxIterations + ", board=\n" + solution + ", fitness=" + fitness + '}';
    }

    private void mutation(EightQueen board) {
        int size = board.getBoardLength();
        int positionA = random.nextInt(size);
        int positionB = random.nextInt(size);

        int temp;
        int[] theBoard = board.getBoard().clone();
        temp = theBoard[positionA];
        theBoard[positionA] = theBoard[positionB];
        theBoard[positionB] = temp;
        board.setBoard(theBoard);
    }

    private ArrayList<EightQueen> recombination() {
        ArrayList<EightQueen> preParentList = new ArrayList<>();
        ArrayList<EightQueen> childList = new ArrayList<>();
        EightQueen parentA = new EightQueen();
        EightQueen parentB = new EightQueen();

        EightQueen childA = new EightQueen();
        EightQueen childB = new EightQueen();

         for (int i=0; i<parentsNumber; i++) {
            EightQueen tempParent = eightQueens.get(random.nextInt(population));
            preParentList.add(tempParent);
        }

        int parentAPenalty = Integer.MAX_VALUE;
        int parentBPenalty = Integer.MAX_VALUE;

        for (int i = 0; i < parentsNumber; i++) {
            int currentPenalty = preParentList.get(i).calcCost();

            if (currentPenalty < parentAPenalty) {
                parentBPenalty = parentAPenalty;
                parentB = parentA;

                parentAPenalty = currentPenalty;
                parentA = preParentList.get(i);
            } else if (currentPenalty < parentBPenalty) {
                parentBPenalty = currentPenalty;
                parentB = preParentList.get(i);
            }
        }

        int[] listA = parentA.getBoard().clone();
        int[] listB = parentB.getBoard().clone();
        int[] temp = new int[boardLength];
        for (int i=boardLength/2; i<boardLength; i++) {
            temp[i] = listB[i];
            listB[i] = listA[i];
            listA[i] = temp[i];
        }

        childA.setBoard(listA);
        childB.setBoard(listB);

        childList.add(childA);
        childList.add(childB);

        return childList;
    }

    private void evolutionaryAlgorithm() {
        currentIteration++;
        ArrayList<EightQueen> childList = new ArrayList<>();
        childList = recombination();
        EightQueen childA = new EightQueen();
        EightQueen childB = new EightQueen();

        int maxFirst = -1;
        int maxSecond = -1;

        childA = childList.get(0);
        childB = childList.get(1);

        int mutationNumA = random.nextInt(10);
        int mutationNumB = random.nextInt(10);

        if (mutationNumA < 8) {
            mutation(childA);
        }
        if (mutationNumB < 8) {
            mutation(childB);
        }

        int populationPenaltyFirst = -1;
        int populationPenaltySecond = -1;
        for (int i=0; i<population; i++) {
            int currentPenalty;
            currentPenalty = eightQueens.get(i).calcCost();
            if (currentPenalty>populationPenaltyFirst) {
                populationPenaltySecond = populationPenaltyFirst;
                maxSecond = maxFirst;

                populationPenaltyFirst = currentPenalty;
                maxFirst = i;
            }
            else if (currentPenalty>populationPenaltySecond) {
                populationPenaltySecond = currentPenalty;
                maxSecond = i;
            }
        }
        eightQueens.get(maxFirst).setBoard(childA.getBoard().clone());
        eightQueens.get(maxSecond).setBoard(childB.getBoard().clone());
        for (int i=0; i<population; i++) {
            int currentPenalty = eightQueens.get(i).calcCost();
            if (fitness>currentPenalty) {
                fitness=currentPenalty;
                solution = eightQueens.get(i);
            }
        }
    }

    int run(boolean debugMode) {
        while (currentIteration < maxIterations) {
            if (fitness == 0) // Check if the best solution is found
                return currentIteration;
            evolutionaryAlgorithm(); // Run 1 iteration of random search
            if (debugMode) System.out.println(this);
        }
        return -1; // Best solution not found
    }
}
