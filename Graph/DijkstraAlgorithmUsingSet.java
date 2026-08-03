package Graph;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

        Set<int[]>st = new HashSet<>();

        st.add(new int[]{0,2});
        visited.set(s,0);
        
        while(!st.isEmpty()){
            int[]temp = st.iterator().next();
            int dis = temp[0];
            int node = temp[1];
            st.remove(temp);

            for(int[] it: adj.get(node)){
                if(dis+it[1] < visited.get(it[0])){

                    if(visited.get(node) != Integer.MAX_VALUE){
                        st.remove(new int[]{visited.get(it[0]),it[0]});
                    }
                    
                    visited.set(it[0],dis+it[1]);
                    st.add(new int[]{visited.get(it[0]),it[0]});
                }
            }
        }


        for(int i = 0; i<visited.size(); i++){
            System.out.print(visited.get(i)+" ");
        }
    
    }
}
