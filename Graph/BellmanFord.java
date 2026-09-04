package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BellmanFord{
    public static void main(String[]args){
        int V = 4,src = 0;
        int[][] edges = {
            {0, 1, 4},
            {1, 2, -6},
            {2, 3, 5},
            {3, 1, -2}
        };

        // int V = 5, src = 0;
        // int[][]edges = {
        //     {1, 3, 2},
        //     {4, 3, -1},
        //     {2, 4, 1},
        //     {1, 2, 1},
        //     {0, 1, 5}
        // };
        int[]dist =new int[V];
        // int res = calculateShortestPath(V,edges,src,dist);
        int res = calculateUsingBellmanFordAlgo(V,edges,src,dist);

        if(res != -1){
            for(int i: dist){
                System.out.println("The shortest distance from src are: "+i);
            }
        }
        else{
            System.out.println("the shortest distance is not found");
        }
        
    }


    //Using BFS
    //T.C - O(V*E), S.C - O(V+E);

    public static int calculateShortestPath(int V, int[][]edges, int src, int[]dist){
        
        List<List<int[]>>adj = new ArrayList<>();
        for(int i = 0 ;i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int [] val: edges){
            int st = val[0];
            int destination = val[1];
            int cost = val[2];

            adj.get(st).add(new int[]{destination,cost});
        }

        int[] count = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{src,0});

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int start = temp[0];
            int cost = temp[1];

            count[start]++;
            if(count[start] > V){
                return -1;
            }

            for(int[] it: adj.get(start)){
                if(cost+it[1] < dist[it[0]]){
                    dist[it[0]] = cost+it[1];
                    q.add(new int[]{it[0], dist[it[0]]});
                }
            }
        }
        return 0;
    }

    /*Using BellmanFord Algorith
    T.C - O(V*E), S.C - O(V);
     */
    public static int calculateUsingBellmanFordAlgo(int V, int[][]edges, int src, int[]dist){
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i = 0; i<V; i++){
            for(int[] edge: edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]){

                    if(i == V-1){
                        return -1;
                    }
                    dist[v] = dist[u]+wt;

                }
            }
        }

        return 0;
    }
}