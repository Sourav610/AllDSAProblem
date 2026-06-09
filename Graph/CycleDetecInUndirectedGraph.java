package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 
*/
public class CycleDetecInUndirectedGraph {
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 } };

        List<List<Integer>> adjList = new ArrayList();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList());
        }

        boolean[] visited = new boolean[V];

        for (int[] val : edges) {
            adjList.get(val[0]).add(val[1]);
            adjList.get(val[1]).add(val[0]);
        }

        boolean ans = false;
        // Using BFS
        ans = bfsTraverse(adjList, 0, -1, visited);

        System.out.println("is there any cyclic component: " + ans);

    }

    public static boolean bfsTraverse(List<List<Integer>> adjList, int start, int parent, boolean[] visited) {
        
        for (int i = 0; i < adjList.size(); i++) {
            if(!visited[i]){
                Queue<int[]> elQueue = new LinkedList();
                elQueue.add(new int[] { start, parent });
                visited[start] = true;
                while (!elQueue.isEmpty()) {
                    int[] val = elQueue.poll();
                    for (Integer it : adjList.get(val[0])) {
                        if (!visited[val[0]]) {
                            visited[val[0]] = true;
                            elQueue.add(new int[] { it, val[0] });
                        } else if (val[1] != it) {
                            return true;
                        }
                    }
                }
            }
            
        }
        return false;

    }

}