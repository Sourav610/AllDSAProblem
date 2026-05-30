package Graph;

import java.util.ArrayList;
import java.util.List;

public class DFSInGraphUsingAdjacenyMatrix {
    public static void main(String[]args){
        int V = 5;

        int[][]adj = new int[V][V];

        adj[0][1] = 1;
        adj[1][0] = 1;
        adj[0][2] = 1;
        adj[2][0] = 1;
        adj[0][3] = 1;
        adj[3][0] = 1;
        adj[0][4] = 1;
        adj[4][0] = 1;

        boolean[]visited = new boolean[V];
        List<Integer>res = new ArrayList<>();

        dfs(adj,0,visited,res);

        for (int x : res) {
            System.out.print(x + " ");
        }
        System.out.println();

    }


    /*
     DFS using adjaceny matrix
    */
    public static void dfs(int[][]adj, int i, boolean[]vis, List<Integer>res){
        vis[i] = true;
        res.add(i);

        for(int n = 0; n<adj[i].length; n++){
            if(adj[i][n] == 1 && (!vis[n])){
                dfs(adj,n,vis,res);
            }
        }
    }
}
