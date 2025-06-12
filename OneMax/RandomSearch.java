import java.util.Arrays;
import java.util.Random;

class RandomSearch {
    private final int problemSize; //The size of the problem, which is the length of the boolean array.
    private final int maxIterations; //The maximum allowed number of iterations, which, in this case, is actually the same as the Number of Fitness Evaluations (NFE).

    private int currentIteration;
    private final boolean[] currentSolution;
    private boolean[] bestSolution;
    private int bestFitness;

    private final Random random = new Random();

    public RandomSearch(int problemSize, int maxIterations) {
        if (problemSize < 1) {
            throw new IllegalArgumentException("Problem size n must be above zero.");
        }
        this.problemSize = problemSize;

        if (maxIterations < 1) {
            throw new IllegalArgumentException("Maximum iterations must be above zero.");
        }
        this.maxIterations = maxIterations;

        currentSolution = new boolean[problemSize];
        bestSolution = new boolean[problemSize];
    }

    @Override
    public String toString() {
        return "RandomSearch{" + "currentIteration=" + currentIteration + "/" + maxIterations + ", bestFitness=" + bestFitness + "/" + problemSize + '}';
    }

    void run() {
        for (currentIteration = 0; currentIteration < maxIterations; currentIteration++) {
            if (bestFitness == problemSize){
                System.out.println("BEST SOLUTION FOUND!");
                break;
            }
            randomizeCurrentSolution();
            int sum = calcCurrentFitness();
            if (sum > bestFitness) {
                bestSolution = Arrays.copyOf(currentSolution, currentSolution.length);
                bestFitness = sum;
            }
            System.out.println(this);
        }
        System.out.println("RandomSearch{" + "bestSolution=" + Arrays.toString(bestSolution) + "}");
    }

    private void randomizeCurrentSolution() {
        for (int i = 0; i < currentSolution.length; i++) {
            currentSolution[i] = random.nextBoolean();
        }
    }

    private int calcCurrentFitness() {
        int sum = 0;
        for (int i = 0; i < currentSolution.length; i++)
            if (currentSolution[i]) sum++;
        return sum;
    }
}