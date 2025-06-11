package MingXuan;

public class Test {
    public static void main(String[] args) {
        int iter = 1000000;
        int len = 100;

        RandomSearch search = new RandomSearch(iter, len);
        search.iteration();
        System.out.println(search);
    }
}