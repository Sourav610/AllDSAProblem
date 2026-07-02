package Graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule2 {
    public static void main(String[]args){
        int V = 2;
        int[][]course = {
            {1,0},
            {2,0},
            {3,1},
            {3,2}
        };

        List<Integer>[]adj = new ArrayList[V];

        for(int i = 0; i<V; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[]val: course){
            adj[val[0]].add(val[1]);
        }

        List<Integer>ans  = new ArrayList<>();

        int[]visited = new int[V];

        for(int i = 0; i<V; i++){
            if(visited[i] == 0){
                dfs(i,adj,visited,ans);
            }
        }

        for(Integer i: ans){
            System.out.println(i+" ");
        }
    }

    /*
     same approach as course schedule 1;
     T.C - O(V+E)
     S.C - O(V+E)
    */

    public static boolean dfs(int start, List<Integer>[]adj,int[]visited,List<Integer>ans){
        visited[start] = 1;

        for(int i =0; i<adj[start].size(); i++){
            if(visited[adj[start].get(i)] == 0){
                if(dfs(adj[start].get(i),adj,visited,ans) == false){
                    return false;
                };
            }
            else if(visited[adj[start].get(i)] == 1){
                return false;
            }
        }

        ans.add(start);
        visited[start] = 2;
        return true;
    }
}
