package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary{
    public static void main(String[]args){
        String[]word = {"ab", "cd", "ef", "ad"};

        boolean check = false;

        // check = calculateLanguage(word);
        check = checkLanguage(word);

        System.out.println("The ans is :"+check);

    }

    /*
    In a directed graph, a cycle exists if we can start at some node and keep following directed edges such that 
    we eventually come back to the same node. Detecting such cycles is crucial in problems like task scheduling,
     dependency resolution, and deadlock detection.

    A Topological Sort is a linear ordering of vertices such that for every directed edge from u to v, u comes before v in the ordering. Importantly, a valid topological order exists only if the graph is a Directed Acyclic Graph (DAG). This gives us a powerful idea that if we try to generate a topological sort but cannot include all vertices (some nodes remain stuck due to dependencies), then the graph must contain a cycle.

    Kahn’s Algorithm (Topological Sorting Using BFS) makes this detection very straightforward. It repeatedly removes nodes with zero in-degree and if at the end, the number of removed nodes is less than the total nodes, that means some nodes were locked in cycles, and hence a cycle exists.
    Compute the in-degree of all nodes in the graph.
    Add all nodes with in-degree equal to zero into a queue.
    Process nodes from the queue one by one, increasing the count of processed nodes.
    For each processed node, reduce the in-degree of its neighbors by one.
    If any neighbor’s in-degree becomes zero, push it into the queue.
    After processing, compare the count of processed nodes with the total number of nodes to decide if a cycle exists.
    */
    //using bfs approach;
    //T.C - O(n*m), s.C - O(1);
    public static boolean calculateLanguage(String[]word){
        List<List<Integer>>adj = new ArrayList<>(26);
        for(int i = 0; i<26; i++){
            adj.add(new ArrayList<>());
        }
        int[]inDegree  = new int[26];
        
        for(int i = 1; i<word.length; i++){
            String w1 = word[i-1];
            String w2 = word[i];

            int ind = 0;
            while(ind < w1.length() && ind <w2.length() && (w1.charAt(ind) == w2.charAt(ind))){
                ind++;
            }
            if(ind == w2.length() && w1.length() > w2.length()){
                return false;
            }
            if(ind < w1.length() && ind < w2.length()){
                adj.get(w1.charAt(ind)-'a').add(w2.charAt(ind)-'a');
                inDegree[w2.charAt(ind)-'a']++;
            }
        }

        boolean[]check = new boolean[26];
        for(String ws: word){
            for(char ch: ws.toCharArray()){
                if(check[ch-'a'] == false){
                    check[ch-'a'] = true;
                }
            }
        }

        Queue<Integer>q = new LinkedList();
        int checkCount = 0;

        for(int i = 0; i<26; i++){
            if(inDegree[i] == 0 && check[i] == true){
                q.offer(i);
            }
            if(check[i]== true){
                checkCount++;
            }
        }

        int count = 0;
        while(!q.isEmpty()){
            int val = q.poll();
            count++;

            for(int rem: adj.get(val)){
                inDegree[rem]--;
                if(check[rem] == true && inDegree[rem] == 0){
                    q.offer(rem);
                }
            }
        }

        if(count == checkCount){
            return true;
        }
        return false;

    }

    //Using dfs
    public static boolean checkLanguage(String[]word){
        List<List<Integer>>adj = new ArrayList<>(26);
        for(int i = 0; i<26; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 1; i<word.length; i++){
            String w1 = word[i-1];
            String w2 = word[i];

            int ind = 0;
            while(ind < w1.length() && ind <w2.length() && (w1.charAt(ind) == w2.charAt(ind))){
                ind++;
            }
            if(ind == w2.length() && w1.length() > w2.length()){
                return false;
            }
            if(ind < w1.length() && ind < w2.length()){
                adj.get(w1.charAt(ind)-'a').add(w2.charAt(ind)-'a');
            }
        }

        boolean[]check = new boolean[26];
        for(String ws: word){
            for(char ch: ws.toCharArray()){
                if(check[ch-'a'] == false){
                    check[ch-'a'] = true;
                }
            }
        }

        int[]visited = new int[26];
        for(int i= 0; i<26; i++){
            if(check[i] == true && visited[i] == 0){
                if(dfs(i,adj,visited) == false){
                    return false;
                };
            }
        }
        return true;
    }

    public static boolean dfs(int node, List<List<Integer>>adj, int[]visited){
        visited[node] = 1;

        for(int i = 0; i<adj.get(node).size(); i++){
            int ind = adj.get(node).get(i);
            if(visited[ind] == 0){
                if(dfs(ind, adj, visited) == false){
                    return false;
                };
            }
            else if(visited[ind] == 1){
                return false;
            }
        }

        visited[node] = 2;
        return true;
    }
}