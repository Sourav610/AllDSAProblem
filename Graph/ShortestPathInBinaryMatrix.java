package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[]args){
        int[][] grid = {
            {0,0,0},
            {1,1,0},
            {1,1,0}
        };

        int n = grid.length;

        int path = Integer.MAX_VALUE;
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        int[]dx = {0,1,0,-1,1,-1,-1,1};
        int[]dy = {1,0,-1,0,1,-1,1,-1};

        int[][]visited = new int[n][n];

        while(!q.isEmpty()){
            int[]val = q.poll();
            int x1 = val[0];
            int y1 = val[1];
            int value = val[2];

            if(x1 == n-1 && y1 == n-1){
                path = Math.min(path,value);
            }
            for(int i = 0; i<8; i++){
                int x = x1+dx[i];
                int y = y1+dy[i];

                if(x < 0 || x >n-1 || y < 0 || y > n-1 || visited[x][y] == 1 || grid[x][y] == 1){
                    continue;
                }
                visited[x][y] = 1;
                q.add(new int[]{x,y,value+1});
            }
        }

        path = path==Integer.MAX_VALUE?-1:path;
        System.out.println("The shortest path: "+path);
    }
}
