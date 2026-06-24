package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph,
 where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], 
 there is an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph 
connects a node in set A and a node in set B.s
*/
public class BipartiteGraph {
    public static void main(String[]args){
        int V = 5;

        // Adjacency list
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 2));
        adj[1].addAll(Arrays.asList(0,3,4));
        adj[2].addAll(Arrays.asList(0));
        adj[3].addAll(Arrays.asList(1,4));
        adj[4].addAll(Arrays.asList(3,4));
        // adj[0].addAll(Arrays.asList(1, 3));
        // adj[1].addAll(Arrays.asList(0,2));
        // adj[2].addAll(Arrays.asList(1,3));
        // adj[3].addAll(Arrays.asList(0,2));

        boolean checkBipartite = false;
        checkBipartite = checkBipartiteGraph(V,adj);
        System.out.println("is possible to convert the graph to bipartite: "+checkBipartite);
    }

    /*
     ***A bipartite graph is a graph which can be coloured using 2 colours such that no adjacent nodes have the same colour***.
     Any linear graph with no cycle is always a bipartite graph. With a cycle, any graph with an even cycle length can also be a bipartite graph. 
     So, any graph with an odd cycle length can never be a bipartite graph.

    The intuition is the brute force of filling colours using any traversal technique, just make sure no two adjacent nodes have the same colour.
    If at any moment of traversal, we find the adjacent nodes to have the same colour, it means that there is an odd cycle, or it cannot be a bipartite graph. 


    Apporach:

    The algorithm steps are as follows:

    For DFS traversal, we need a start node and a visited array but in this case, instead of a visited array, 
    we will take a colour array where all the nodes are initialised to -1 indicating they are not coloured yet.
    In the DFS function call, make sure to pass the value of the assigned colour, and assign the same in the colour array. 
    We will try to colour with 0 and 1, but you can choose other colours as well. We will start with the colour 0, 
    you can start with 1 as well, just make sure for the adjacent node, it should be opposite of what the current node has. 
    In DFS traversal, we travel in-depth to all its uncoloured neighbours using the adjacency list. For every uncoloured node, 
    initialise it with the opposite colour to that of the current node.
    If at any moment, we get an adjacent node from the adjacency list which is already coloured and has the same colour as 
    the current node, we can say it is not possible to colour it, hence it cannot be bipartite. Thereby return a
     false indicating the given graph is not bipartite; otherwise, keep on returning true.
    Time Complexity: O(V + 2E), Where V = Vertices, 2E is for total degrees as we traverse all adjacent nodes.

    Space Complexity: O(3V) ~ O(V), Space for DFS stack space, colour array and an adjacency list.
    */

    public static boolean checkBipartiteGraph(int V, List<Integer>[]adj){
        List<Integer>colored = new ArrayList<>();
        for(int i = 0; i<V; i++){
            colored.add(-1);
        }

        for(int i = 0; i<V; i++){
            if(colored.get(i) == -1){
                if(dfs(adj,i,0,colored) == false){
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean dfs(List<Integer>[]adj,int ind, int color, List<Integer>colored){
        colored.set(ind,color);

        for(Integer i: adj[ind]){
            if(colored.get(i) == -1){
                if(dfs(adj,i,1-color,colored) == false){
                    return false;
                }
            }
            else if(colored.get(i) == color){
                return false;
            }
        }
        return true;
    }


}
