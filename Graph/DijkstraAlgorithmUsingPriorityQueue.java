package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithmUsingPriorityQueue{
    public static void main(String[]args){
        int V = 3,src = 2;
        List<List<int[]>>adj = new ArrayList<>();
        List<Integer>visited = new ArrayList<>();
        for(int i = 0; i<3; i++){
            adj.add(new ArrayList<>());
            visited.add(Integer.MAX_VALUE);
        }

        visited.set(src,0);
        adj.get(0).add(new int[]{1,1});
        adj.get(0).add(new int[]{2,6});
        adj.get(1).add(new int[]{2,3});
        adj.get(1).add(new int[]{0,1});
        adj.get(2).add(new int[]{1,3});
        adj.get(2).add(new int[]{0,6});

        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.add(new int[]{0,src});

        while(!pq.isEmpty()){
            int[]temp = pq.poll();
            int node = temp[1];
            int dist = temp[0];

            for(int[] it: adj.get(node)){
                if(dist+it[1] < visited.get(it[0])){
                    visited.set(it[0],dist+it[1]);
                    pq.add(new int[]{visited.get(it[0]),it[0]});
                }
            }
        }

        for(int i = 0; i<V; i++){
            System.out.print(visited.get(i)+" ");
        }

    }
}