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
    }
}