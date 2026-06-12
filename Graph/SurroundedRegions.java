package Graph;


import java.util.LinkedList;
import java.util.Queue;


/*
You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: A region is surrounded if none of the 'O' cells in that region are on the edge of the board.
 Such regions are completely enclosed by 'X' cells.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
*/
public class SurroundedRegions{
    public static void main(String[]args){
        char[][]board = {
            {'X','X','O','X'},
            {'X','X','O','X'},
            {'X','O','X','O'},
            {'X','X','X','X'}            
            };

        fillTheBoard(board);

        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }

    /*
     using bfs
     Approach: I am iterating the edge and insert if any one is 'O' and then traversing the queue and check how many other 
     cell are connected to this one which containing same character and mark them as visited.

     finally traversing the visited array to check for non visited element and mark it to 'X' in the board matrix.

     as we now if any edge contain 'O' and other same element which are connected to this are not sorrounded.

     T.C - O(n*n);
     S.C - O(n*n);
    */

    public static void fillTheBoard(char[][]board){
        int[][]visited = new int[board.length][board.length];
        Queue<int[]>elQueue = new LinkedList<>();

        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                if((i == 0 || i == board.length -1 || j == 0 || j == board.length-1) && board[i][j] == 'O'){
                    visited[i][j]= 1;
                    elQueue.add(new int[]{i,j});
                }
            }
        }

        int[]dx = {1,0,-1, 0};
        int[]dy = {0, 1, 0, -1};

        while(!elQueue.isEmpty()){
            int[]val = elQueue.poll();

            for(int i = 0; i<4; i++){
                int x = val[0]+dx[i];
                int y = val[1]+dy[i];

                if(x < 0 || x >= board.length || y < 0 || y >= board.length){
                    continue;
                }

                if(board[x][y] == 'O' && visited[x][y] == 0){
                    elQueue.add(new int[]{x,y});
                    visited[x][y] = 1;
                }
            }
        }

        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(visited[i][j] == 0 && board[i][j] == 'O'){
                    // System.out.print(i+" "+j);
                    board[i][j] = 'X';
                }
            }
        }

    }


    public static void fillTheBoardUsingDFs(char[][]board){
        
    }
}