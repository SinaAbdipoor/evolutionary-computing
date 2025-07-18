package EightQueen;

public class Test {
    public static void main(String[] args){
        int cost;
        RandomSearch randomSearch500 = new RandomSearch(8, 500);
        RandomSearch randomSearch1000 = new RandomSearch(8, 1000);
        RandomSearch randomSearch10000 = new RandomSearch(8, 10000);
        RandomSearch randomSearch100000 = new RandomSearch(8, 100000);
        System.out.println("Random Search(500):" + randomSearch500.run(false));
        System.out.println("Random Search(1000):" + randomSearch1000.run(false));
        System.out.println("Random Search(10000):" + randomSearch10000.run(false));
        System.out.println("Random Search(100000):" + randomSearch100000.run(false));

        HillClimbing hillClimbing500 = new HillClimbing(8, 500);
        HillClimbing hillClimbing1000 = new HillClimbing(8, 1000);
        HillClimbing hillClimbing10000 = new HillClimbing(8, 10000);
        System.out.println("Hill Climbing(500):" + hillClimbing500.run(false));
        System.out.println("Hill Climbing(1000):" + hillClimbing1000.run(false));
        System.out.println("Hill Climbing(10000):" + hillClimbing10000.run(true));
    }
}
