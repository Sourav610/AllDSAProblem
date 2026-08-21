package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


/*
You are given a network of n nodes, labeled from 1 to n. You are also given times, 
a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node,
 vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to 
receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.


*/
public class NetworkDelayTime{
    public static void main(String[] args) {
        int[][] times = {
            {2,1,1},
            {2,3,1},
            {3,4,1}
        };

        int n = 4;
        int k = 2;

        List<List<int[]>>adj = new ArrayList<>();
        int[] visited = new int[n+1];
        for(int i = 0; i<=n; i++){
            adj.add(new ArrayList<>());
            visited[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i<times.length; i++){
            int src = times[i][0];
            int destination = times[i][1];
            int value = times[i][2];
            
            adj.get(src).add(new int[]{destination,value});
        }

        PriorityQueue<int[]>q = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        q.add(new int[]{0,2});
        visited[k] = 0;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int src = temp[1];
            int cost = temp[0];

            for(int[] val: adj.get(src)){
                if(cost+val[1] < visited[val[0]]){
                    visited[val[0]] = cost+val[1];
                    q.add(new int[]{visited[val[0]],val[0]});
                }
            }
        }

        int total = -1;

        for(int i = 1; i<=n; i++){
            if(visited[i] == Integer.MAX_VALUE){
                break;
            }
            else{
                total = Math.max(total,visited[i]);
            }
        }

        System.out.println("The total cost is: "+total);

    }
}