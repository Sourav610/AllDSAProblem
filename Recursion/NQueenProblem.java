import java.util.*;

public class NQueenProblem {
    public static void main(String args[]) {
        int N = 4;
        List < List < String >> queen = solveNQueens2(N);
        int i = 1;
        for (List < String > it: queen) {
            System.out.println("Arrangement " + i);
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
        
    }

    public static List<List<String>>solveNQueens(int n){
        List<List<String>>ans = new ArrayList<List<String>>();
        char[][]board = new char[n][n];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = '.';
            }
        }
        dfs(0,ans,board);
        return ans;
    }

    public static void dfs(int i, List<List<String>>ans,char[][]board){
        if(i == board.length){
            ans.add(construct(board));
            return;
        }

        for(int row = 0; row<board.length; row++){
            if(isValid(row,i,board)){
                board[row][i] = 'Q';
                dfs(i+1, ans, board);
                board[row][i] = '.';
            }
        }
    }

    public static boolean isValid(int row, int col, char[][]board){
        int dupRow = row;
        int dupCol = col;

        while(row>= 0 && col>= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;

        while(col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
        }

        row = dupRow;
        col = dupCol;

        while(row<board.length && col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row++;
            col--;
        }

        return true;
    }

    public static List<String> construct(char[][]board){
        List<String>res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static List < List < String >> solveNQueens2(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List < List < String >> res = new ArrayList < List < String >> ();
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2 * n - 1];
        int lowerDiagonal[] = new int[2 * n - 1];
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }



    static void solve(int col, char[][] board, List < List < String >> res, int leftRow[], int lowerDiagonal[], int upperDiagonal[]) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }
    
}
