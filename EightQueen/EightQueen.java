package EightQueen;

import java.util.Arrays;

class EightQueen {
    private final int[] board;
    EightQueen(int[] board) {
        this.board = board;
    }

//    int[] getBoard() {
//        return board;
//    }

    @Override
    public String toString() {
        return "EightQueen{" +
                "board=" + Arrays.toString(board) +
                '}';
    }

//    void printBoard() {
//
//    }

//    void placeQueen(int column, int row) {
//        board[column] = row;
//    }

    int calcCost() {
        int cost = 0;
        for (int col = 0; col < board.length; col++) {
            for (int j = (col + 1); j < board.length; j++) {
                if (Math.abs(board[j] - board[col]) == Math.abs(j - col)) cost++;
                if (board[col] == board[j]) cost++;
            }
        }
        return cost;
    }
}