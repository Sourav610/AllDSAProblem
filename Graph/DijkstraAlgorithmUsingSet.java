package Graph;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class DijkstraAlgorithmUsingSet {
    public static void main(String[]args){
        int V = 3, E = 3, s = 2;
        List<List<int[]>>adj = new ArrayList();
        List<Integer>visited = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
            visited.add(Integer.MAX_VALUE);
        }

        adj.get(0).add(new int[]{1,1});
        adj.get(0).add(new int[]{2,6});
        adj.get(1).add(new int[]{2,3});
        adj.get(1).add(new int[]{0,1});
        adj.get(2).add(new int[]{1,3});
        adj.get(2).add(new int[]{0,6});

        //using sorted set and by type casting it for int[];
        Set<int[]>st = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]); // Tie-breaker by node ID
        });

        int[][] nodeArrayTracker = new int[V][];

        int[] sourcePair = new int[]{0, s};
        st.add(sourcePair);
        visited.set(s,0);
        nodeArrayTracker[s] = sourcePair; // Save reference
        
        while(!st.isEmpty()){
            int[]temp = st.iterator().next();
            int dis = temp[0];
            int node = temp[1];
            st.remove(temp);
            nodeArrayTracker[node] = null; // Cleared from set

            for(int[] it: adj.get(node)){
                if(dis+it[1] < visited.get(it[0])){

                    if(visited.get(it[0]) != Integer.MAX_VALUE){
                        st.remove(nodeArrayTracker[it[0]]);
                    }
                    
                    visited.set(it[0],dis+it[1]);
                    int[] newPair = new int[]{visited.get(it[0]), it[0]};
                    st.add(newPair);
                    nodeArrayTracker[it[0]] = newPair; 
                }
            }
        }


        for(int i = 0; i<visited.size(); i++){
            System.out.print(visited.get(i)+" ");
        }
    
    }
}
