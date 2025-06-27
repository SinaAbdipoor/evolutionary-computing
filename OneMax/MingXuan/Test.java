package MingXuan;

public class Test {
    public static void main(String[] args) {
        int iter = 10000000;
        int len = 1000000;

//        RandomSearch search = new RandomSearch(iter, len);
//        search.iteration();
//        System.out.println(search);
        HillClimbing climb = new HillClimbing(iter, len);
        climb.iteration();
    }
}