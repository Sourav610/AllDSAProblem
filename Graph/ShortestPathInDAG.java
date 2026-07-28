package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a Directed Acyclic Graph of V vertices from 0 to V-1 and a 2D Integer array(or vector) edges[ ][ ] of length E, 
where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.

Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.


Time Complexity: O(N+M) {for the topological sort} + O(N+M) {for relaxation of vertices, each node and its adjacent nodes get traversed} ~ O(N+M),where N= number of vertices and M= number of edges.

Space Complexity:  O(N) {for the stack storing the topological sort} + O(N) {for storing the shortest distance for each node} + O(N) {for the visited array} + O( N+2M) {for the adjacency list} ~ O(N+M) .
*/
public class ShortestPathInDAG {
    public static void main(String[]args){
        int V = 6, E = 7;
        int[][] edges = {
            {0,1,2},
            {0,4,1},
            {4,5,4},
            {4,2,2},
            {1,2,3},
            {2,3,6},
            {5,3,1}
        };

        List<List<int[]>>adj = new ArrayList<>();

        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] val: edges){
            int src = val[0];
            int destintaion = val[1];
            int wt = val[2];
            adj.get(src).add(new int[]{destintaion,wt});
        }

        Stack<Integer>st = new Stack<>();

        //doing topological sort
        int[]visited = new int[V];

        for(int i = 0; i<V; i++){
            if(visited[i] == 0){
                dfs(i,visited,adj,st);
            }
        }

        int[]ans = new int[V];
        for(int i = 0; i<V; i++){
            ans[i] = Integer.MAX_VALUE;
        }
        ans[0] = 0;

        //calculationg the weight
        while(!st.isEmpty()){
            int temp = st.peek();
            st.pop();

            if(ans[temp] != Integer.MAX_VALUE){
                for(int[] it: adj.get(temp)){
                    if(ans[temp]+it[1] <  ans[it[0]]){
                        ans[it[0]] = ans[temp]+it[1];
                    }
                }
            }
        }

        for(int i = 0; i<V; i++){
            if(ans[i] == Integer.MAX_VALUE){
                ans[i] = -1;
            }
        }

        System.out.println("The ans is: ");
        for(int i = 0; i<ans.length; i++){
            System.out.println(ans[i]+" ");
        }


    }

    public static void dfs(int ind, int[]visited, List<List<int[]>>adj, Stack<Integer>st){

        visited[ind] = 1;
        for(int i = 0; i<adj.get(ind).size(); i++){
            if(visited[adj.get(ind).get(i)[0]] == 0){
                dfs(adj.get(ind).get(i)[0],visited,adj,st);
            }
        }

        st.add(ind);
    }
}
