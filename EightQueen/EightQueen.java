package EightQueen;

import java.util.Arrays;

class EightQueen {
    private int[] board;

    EightQueen() {
        board = new int[8];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = board.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[j] == i) sb.append(" Q ");
                else sb.append(" . ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    int getBoardLength() {
        return board.length;
    }

    void placeQueen(int column, int row) {
        int size = getBoardLength();
        if (row < 0 || row >= size)
            throw new IllegalArgumentException("Row must be between 0 and " + (board.length - 1) + ".");
        board[column] = row;
    }

    int calcCost() {
        int cost = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = i + 1; j < board.length; j++) {
                if (board[i] == board[j]) cost++; // same row
                if (Math.abs(board[i] - board[j]) == Math.abs(i - j)) cost++; // same diagonal
            }
        }
        return cost;
    }

    void copyFrom(EightQueen newBoard) {
        this.board = Arrays.copyOf(newBoard.board, board.length);
    }
}