package Graph;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given an image represented by an m x n grid of integers image, where image[i][j] 
represents the pixel value of the image. You are also given three integers sr, sc, and color.
 Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill:

Begin with the starting pixel and change its color to color.
Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel,
     either horizontally or vertically) and shares the same color as the starting pixel.
Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color 
if it matches the original color of the starting pixel.
The process stops when there are no more adjacent pixels of the original color to update.
Return the modified image after performing the flood fill.

Constraints:

m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], color < 216
0 <= sr < m
0 <= sc < n
*/
public class FloodFill {
    public static void main(String[]args){
        int[][]img = {
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };

        int sr = 1;
        int sc = 1;
        int color = 2;
        int start = img[sr][sc];
        // int[][]ans = {};
        // ans = fillTheImage(img,sr,sc,color);
        fillTheImageUsingDFS(img, sr, sc, color, start);

        for(int i = 0; i<img.length; i++){
            for(int j = 0; j<img[i].length; j++){
                System.out.print(img[i][j]+" ");
            }
            System.out.println();
        }
    }

    //Using BFS
    //T.C - O(n), S.C - O(n);
    public static int[][] fillTheImage(int[][]img, int i, int j, int color){
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{i,j});
        int start = img[i][j];
        if(color == start){
            return img;
        }
        img[i][j] = color;

        int dx[] = {1,0,-1,0};
        int dy[] = {0,-1,0,1};
        while(!q.isEmpty()){
            int size = q.size();

            for(int l = 0; l<size; l++){
                int[]val = q.poll();
                for(int d = 0; d<4; d++){
                    int x = val[0]+dx[d];
                    int y = val[1]+dy[d];

                    if(x< 0 || x>= img.length || y< 0 || y>= img[0].length || img[x][y] == color || img[x][y] != start){
                        continue;
                    } 

                    img[x][y] = color;
                    q.add(new int[]{x,y});
                }
            }
        }
        return img;
    }

    //Using dfs
    public static void fillTheImageUsingDFS(int[][]img,int i, int j, int color, int start){
        if(i<0 || i>= img.length || j < 0 || j>= img[0].length || img[i][j] == color || img[i][j] != start){
            return;
        }

        img[i][j] = color;
        int dx[] = {1,0,-1,0};
        int dy[] = {0,-1,0,1};
        for(int l = 0; l<4; l++){
            int x = dx[l]+i;
            int y = dy[l]+j;

            fillTheImageUsingDFS(img, x, y, color,start);
            
        }
    }
}
