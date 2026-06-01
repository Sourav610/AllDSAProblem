package Graph;


/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, 
and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, 
and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
*/
public class NumberOfProvinces {
    public static void main(String[]args){
        int V = 3;
        int[][]adj = new int[V][V];

        adj[0][0] = 1;
        adj[0][1] = 1;
        adj[0][2] = 0;
        adj[1][0] = 1;
        adj[1][1] = 1;
        adj[1][2] = 0;
        adj[2][0] = 0;
        adj[2][1] = 0;
        adj[2][2] = 1;

        //using dfs it is the optimal complexity as we are given matrix only
        //T.C - O(n*n)
        //S.C - O(n)

        int count = 0;
        boolean[] visited = new boolean[V];

        for(int i = 0; i<V; i++){
            if(!visited[i]){
                count++;
                dfs(adj,visited,i);
            }
        }

        System.out.println("The number of province are: "+count);
    }

    public static void dfs(int[][]adj, boolean[]visited, int n){
        visited[n] = true;

        for(int i = 0; i<adj[n].length; i++){
            if(adj[n][i] == 1 && (!visited[i])){
                dfs(adj, visited,i);
            }
        }
    }
}
