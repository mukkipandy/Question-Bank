package com.interview.gs;

/*
Instructions:

Given an empty chessboard (8x8 grid), a knight is placed
on one of the squares. The knight 'K' at position (3, 3)
and it's possible movements 'X' are shown in the example
below:

* * * * * * * *
* * X * X * * *
* X * * * X * *
* * * K * * * *
* X * * * X * *
* * X * X * * *
* * * * * * * *
* * * * * * * *

Depending on the knight's position on the board, 0-6 of
the 8 possible movements may cause the knight to leave
the chess board.

If the knight moves n times, each time choosing one of
the 8 possible moves uniformly at random, determine the
probability that the knight is still on the board after
making n random moves. After the knight has left the
board, it may not reenter.

Please implement the method probability which given a
start position x, y, and a number of moves n,
returns the probability a knight remains on the board
as described above.
*/
public class _02_KnightProbability {

  /**
   * TODO: Implement Me!
   */
  public static double probability(int row, int column, int steps) {
    int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    int boardSize = 8;
    double[][] board = new double[boardSize][boardSize];
    board[row][column] = 1.0;

    double[][] curBoard;
    for (int i = 0; i < steps; i++) {
      curBoard = board;
      board = new double[boardSize][boardSize];

      for (int x = 0; x < boardSize; x++) {
        for (int y = 0; y < boardSize; y++) {
          if (curBoard[x][y] == 0.0) {
            continue;
          }

          for (int[] dir : moves) {
            int nextRow = x + dir[0];
            int nextCol = y + dir[1];

            if (nextRow >= 0 && nextRow < boardSize && nextCol >= 0 && nextCol < boardSize) {
              board[nextRow][nextCol] += curBoard[x][y] / 8.0;
            }
          }
        }
      }
    }

    double total = 0.0;
    for (int r = 0; r < boardSize; r++) {
      for (int c = 0; c < boardSize; c++) {
        total += board[r][c];
      }
    }

    return total;
  }

  public static boolean doTestsPass() {
    // TODO: please feel free to make testing more elegant
    boolean result = true;
    // Start in a corner, no moves
    //result = result && probability(0, 0, 0) == 1.0;
    // Start in the middle, one move
    result = result && probability(3, 3, 1) == 1.0;
    // Start in a corner, one move
    result = result && probability(0, 0, 1) == 0.25;
    result = result && probability(0, 0, 2) == 0.1875;
    result = result && probability(1, 2, 10) == 0.0522148497402668;
    return result;
  }

  /**
   * Execution entry point
   */
  public static void main(String[] args) {
    if (doTestsPass()) {
      System.out.println("All tests pass");
    } else {
      System.out.println("There are test failures");
    }
  }
}
