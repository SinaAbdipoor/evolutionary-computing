// The Trap function is defined as follows:
// 000 4
// 001 1
// 010 1
// 011 2
// 100 1
// 101 2
// 110 2
//
package Trap;

public class Test {
    public static void main(String[] args) {
//        RandomSearch randomSearch5 = new RandomSearch(5, 1000);
//        RandomSearch randomSearch10 = new RandomSearch(10, 1000);
//        RandomSearch randomSearch20 = new RandomSearch(20, 1000);
//        RandomSearch randomSearch50 = new RandomSearch(50, 1000);
//        RandomSearch randomSearch100 = new RandomSearch(100, 1000);
//        RandomSearch randomSearch200 = new RandomSearch(200, 1000);
//        RandomSearch randomSearch500 = new RandomSearch(500, 1000);
//        RandomSearch randomSearch1000 = new RandomSearch(1000, 1000);
//        System.out.println("Random Search (5, 1,000):" + randomSearch5.run(false));
//        System.out.println("Random Search (10, 1,000):" + randomSearch10.run(false));
//        System.out.println("Random Search (20, 1,000):" + randomSearch20.run(false));
//        System.out.println("Random Search (50, 1,000):" + randomSearch50.run(false));
//        System.out.println("Random Search (100, 1,000):" + randomSearch100.run(false));
//        System.out.println("Random Search (200, 1,000):" + randomSearch200.run(false));
//        System.out.println("Random Search (500, 1,000):" + randomSearch500.run(false));
//        System.out.println("Random Search (1,000, 1,000):" + randomSearch1000.run(false));
//
//        System.out.println();

        HillClimbing hillClimbing5 = new HillClimbing(5, 1000);
        HillClimbing hillClimbing10 = new HillClimbing(10, 1000);
        HillClimbing hillClimbing20 = new HillClimbing(20, 1000);
        HillClimbing hillClimbing50 = new HillClimbing(50, 1000);
        HillClimbing hillClimbing100 = new HillClimbing(100, 1000);
        HillClimbing hillClimbing200 = new HillClimbing(200, 1000);
        HillClimbing hillClimbing500 = new HillClimbing(500, 1000);
        HillClimbing hillClimbing1000 = new HillClimbing(1000, 1000);
        System.out.println("Hill Climbing (5, 1,000):" + hillClimbing5.run(false));
        System.out.println("Hill Climbing (10, 1,000):" + hillClimbing10.run(false));
        System.out.println("Hill Climbing (20, 1,000):" + hillClimbing20.run(false));
        System.out.println("Hill Climbing (50, 1,000):" + hillClimbing50.run(false));
        System.out.println("Hill Climbing (100, 1,000):" + hillClimbing100.run(false));
        System.out.println("Hill Climbing (200, 1,000):" + hillClimbing200.run(false));
        System.out.println("Hill Climbing (500, 1,000):" + hillClimbing500.run(false));
        System.out.println("Hill Climbing (1,000, 1,000):" + hillClimbing1000.run(false));
    }
}