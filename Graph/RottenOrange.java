package Graph;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
*/
public class RottenOrange{
    public static void main(String[]args){
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int ans= 0;

        ans = calculateTimeToRotten(grid);

        System.out.println("The time taken to rotten all orange: "+ans);
    }

    /*
     using bfs

     The idea is that for each rotten orange, we will find how many fresh oranges there are in its 4 directions. 
     If we find any fresh orange we will make it into a rotten orange. One rotten orange can rotten up to 4 fresh oranges
      present in its 4 directions. For this problem,  we will be using the BFS ( Breadth-First Search ) technique.
    First of all, we will create a Queue data structure to store the coordinates of Rotten Oranges.
    We will also have variables:
    Total_oranges - It will store the total number of oranges in the grid (Rotten + Fresh).
    Count - It will store the total number of oranges rotten by us.
    Total_time - Total time taken to rot all reachable oranges.
    After this, we will traverse the whole grid and count the total number of oranges in the grid and store it in Total_oranges. 
    Then we will also push the rotten oranges into the Queue data structure.
    Now, while our queue is not empty, we will pick up each Rotten Orange and check in all 4 directions whether a Fresh orange is present or not. If it is present, we will make it rotten, push it into our queue, and pop out the Rotten Orange whose work is now done.
    We will also keep track of the count of rotten oranges as we go.
    If we rot some oranges, then obviously our queue will not be empty. In that case, we will increase our total time. 
    This continues until our queue becomes empty.
    Once the queue becomes empty, we will check whether the total number of oranges initially is equal to the count of rotten oranges.
    If yes, we will return the total time taken. Otherwise, we return -1 because some fresh oranges are still left and cannot be made rotten.

    T.C - O(n*n);
    S.C - O(n*n);
    */

    public static int calculateTimeToRotten(int[][]grid){
        if(grid.length == 0){
            return 0;
        }

        Queue<int[]>elQueue = new LinkedList<>();
        int totalOrange = 0;
        int rottenOrange = 0;
        int time = 0;

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j] != 0){
                    totalOrange++;
                }
                if(grid[i][j] == 2){
                    elQueue.add(new int[]{i,j});
                }
            }
        }

        int[]dx = {1,-1,0,0};
        int[]dy = {0,0,1,-1};
        while(!elQueue.isEmpty()){
            int k = elQueue.size();
            rottenOrange += k;

            for(int i = 0; i<k; i++){
                int[]val = elQueue.poll();
                for(int l = 0; l<4; l++){
                    int x = val[0]+dx[l];
                    int y = val[1]+dy[l];

                    if(x< 0 || x >= grid.length || y< 0 || y>= grid.length || grid[x][y] != 1){
                        continue;
                    }

                    grid[x][y] = 2;
                    elQueue.add(new int[]{x,y});
                }
            }
            if(!elQueue.isEmpty()){
                time++;
            }
        }

        return time;
    }
}