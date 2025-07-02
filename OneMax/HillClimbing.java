package OneMax;

import java.util.Arrays;
import java.util.Random;

class HillClimbing {
    private final int maxIterations;
    private int currentIteration;
    private boolean[] bestSolution;
    private int bestFitness;
    private final Random random = new Random();

    public HillClimbing(int problemSize, int maxIterations) {
        if (problemSize < 1) throw new IllegalArgumentException("Problem size (n) must be above zero.");
        bestSolution = new boolean[problemSize];

        if (maxIterations < 1) throw new IllegalArgumentException("Maximum iterations must be above zero.");
        this.maxIterations = maxIterations;
    }

    @Override
    public String toString() {
        return "HillClimbing{" + "Iteration=" + currentIteration + "/" + maxIterations + ", bestFitness=" + bestFitness + "/" + bestSolution.length + '}';
    }

    private int calculateFitness(boolean[] solution) {
        int count = 0;
        for (boolean b : solution)
            if (b) count++;
        return count;
    }

    int run(boolean debugMode) {
        // Step 1: Start from a random point
        for (int i = 0; i < bestSolution.length; i++)
            bestSolution[i] = random.nextBoolean();
        bestFitness = calculateFitness(bestSolution);
        // Step 2: Start climbing
        while (currentIteration < maxIterations) {
            if (bestFitness == bestSolution.length) // Check if the best solution is found
                return currentIteration;
            hillClimbing(); // Run 1 iteration of hill climbing
            if (debugMode) System.out.println(this);
        }
        return -1; // Best solution not found
    }

    private void hillClimbing() {
        boolean[] newSolution = Arrays.copyOf(bestSolution, bestSolution.length);
        // Step 1: Increase the iteration count
        currentIteration++;
        // Step 2: Make a jump and calculate fitness
        int randomIndex = random.nextInt(newSolution.length);
        newSolution[randomIndex] = !newSolution[randomIndex];
        int newFitness = calculateFitness(newSolution);
        // Step 3: If the newSolution is better, replace the BestSolution
        if (newFitness > bestFitness) {
            bestFitness = newFitness;
            bestSolution = Arrays.copyOf(newSolution, newSolution.length);
        }
    }
}