package Trap;

import java.util.Arrays;
import java.util.Random;

class RandomSearch {
    private final int maxIterations;
    private int currentIteration;
    private boolean[] bestSolution;
    private int bestFitness;
    private final Random random = new Random();

    public RandomSearch(int problemSize, int maxIterations) {
        if (problemSize < 1) throw new IllegalArgumentException("Problem size (n) must be above zero.");
        bestSolution = new boolean[problemSize];

        if (maxIterations < 1) throw new IllegalArgumentException("Maximum iterations must be above zero.");
        this.maxIterations = maxIterations;
    }

    @Override
    public String toString() {
        return "RandomSearch{" + "Iteration=" + currentIteration + "/" + maxIterations + ", bestFitness=" + bestFitness + "/" + bestSolution.length + '}';
    }

    private int calculateFitness(boolean[] solution) {
        int count = 0;
        for (boolean b : solution)
            if (b) count++;
        if (count == 0)
            return solution.length+1;
        return count;
    }

    int run(boolean debugMode) {
        while (currentIteration < maxIterations) {
            if (bestFitness == bestSolution.length) // Check if the best solution is found
                return currentIteration;
            randomSearch(); // Run 1 iteration of random search
            if (debugMode) System.out.println(this);
        }
        return -1; // Best solution not found
    }

    private void randomSearch() {
        boolean[] newSolution = new boolean[bestSolution.length];
        // Step 1: Increase the iteration count
        currentIteration++;
        // Step 2: Generate a random solution and calculate fitness
        for (int i = 0; i < newSolution.length; i++)
            newSolution[i] = random.nextBoolean();
        int newFitness = calculateFitness(newSolution);
        // Step 3: If the newSolution is better, replace the BestSolution
        if (newFitness > bestFitness) {
            bestFitness = newFitness;
            bestSolution = Arrays.copyOf(newSolution, newSolution.length);
        }
    }
}