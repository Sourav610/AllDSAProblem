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
Given the root of a binary tree, the value of a target node target, 
and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

Time Complexity: O(N) ,We visit each node exactly once when building the parent map using BFS ,O(N).
 We again visit each node at most once during the second BFS traversal from the target, O(N).
  Hence, the total time complexity is O(N), where N is the number of nodes in the binary tree.

Space Complexity: O(N) , The parent map stores one entry per node,O(N). 
The queue and visited set used in BFS also take up to O(N) space in the worst case.
 Therefore, the total space complexity is O(N).

 Approach: 

 first fill the map with child as key and parent as value.
 then we will traverse from the target node to all nodes using level order traversal, as target node is not root node
 so we will use the previous to traverse parent node.
 after reaching the required level the queue will contain all the node till for that level
 we will store it in ans.
*/
public class NodesDistanceInBinaryTree {
    public static void  main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();
        Node target = root.left;
        Map<Node,Node>parentMap = new HashMap<>();
        fillParentMap(root,parentMap);

        List<Integer>ans = new ArrayList<>();
        bfsTraversal(target,parentMap,2,ans);
        for(int i: ans){
            System.out.print(i+" ");
        }

    }

    public static void fillParentMap(Node root, Map<Node,Node>parentMap){
        Queue<Node>elQueue = new LinkedList<>();
        elQueue.add(root);

        while(!elQueue.isEmpty()){
            int size = elQueue.size();
            for(int i = 0; i<size; i++){
                Node curr = elQueue.poll();
                if(curr.left != null){
                    parentMap.put(curr.left,curr);
                    elQueue.add(curr.left);
                }

                if(curr.right != null){
                    parentMap.put(curr.right,curr);
                    elQueue.add(curr.right);
                }
            }
        }
    }

    public static void bfsTraversal(Node target, Map<Node,Node>parentMap,int k,List<Integer>ans){
        Queue<Node>eleQueue = new LinkedList<>();
        eleQueue.add(target);
        int currLevel = 0;
        Set<Node>visited = new HashSet<>();
        visited.add(target);

        while(!eleQueue.isEmpty()){
            int size = eleQueue.size();
            if(currLevel++ == k){
                break;
            }
            for(int i = 0; i<size; i++){
                Node temp = eleQueue.poll();

                if(temp.left != null && !visited.contains(temp.left)){
                    visited.add(temp.left);
                    eleQueue.add(temp.left);
                }

                if(temp.right != null && !visited.contains(temp.right)){
                    visited.add(temp.right);
                    eleQueue.add(temp.right);
                }

                if(parentMap.containsKey(temp) && !visited.contains(parentMap.get(temp))){
                    visited.add(parentMap.get(temp));
                    eleQueue.add(parentMap.get(temp));
                }
            }
        }

        while(!eleQueue.isEmpty()){
            ans.add(eleQueue.poll().data);
        }
    }
}
