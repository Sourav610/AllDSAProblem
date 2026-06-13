package Graph;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
*/
public class NumberOfEnclaves{
    public static void main(String[]args){
        int[][]grid = {
            {0,0,0,0},
            {1,0,1,0},
            {0,1,1,0},
            {0,0,0,0}
        };

        int ans = 0;

        ans = countLands(grid);

        System.out.println("The number of enclosed land are: "+ans);
    }

    public static int countLands(int[][]grid){
        int[][]visited = new int[grid.length][grid[0].length];
        Queue<int[]>element  = new LinkedList<>();

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if((i == 0 || i == grid.length-1 || j == 0 || j == grid[i].length-1) && grid[i][j] == 1){
                    element.add(new int[]{i,j});
                    visited[i][j] = 1;
                }
                else{
                    visited[i][j] = 0;
                }
            }
        }

        int count = 0; 
        int dx[] = {1,0,-1,0};
        int dy[] = {0,1,0,-1};

        while(!element.isEmpty()){
            int[]val = element.poll();

            for(int i = 0; i<4; i++){
                int x = val[0]+dx[i];
                int y = val[1]+dy[i];

                if(x < 0|| x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] == 1){
                    continue;
                }

                if(grid[x][y] == 1){
                    element.add(new int[]{x,y});
                    visited[x][y] = 1;
                }
            }
        }

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    count++;
                }
            }
        }

        return count;
    }
}