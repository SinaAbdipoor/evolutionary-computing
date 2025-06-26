public class Test {
    public static void main(String[] args) {
        RandomSearch randomSearch5 = new RandomSearch(5, 1000000);
        RandomSearch randomSearch10 = new RandomSearch(10, 1000000);
        RandomSearch randomSearch20 = new RandomSearch(20, 1000000);
        RandomSearch randomSearch50 = new RandomSearch(50, 1000000);
//        System.out.println(randomSearch5.run(false));
//        System.out.println(randomSearch10.run(false));
//        System.out.println(randomSearch20.run(false));
//        System.out.println(randomSearch50.run(false));

        HillClimbing hillClimbing5 = new HillClimbing(5, 1000000);
        HillClimbing hillClimbing10 = new HillClimbing(10, 1000000);
        HillClimbing hillClimbing20 = new HillClimbing(20, 1000000);
        HillClimbing hillClimbing50 = new HillClimbing(50, 1000000);
        HillClimbing hillClimbing100 = new HillClimbing(100, 1000000);
        HillClimbing hillClimbing200 = new HillClimbing(200, 1000000);
        HillClimbing hillClimbing500 = new HillClimbing(500, 1000000);
        HillClimbing hillClimbing1000 = new HillClimbing(1000, 1000000);
        HillClimbing hillClimbing2000 = new HillClimbing(2000, 1000000);
        HillClimbing hillClimbing5000 = new HillClimbing(5000, 1000000);
        HillClimbing hillClimbing10000 = new HillClimbing(10000, 1000000);
//        System.out.println(hillClimbing5.run(false));
//        System.out.println(hillClimbing10.run(false));
//        System.out.println(hillClimbing20.run(false));
//        System.out.println(hillClimbing50.run(false));
//        System.out.println(hillClimbing100.run(false));
//        System.out.println(hillClimbing200.run(false));
//        System.out.println(hillClimbing500.run(false));
//        System.out.println(hillClimbing1000.run(false));
//        System.out.println(hillClimbing2000.run(false));
//        System.out.println(hillClimbing5000.run(false));
        System.out.println(hillClimbing10000.run(false));
    }
}