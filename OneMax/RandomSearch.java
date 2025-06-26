import java.util.Arrays;
import java.util.Random;

class RandomSearch {
    private final int maxIterations;
    private int currentIteration;
    private boolean[] bestSolution;
    private int bestFitness;
    private final Random random = new Random();

    public RandomSearch(int problemSize, int maxIterations) {
        if (problemSize < 1) {
            throw new IllegalArgumentException("Problem size (n) must be above zero.");
        }
        bestSolution = new boolean[problemSize];

        if (maxIterations < 1) {
            throw new IllegalArgumentException("Maximum iterations must be above zero.");
        }
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
        return count;
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
            System.out.println("New best solution found=" + Arrays.toString(newSolution));
            bestFitness = newFitness;
            bestSolution = Arrays.copyOf(newSolution, newSolution.length);
        }
    }

    int run() {
        while (currentIteration < maxIterations) {
            if (bestFitness == bestSolution.length) { // Check if the best solution is found
                System.out.println("Best solution Found!");
                return currentIteration;
            }
            randomSearch(); // Run 1 iteration of random search
            System.out.println(this);
        }
        return -1; // Best solution not found
    }
}