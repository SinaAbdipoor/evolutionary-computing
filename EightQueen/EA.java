package EightQueen;

import java.util.Random;

class EA {
    private final EightQueen[] population;
    private final int populationSize = 100;
    private final int maxIterations;
    private int currentIteration;
    private final double mutationRate = 0.8;
    private final double recombinationRate = 1.0;
    private final Random random = new Random();
    private EightQueen solution;
    private int bestCost;

    EA(int maxIterations) {
        if (maxIterations < 1) throw new IllegalArgumentException("Maximum iterations must be above zero.");
        this.maxIterations = maxIterations;
        this.population = new EightQueen[populationSize];
        initializePopulation();
    }

    @Override
    public String toString() {
        return "EA{" +
                "Iterations=" + currentIteration + "/" + maxIterations +
                ", Solution=" + solution +
                ", BestCost=" + bestCost +
                ", AverageCost=" + calculateAverageCost() +
                '}';
    }

    private double calculateAverageCost() {
        int totalCost = 0;
        for (EightQueen individual : population) {
            totalCost += individual.calcCost();
        }
        return (double) totalCost / populationSize;
    }

    private void initializePopulation() {}

    private EightQueen[] selectParents() {}

    private EightQueen[] recombine(EightQueen parent1, EightQueen parent2) {}

    private void mutate(EightQueen child) {}

    private void survivorSelection(EightQueen[] offsprings) {}

    void run() {
        while (currentIteration < maxIterations && bestCost > 0) {
        }
    }
}