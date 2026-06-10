package Graph;

import java.util.LinkedList;
import java.util.Queue;

/*
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two cells sharing a common edge is 1.
*/
public class matrix01 {
    public static void main(String[]args){
        int[][] grid = {
            {0, 1, 1, 0},
            {1, 1, 0, 0},
            {0, 0, 1, 1}
        };

        int[][]ans = solve01Matrix(grid);
        for (int[] row : ans) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    /*
     Approach: as we need to calculate distance of 0 from each cell so we will store all 0 index value in queue with step 
     then for each cell we will traverse all four direction and check if any other value is there the push that cell index with increasing step 
     as that far that cell is from 0. and every time we will pop value from queue will store in the ans mat and return it;

     Time Complexity: O(N*M + N*M*4) ~ O(N * M), the BFS function will be called for (N * M) nodes, and for every node, we are traversing for 4 neighbors, so it will take O(N * M * 4) time.

Space Complexity: O(N * M) + O(N * M) + O(N * M) ~ O(N * M), for the visited array, distance matrix, and queue space takes up N * M locations at max.
    */

    public static int[][] solve01Matrix(int[][]grid){
        int[][]ans = new int[grid.length][grid[0].length];
        int[][]visited = new int[grid.length][grid[0].length];

        Queue<int[]>elQueue = new LinkedList();
        for(int i = 0; i<grid.length; i++){
            for(int j= 0; j<grid[i].length; j++){
                if(grid[i][j] == 0){
                    elQueue.add(new int[]{i,j,0});
                    visited[i][j] = 1;
                }
                else{
                    visited[i][j] = 0;
                }
            }
        }

        int dx[]= {1, 0,-1,0};
        int dy[] = {0,-1, 0,1};

        while(!elQueue.isEmpty()){
            int[]val = elQueue.poll();
            int row = val[0];
            int col = val[1];
            int step = val[2];

            ans[row][col] = step;

            for(int i = 0; i<4; i++){
                int nx = row+dx[i];
                int ny = col+dy[i];

                if(nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length || visited[nx][ny] == 1){
                    continue;
                }

                elQueue.add(new int[]{nx,ny,step+1});
                visited[nx][ny] = 1;

            }
        }

        return ans;
    }
}
