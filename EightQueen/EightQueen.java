package EightQueen;

import java.util.Arrays;

class EightQueen {
    private final int[] board;

    EightQueen() {
        board = new int[8];
    }

    int[] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return "EightQueen{" +
                "board=" + Arrays.toString(board) +
                '}';
    }

    void printBoard() {

    }

    void placeQueen(int column, int row) {
        board[column] = row;
    }

    int calcCost() {
        int cost = 0;
        for (int col = 0; col < board.length; col++) {
            for (int j = (col + 1); j < board.length; j++) {
                if (Math.abs(board[col] - board[j]) == Math.abs(col - j)) cost++;
            }
        }
        return cost;
    }
}