# evolutionary-computing
This repository is to help my students practice and learn Evolutionary Algorithms (EAs).

---

## Problems

### 1. OneMax Problem

The **OneMax** problem is a classic benchmark problem in evolutionary computation. The objective is simple:

> **Maximize the number of 1s in a binary string.**

For example, given a binary string of length `n`, such as `10110010`, the goal is to evolve it into the optimal solution `11111111`.

#### Problem Definition

- **Input**: A binary string of length `n`.
- **Fitness Function**: The number of 1s in the string.
  \[
  f(x) = \sum_{i=1}^{n} x_i \quad \text{where } x_i \in \{0, 1\}
  \]
- **Goal**: Maximize the fitness function.

Although simple, the OneMax problem is ideal for testing basic search and optimization algorithms because:
- It has a clear and known global optimum.
- Each bit contributes independently to the total fitness.
- It can demonstrate the behavior of different algorithms (e.g., exploitation vs exploration).

---

## Algorithms

### 1. Random Search

**Random Search** is a naive optimization method that serves as a baseline. It works by generating random candidate solutions and evaluating them, without using any information from previous attempts.

#### Algorithm Steps:
1. Repeat for a fixed number of iterations or until the optimal solution is found:
    - Generate a random binary string of length `n`.
    - Evaluate its fitness using the OneMax function.
    - Keep track of the best solution found so far.

#### Characteristics:
- No learning or memory.
- Completely uninformed by previous evaluations.
- Useful as a benchmark to measure the performance of more advanced algorithms.

---

### 2. Hill Climbing

**Hill Climbing** is a local search algorithm that iteratively improves the current solution by exploring its neighbors.

#### Algorithm Steps:
1. Start with a random binary string of length `n`.
2. Repeat until a termination condition is met:
    - Generate a neighboring solution (e.g., by flipping one bit).
    - Evaluate its fitness.
    - If the neighbor is better than or equal to the current solution, move to it.
3. Return the best solution found.

#### Characteristics:
- Greedy: Always moves to better or equal solutions.
- Can get stuck in local optima.
- More efficient than Random Search for problems with smooth or well-behaved fitness landscapes.

#### Neighborhood Definition:
- A common neighborhood for OneMax consists of all binary strings that differ by exactly one bit flip from the current string.

---