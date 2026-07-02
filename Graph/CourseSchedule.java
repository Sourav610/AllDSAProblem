package Graph;

import java.util.ArrayList;
import java.util.List;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] 
indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
*/
public class CourseSchedule {
    public static void main(String[]args){
        int V = 5;
        int[][]course = {{1,0},
                        {0,1}};
        
        List<List<Integer>>adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[]val: course){
            adj.get(val[0]).add(val[1]);
        }

        int[]visited = new int[V];
        
        boolean check = true;

        for(int i = 0; i<V; i++){
            if(visited[i] == 0){
                if(dfs(i,adj,visited)== false){
                    check = false;
                    break;
                }
            }
        }

        System.out.println("The course can be complete: "+check);

            
    }

    /*
     Approach: in this approach for cycle detection we are doing like if any edges contain dependency then ti will go for if else condition 
     but if there is no dependency it will not enter the for loop and directly return. So for directly return veritices we are keeping to 2
     and which are entering the loop and already visited once then check in if else if once visited means cycle is there that why return false;

     T.C - O(V+E);
     S.C - O(V+E);
    */

     /*
     In a directed graph, a cycle exists if we can start at some node and keep following directed edges such that we eventually come back to the same node. Detecting such cycles is crucial in problems like task scheduling, dependency resolution, and deadlock detection.

        A Topological Sort is a linear ordering of vertices such that for every directed edge from u to v, u comes before v in the ordering.
         Importantly, a valid topological order exists only if the graph is a Directed Acyclic Graph (DAG). 
         This gives us a powerful idea that if we try to generate a topological sort but cannot include all vertices (some nodes remain stuck due to dependencies),
         then the graph must contain a cycle.

        Kahn’s Algorithm (Topological Sorting Using BFS) makes this detection very straightforward. It repeatedly removes nodes with zero in-degree and if at the end,
         the number of removed nodes is less than the total nodes, that means some nodes were locked in cycles, and hence a cycle exists.
        Compute the in-degree of all nodes in the graph.
        Add all nodes with in-degree equal to zero into a queue.
        Process nodes from the queue one by one, increasing the count of processed nodes.
        For each processed node, reduce the in-degree of its neighbors by one.
        If any neighbor’s in-degree becomes zero, push it into the queue.
        After processing, compare the count of processed nodes with the total number of nodes to decide if a cycle exists.
     */

    public static boolean dfs(int i, List<List<Integer>>adj, int[]visited){
        visited[i] = 1;

        for(int j = 0; j<adj.get(i).size(); j++){
            if(visited[adj.get(i).get(j)] == 0){
                if(dfs(adj.get(i).get(j), adj, visited) == false){
                    return false;
                }
            }
            else if(visited[adj.get(i).get(j)] == 1){
                return false;
            }
        }

        visited[i] = 2;
        return true;
    }
}
