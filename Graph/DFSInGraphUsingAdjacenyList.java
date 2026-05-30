package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an undirected graph, return a vector of all nodes by traversing the graph using depth-first search (DFS).
*/
public class DFSInGraphUsingAdjacenyList {
    public static void main(String[]args){
        int V = 5;

        // Adjacency list
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 2));
        adj[1].addAll(Arrays.asList(0,3,4));
        adj[2].addAll(Arrays.asList(0));
        adj[3].addAll(Arrays.asList(1,4));
        adj[4].addAll(Arrays.asList(3,4));

        boolean[]visited = new boolean[V];
        List<Integer>res = new ArrayList<>();

        dfs(adj,0,visited,res);

        for (int x : res) {
            System.out.print(x + " ");
        }
        System.out.println();

    }

    /*
        since adjency list is already there and all node are connected so we no need of outer loop and adjancey list to create. just need
        to traverse the graph and get the node.

        T.C - O(V+E)
        S.C - O(V)
    */
    public static void dfs(List<Integer>[]adj, int i, boolean[]vis, List<Integer>res){
        vis[i] = true;
        res.add(i);

        for(int n: adj[i]){
            if(!vis[n]){
                dfs(adj,n,vis,res);
            }
        }
    }
}
