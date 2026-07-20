package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Statement: Given an Undirected Graph having unit weight, find the shortest path from the source to all other nodes in this graph.
 In this problem statement, we have assumed the source vertex to be ‘0’. If a vertex is unreachable from the source node,
then return -1 for that vertex.
*/
public class ShortestPathInUndirectedGraph{
    public static void main(String[]args){
        int n = 9, m = 10, src = 0;
        int[][]edges = {
            {0, 1},
            {0,3},
            {3, 4},
            {4, 5},
            {5, 6},
            {1, 2},
            {2, 6},
            {6, 7},
            {7, 8},
            {6, 8}
        };
        
        List<List<Integer>>adj = new ArrayList<>();
        int[]ans = new int[n];
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);

        }

        int[]arr = new int[n];
        //Using dfs
        // for(int i = 0; i<n; i++){
        //     ans[i] = calculateDistance(src,i, adj,arr);
        // }

        //using bfs
        //T.C - O(V+E); // each vertex is added one time in queue and each edge appears in two adjacency lists, so total iterations = 2E,
        //  which is still O(E).
        //S.C - O(V)
        Queue<Integer>q = new LinkedList<>();
        q.add(src);
        arr[src] = 0;

        while(!q.isEmpty()){
            int val = q.poll();

            for(int res: adj.get(val)){
                if(arr[res] == 0){
                    q.add(res);
                    arr[res] = arr[val]+1;
                }
            }
        }
        System.out.println("The distance of edges from src are: ");
        for(int i = 0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    //Using dfs approach
    //T.c - O(2^V) as we are exploring all path in this approach;
    //S.c - O(V+E);
    public static int calculateDistance(int src, int end, List<List<Integer>>adj, int[]arr){
        if(src == end){
            return 0;
        }
        if(adj.get(src).contains(end)){
            return 1;
        }

        int min = Integer.MAX_VALUE;

        arr[src] = 1;
        for(int i = 0; i<adj.get(src).size(); i++){
            if(arr[adj.get(src).get(i)] == 0){
                int val =  calculateDistance(adj.get(src).get(i), end, adj, arr);
                if(val != Integer.MAX_VALUE){
                    min = Math.min(min,val+1);
                }
            }
        }

        arr[src] = 0;
        return min;

    }
}