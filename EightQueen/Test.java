package EightQueen;

public class Test {
    public static void main(String[] args) {
        System.out.println("Random Search(5):" + new RandomSearch(5).run(false));
        System.out.println("Random Search(10):" + new RandomSearch(10).run(false));
        System.out.println("Random Search(20):" + new RandomSearch(20).run(false));
        System.out.println("Random Search(50):" + new RandomSearch(50).run(false));
        System.out.println("Random Search(100):" + new RandomSearch(100).run(false));
        System.out.println("Random Search(200):" + new RandomSearch(200).run(false));
        System.out.println("Random Search(500):" + new RandomSearch(500).run(false));
        System.out.println("Random Search(1,000):" + new RandomSearch(1000).run(false));
        System.out.println("Random Search(2,000):" + new RandomSearch(2000).run(false));
        System.out.println("Random Search(5,000):" + new RandomSearch(5000).run(false));
        System.out.println("Random Search(10,000):" + new RandomSearch(10000).run(false));
        System.out.println("Random Search(100,000):" + new RandomSearch(100000).run(false));


        System.out.println("Hill Climbing(5):" + new HillClimbing(5).run(false));
        System.out.println("Hill Climbing(10):" + new HillClimbing(10).run(false));
        System.out.println("Hill Climbing(20):" + new HillClimbing(20).run(false));
        System.out.println("Hill Climbing(50):" + new HillClimbing(50).run(false));
        System.out.println("Hill Climbing(50):" + new HillClimbing(50).run(false));
        System.out.println("Hill Climbing(100):" + new HillClimbing(100).run(false));
        System.out.println("Hill Climbing(200):" + new HillClimbing(200).run(false));
        System.out.println("Hill Climbing(500):" + new HillClimbing(500).run(false));
        System.out.println("Hill Climbing(1,000):" + new HillClimbing(1000).run(false));
        System.out.println("Hill Climbing(2,000):" + new HillClimbing(2000).run(false));
        System.out.println("Hill Climbing(5,000):" + new HillClimbing(5000).run(false));
        System.out.println("Hill Climbing(10,000):" + new HillClimbing(10000).run(false));
        System.out.println("Hill Climbing(100,000):" + new HillClimbing(100000).run(false));
    }
}