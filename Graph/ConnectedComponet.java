package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Statement: Given an undirected Graph consisting of V vertices numbered from 0 to V-1 and E edges. 
The ith edge is represented by [ai,bi], denoting a edge between vertex ai and bi. We say two vertices u and v
 belong to a same component if there is a path from u to v or v to u. Find the number of connected components in the graph.

A connected component is a subgraph of a graph in which there exists a path between any two vertices, 
and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

*/

public class ConnectedComponet {
    public static void main(String[]args){
        int V = 5;
        int[][]edges = {{0,1},{1,2},{3,4}};
        int ans =0;
        // ans = calculateComponent(V,edges);
        ans = getComponents(edges,V);
        System.out.println("the number of connected component are: "+ans);
    }

    /*
        Approach:
            Use a visited array to track the vertices that has been visited once.
            Build an adjacency list from the given edges for efficient traversal.
            For each vertex:
            If the vertex is not visited, perform DFS/BFS starting from it.
            This traversal will mark all vertices in the same component as visited.
            Increment the number of components for every traversal.
            Once all the vertices are visited, return the number of connected components.

    */

    public static int calculateComponent(int V, int[][]edges){

        List<List<Integer>>adj = new ArrayList<>();

        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e: edges){
           adj.get(e[0]).add(e[1]);
           adj.get(e[1]).add(e[0]);
        }

        boolean[]visited = new boolean[V];

        int component = 0;

        //using BFS
        for(int i = 0; i<V; i++){
            if(!visited[i]){
                component++;
                Queue<Integer>q = new LinkedList<>();
                q.offer(i);
                visited[i] = true;

                while(!q.isEmpty()){
                    int node = q.poll();


                    for(int nv: adj.get(node)){
                        if(!visited[nv]){
                            visited[nv] = true;
                            q.offer(nv);
                        }
                    }
                }
            }
        }

        return component; 

    }
    
    //Using dfs

    private static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s, ArrayList<Integer> res) {
        visited[s] = true;
        res.add(s);

        // Recursively visit all adjacent 
        // vertices that are not visited yet
        for (int i : adj.get(s)) {
            if (!visited[i]) {
                dfs(adj, visited, i, res);
            }
        }
    }

    public static int getComponents(int[][] adj, int V) {
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int count =0;
        
        for(int i = 0; i<V; i++){
            al.add(new ArrayList<>());
        }

        for(int[] e: adj){
           al.get(e[0]).add(e[1]);
           al.get(e[1]).add(e[0]);
        }
        // Loop through all vertices 
        // to handle all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                count++;
                dfs(al, visited, i, component);
                res.add(component);
            }
        }

        return count;
    }
}
