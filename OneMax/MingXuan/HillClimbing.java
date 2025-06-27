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
    public void printString(Boolean[] arr) {
        for (int i=0;i < arr.length;i++) {
            if (arr[i])
                System.out.print(1);
            else
                System.out.print(0);
        }
    }

    public void iteration() {
        int origin = (int)(Math.random() * len) + 1;
        String goal = toBinary(origin);
        String plan = toBinary(len);
        int sum = 0;
        int planLength = plan.length();
        int BinaryLength = goal.length();
//        System.out.println(goal);
//        System.out.println(BinaryLength);
//        System.out.println(planLength);
        Boolean[] start = new Boolean[planLength];
        for (int i=0;i < planLength;i++) {
            if (i < planLength - BinaryLength)
                start[i] = false;
            else if (String.valueOf(goal.charAt(i - (planLength - BinaryLength))).equals("1")) {
                start[i] = true;
                sum++;
            }
            else
                start[i] = false;
        }
        int L_index = 0;
        for (int j = 0;j < iter;j++) {
            if (sum == planLength)
                break;
            int index = (int)(Math.random() * planLength);
            if (j == 0)
                L_index = index;
            System.out.print("Iteration #" + j + " - CurrentSolution = ");
            printString(start);
            if (!start[index]) {
                start[index] = !start[index];
                System.out.print("_ CurrentFitness = " + sum + "\n" +
                        "- NewSolution = ");
                printString(start);
                System.out.println(" _ NewFitness = " + (sum+1) +" _ Replaced = True");
                sum ++;
            }
//            else if (L_index == index) {
//                System.out.print("_ CurrentFitness = " + sum + "\n" +
//                        "- NewSolution = ");
//                printString(start);
//                System.out.println(" _ NewFitness = " + sum +" _ Replaced = false");
//            }
            else {
                System.out.print(" _ CurrentFitness = " + sum + "\n" +
                        "- NewSolution = ");
                printString(start);
                System.out.println(" _ NewFitness = " + (sum-1) +" _ Replaced = false");
            }
            if (j != 0)
                L_index = index;
            //print...
        }
    }
}
