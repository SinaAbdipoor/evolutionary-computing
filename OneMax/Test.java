public class Test {
    public static void main(String[] args) {
        RandomSearch randomSearch5 = new RandomSearch(5, 1000000);
        RandomSearch randomSearch10 = new RandomSearch(10, 1000000);
        RandomSearch randomSearch20 = new RandomSearch(20, 1000000);
        RandomSearch randomSearch50 = new RandomSearch(50, 1000000);

//        System.out.println(randomSearch5.run());
//        System.out.println(randomSearch10.run());
        System.out.println(randomSearch20.run());
//        System.out.println(randomSearch50.run());
    }
}