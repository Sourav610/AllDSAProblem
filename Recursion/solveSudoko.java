

/*
Approach:

Let’s see the step by step approach. Our main recursive function(solve()) is going to just do a plain matrix
 traversal of the sudoku board. When we find an empty cell, we pause and try to put all available numbers(1 - 9) in
  that particular empty cell.
 We need another loop to do that. But wait, we forgot one thing - the board has to satisfy all the conditions,
  right? So, for that we have another function(isValid()) which will check whether the number we have inserted
   into that empty cell will not violate any conditions.
 If it is violating, we try with the next number. If it is not, we call the same function recursively, but this
  time with the updated state of the board. Now, as usual it tries to fill the remaining cells in the board in the same way.
Now we'll come to the returning values. If at any point we cannot insert any numbers from 1 - 9 in a particular
 cell, it means the current state of the board is wrong and we need to backtrack. An important point to follow is,
  we need to return false to let the parent function(which is called this function) know that we cannot fill this way.
   This will serve as a hint to that function, that it needs to try with the next possible number. Refer to the picture below.

 validating board:
 * 
 *  Now, let's see how we are validating the sudoku board. 
 * After determining a number for a cell(at i'th row, j'th col), we try to check the validity.
 *  As we know, a valid sudoku needs to satisfy 3 conditions, we can use three loops. But 
 * we can do within a single loop itself. Let's try to understand that.
We loop from 0 to 8 and check the values - board[i][col](1st condition) and 
board[row][i](2nd condition), whether the number is already included. For the 3rd condition - the expression (3 * (row / 3) + i / 3) evaluates 
to the row numbers of that 3x3 submatrix and the expression (3 * (col / 3) + i % 3) evaluates to the column numbers.
 */
class Solution {

  public static boolean solveSudoko(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {

          for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) {
              board[i][j] = c;

              if (solveSudoko(board))
                return true;
              else
                board[i][j] = '.';
            }
          }

          return false;
        }
      }
    }
    return true;
  }

  public static boolean isValid(char[][] board, int row, int col, char c) {
    for (int i = 0; i < 9; i++) {
      if (board[i][col] == c)
        return false;

      if (board[row][i] == c)
        return false;

      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {

   char[][] board= {
                    {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                    {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                    {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                    {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                    {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                    {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                    {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                    {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                    {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
                    };
    solveSudoko(board);

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++)
        System.out.print(board[i][j] + " ");
      System.out.println();
    }
  }
}