package MingXuan;

public class HillClimbing {
    private final int iter;
    private final int len;
//    private int term;
    public HillClimbing(int iter, int len) {
        this.iter = iter;
        this.len = len;
    }

    public String toBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public void iteration() {
        int origin = (int)(Math.random() * len) + 1;
        String goal = toBinary(origin);
        int sum = 0;
        int BinaryLength = goal.length();
//        System.out.println(goal);
//        System.out.println(BinaryLength);
        Boolean[] start = new Boolean[BinaryLength];
        for (int i=0;i<BinaryLength;i++) {
            if (String.valueOf(goal.charAt(i)).equals("1")) {
                start[i] = true;
                sum++;
            }
            else
                start[i] = false;
        }

        for (int j = 0;j < iter;j++) {
            int index = (int)(Math.random() * BinaryLength);
            if (!start[index]) {
                start[index] = !start[index];
                System.out.println("Iteration #" + j + " - CurrentSolution = 001 _ CurrentFitness = " + sum + "\n" +
                        "- NewSolution = 011 _ NewFitness = " + (sum+1) +" _ Replaced = True");
                sum ++;
            }
            //print...
        }
    }

    public String toString() {
        return "Iteration #" + term + " - CurrentSolution = 001 _ CurrentFitness = 1\n" +
                "- NewSolution = 011 _ NewFitness = 2 _ Replaced = True";
    }
}
