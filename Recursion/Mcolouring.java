import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*                                          1---2
                                            |   |
                                            4 -- 3
step1. Initially node 1 is given color 1. And we check whether this configuration is valid till now.
step2. Now we give node 2 color 1 which is not valid since node 1 and node 2 are connected and have same color.
step3. So now node 2 is given color 2 and coloring till now is valid.
step4. Now we give node 3 color 1 which will not be valid since node 1 and 3 have same color and are connected.
step5. So now node 3 is given color 2 which is also not valid. Since we only had 2 colors so we will backtrack to node 2 and give it next color.
step6. Like this we backtrack to previous nodes whenever all colors are used up for that particular node.
If we checked all colors for a node and coloring still does not become valid we backtrack to previous node and take the next color for that node.

Complexity
Time Complexity: O(M ^ V), Since these are the total number of color combinations. The upper bound time complexity is same as brute force but on an average it will take less time.
Auxiliary Space: O(V), Recursive stack.
} */
public class Mcolouring {
    
    public static void main(String[]args){
        int vertices = 4;
        int color = 3;
        int[][]edges = {
            {0,1},{1,3},{2,3},{3,0},{0,2}
        };

        boolean result = colorVertices(vertices,color,edges);
        System.out.println("is it possible to color all vertices: "+result);
    }

    public static boolean colorVertices(int v, int m, int[][]edges){
        List<Integer>[]adj = new ArrayList[v];
        for(int i = 0; i<v; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[]it:edges){
            adj[it[0]].add(it[1]);
            adj[it[1]].add(it[0]);
        }

        int[]color = new int[v];
        Arrays.fill(color,-1);
        return canColor(0,m,adj,color);
        
    }

    static boolean canColor(int vertex, int m, List<Integer>[] adj, int[] color) {

        // If all vertices are colored successfully
        if (vertex == color.length) return true;

        // Try all colors from 0 to m-1
        for (int i = 0; i < m; i++) {
            if (issafe(vertex, i, adj, color)) {
                color[vertex] = i;
                if (canColor(vertex + 1, m, adj, color))
                    // If the rest can be colored, return true
                    return true;
                color[vertex] = -1;
            }
        }

        return false; // No valid coloring found
    }
    static boolean issafe(int vertex, int col, List<Integer>[] adj, int[] color) {

        for (int it : adj[vertex]) {
            // If adjacent vertex has the same color, not safe
            if (color[it] != -1 && col == color[it]) return false;
        }
        return true;
    }
}
