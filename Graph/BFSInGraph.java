package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a connected undirected graph containing V vertices, represented by a 2-d adjacency list adj[][], 
where each adj[i] represents the list of vertices connected to vertex i. Perform a Breadth First Search (BFS)
 traversal starting from vertex 0, visiting vertices from left to right according to the given adjacency list,
  and return a list containing the BFS traversal of the graph.

  Note: Do traverse in the same order as they are in the given adjacency list.

  T.C - O(V+E);
  S.C - O(V)
*/
public class BFSInGraph {
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

        Queue<Integer>eleQ = new LinkedList<>();
        eleQ.add(0);
        visited[0] = true;
        res.add(0);

        while(!eleQ.isEmpty()){
            int val = eleQ.poll();

            for(Integer i: adj[val]){
                if(!visited[i]){
                    visited[i] = true;
                    res.add(i);
                    eleQ.add(i);
                }
            }
        }

        for (int x : res) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
