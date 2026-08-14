package Graph;
import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightWithKStops{
    public static void main(String[]args){
        int n = 4, src = 0, dst = 3, K = 1;

        // Flight routes and their costs
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600},
        {2, 3, 200}};

        List<List<int[]>>adj = new ArrayList<>();
        int[]visited = new int[n];

        for(int i = 0; i<n; i++){
            adj.add(new ArrayList());
            visited[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i<flights.length; i++){
            int st = flights[i][0];
            int dest = flights[i][1];
            int cost = flights[i][2];

            adj.get(st).add(new int[]{dest,cost});
        }


        // Call the method to find the cheapest flight
        //using bfs 
        //  Time Complexity: O(N), where the additional log(N) time is eliminated by using a simple queue rather than a priority queue,
        //  which is usually used in Dijkstra’s Algorithm. Where N = Number of flights / Number of edges.
        // Space Complexity: O(|E| + |V|), for the adjacency list, priority queue, and the dist array. 
        // Where E = Number of edges (flights.size()) and V = Number of airports.
        int ans = CheapestFLight(n, adj, src, dst, K,visited);

        // Output the result
        System.out.println(ans);
    }

    public static int CheapestFLight(int n, List<List<int[]>>adj, int src, int dst, int k, int[]visited){

        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{src,0,0});

        visited[src] = 0;

        while(!q.isEmpty()){
            int[]temp = q.poll();
            int st = temp[0];
            int stop = temp[1];
            int cost = temp[2];

            if(stop > k){
                continue;
            }

            for(int[] it: adj.get(st)){
                if(cost+it[1] < visited[it[0]]){
                    visited[it[0]] = cost+it[1];
                    q.add(new int[]{it[0],stop+1, visited[it[0]]});
                }
            }
        }

        if(visited[dst] == Integer.MAX_VALUE){
            return -1;
        }

        return visited[dst];
    }
}