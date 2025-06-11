class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
//        RandomSearch randomSearch = new RandomSearch(5, 10);
//        RandomSearch randomSearch = new RandomSearch(5, 100);
//        RandomSearch randomSearch = new RandomSearch(50, 10000);
//        RandomSearch randomSearch = new RandomSearch(50, 100000);
        RandomSearch randomSearch = new RandomSearch(50, 1000000);
//        RandomSearch randomSearch = new RandomSearch(100, 1000000);
//        RandomSearch randomSearch = new RandomSearch(100, 10000000);
        randomSearch.run();
    }
}