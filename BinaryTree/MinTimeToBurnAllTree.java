package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


/*
You are given the root of a binary tree with unique values, and an integer start.
 At minute 0, an infection starts from the node with value start.

Each minute, a node becomes infected if:

The node is currently uninfected.
The node is adjacent to an infected node.
Return the number of minutes needed for the entire tree to be infected.

1st approach i solve it using logic of NodesDistanceInBinaryTree

2nd approach is using adjecency list shown below
- Convert Binary Tree to Graph: Use DFS or BFS to traverse the tree. For each node:
Create a bi-directional edge between the node and its left child (if exists).
Create a bi-directional edge between the node and its right child (if exists).
Store these edges in an adjacency list format.
Initialize BFS: Create a queue and a visited set.
Push the target node’s value into the queue.
Mark it as visited.
Initialize a time counter to 0.
Perform BFS Level-by-Level: While the queue is not empty:
Get the current level size (number of nodes burning at this second).
For each node at this level:
Explore all its neighbors (from the graph).
If a neighbor is not visited:
Mark it visited and add it to the queue.
Increment the time counter after each level.
Return time Once all nodes are burned( when queue gets empty)

T.C - O(n), S.C - O(n)

#---------------3rd approach one pass DFS--------------

Here is the basic recursive algorithm for finding the maximum depth, which we will adjust to our needs.

If root = null return 0.
Make a recursive call with root.right and save as rightDepth.
Make a recursive call with root.left and save as leftDepth.
Return max(rightDepth, leftDepth) + 1.
One challenge to this task is identifying whether we have encountered the 
start node during the traversal. We can return a negative depth when we encounter the start node.
 This will flag that we have found the start node, and as we traverse the tree, 
 whenever we encounter a negative depth, we know the subtree contains the start node.

Additionally, as we traverse the tree, we might find the start node before we have calculated 
the max depth of each part of the tree. Therefore, we need to be able to save the max distance
 and continue calculating it while traversing the rest of the tree.

There are four main cases:

If root is null, return 0.
root.val = start. If so, we return depth = -1 to signify this is the start node. 
In this way, in subsequent recursive calls, the parent node of the start node will know
 whether its child nodes contain the start node. Here we are also able to calculate the 
 maxDistance of any node in the start node's subtree by finding the max of the left and right depth.
The left and right depth are both non-negative. If they are, we know the start node is not in this subtree,
 and we can set depth = max(leftDepth, rightDepth) just like with the basic max depth.
The final case is when the root is not the start node, but its subtree contains the start node.
 In this case, we will set depth = min(leftDepth, rightDepth) - 1, which will give us a negative number,
the absolute value of which represents the distance of the start node to the root node. 
To calculate the distance from the start node to the furthest node in the other subtree,
we will add the absolute value of the negative depth of the subtree that contains the start node,
and the positive depth of the other subtree, for convenience, we can directly take the absolute value of two values.
 Then, we update maxDistance with distance if it is larger.


*/
public class MinTimeToBurnAllTree {
    static int maxDistance = 0;
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();
        int target = 6;
        Map<Integer,List<Integer>>mp = new HashMap<>();
        populateMap(root,null,mp);

        Set<Integer>visited = new HashSet();
        Queue<Integer>eleQueue = new LinkedList<>();
        eleQueue.offer(target);
        visited.add(target);

        int time = 0;
        while(!eleQueue.isEmpty()){
            int size = eleQueue.size();
            boolean burned = false;

            for(int i = 0; i<size; i++){
                int node = eleQueue.poll();

                for(int neighbour: mp.getOrDefault(node, new ArrayList<>())){
                    if(!visited.contains(neighbour)){
                        visited.add(neighbour);
                        eleQueue.add(neighbour);
                        burned = true;
                    }
                }
            }
            if(burned){
                time++;
            }
        }
        
        System.out.println("Time take to burn all nodes: "+time);

    }

    public static void populateMap(Node root,Node parentNode, Map<Integer,List<Integer>>mp){
        if(root == null){
            return;
        }

        if(parentNode != null){
            mp.computeIfAbsent(root.data, k->new ArrayList<>()).add(parentNode.data);
            mp.computeIfAbsent(parentNode.data,k->new ArrayList<>()).add(root.data);
        }

        populateMap(root.left, root, mp);
        populateMap(root.right, root, mp);
    }

    public static int dfsOnePass(Node root, int start){
        int depth = 0;
        if(root == null){
            return depth;
        }

        int leftDepth = dfsOnePass(root.left, start);
        int rightDepth = dfsOnePass(root.right, start);

        if(root.data == start){
            maxDistance = Math.max(leftDepth,rightDepth);
            depth = -1;
        }
        else if(leftDepth >= 0 && rightDepth >= 0){
            depth = Math.max(leftDepth,rightDepth)+1;
        }
        else{
            int distance = Math.abs(leftDepth)+Math.abs(rightDepth);
            maxDistance = Math.max(maxDistance,distance);
            depth = Math.min(leftDepth,rightDepth)-1;
        }

        return depth;



    }


}
