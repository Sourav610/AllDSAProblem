package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
create a adjancey matrix of below input graph
Input
5 6
1 2
1 3
2 4
3 4 
3 5 
4 5

Explanation:
Number of nodes, n = 5
Number of edges, m = 6  
Next m lines represent the edges.
*/
public class AdjacenyMatrix{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] adj = new int[n][m];

        for(int i = 0; i<m; i++){
            int u = Integer.parseInt(br.readLine());
            int v = Integer.parseInt(br.readLine());
           
            adj[u][v] = 1;
            //remove this line in case of directed graph
            adj[v][u] = 1;
        }

    }
}