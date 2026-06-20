package Graph;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands 
horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*/
public class NumberOfIsland {
    public static void main(String[]args){
        char[][]grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        int count = 0;

        count = findAllIsland(grid);

        System.out.println("The number of island are: "+count);
    }

    /*
     Approach: mark all connected val which is 1 and visited only which is not marked and count it
     T.C - O(n*m); // in worst case one 1 time i have to traverse all cell so n*m
     S.C - O(n*m);
    */
    public static int findAllIsland(char[][]grid){
        int[][]visited = new int[grid.length][grid[0].length];
        int count = 0;

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    dfs(grid,i,j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][]grid,int i, int j, int[][]visited){
        visited[i][j] = 1;

        int[]dx = {1,0,-1,0};
        int[]dy ={0,1,0,-1};

        for(int d = 0; d<4; d++){
            int x = i+dx[d];
            int y = j+dy[d];

            if(x < 0 ||  x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] == 1 || grid[x][y] == '0'){
                continue;
            } 

            dfs(grid,x,y,visited);
        }

    }
}
