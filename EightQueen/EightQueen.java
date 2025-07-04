package EightQueen;

public class EightQueen {
    private final int[] board;
    private int cost;
    public EightQueen() {
        board = new int[8];
    }

    public void placeQueen(int column, int row) {
        board[column] = row;
    }

    public void calcCost() {
        for (int col = 0;col < 8;col++) {
            for (int j = 0;j < 8;j++) {
                if (j != col)
                    if (Math.abs(board[col] - board[j]) == Math.abs(col - j))
                        cost++;
            }
        }
    }

    public int getCost() {
        return cost;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int col = 0;col < 8;col++) {
            for (int row = 0;row < 8;row++) {
                if (board[col] == row)
                    sb.append(" Q ");
                else
                    sb.append(" . ");
            }
        }
        return sb.toString();
    }
}
