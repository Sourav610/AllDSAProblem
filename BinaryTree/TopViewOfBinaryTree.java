package BinaryTree;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/*
Given a Binary Tree, return its Top View. The Top View of a Binary Tree
 is the set of nodes visible when we see the tree from the top.
*/
public class TopViewOfBinaryTree{
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();

        List<Integer>ans = new ArrayList<>();
        ans = traverseTopView(root);
        for(int i: ans){
            System.out.print(i+" ");
        }
    }

    /*
        Time Complexity: O(N) where N is the number of nodes in the Binary Tree. 
        This complexity arises from visiting each node exactly once during the BFS traversal.

        Space Complexity: O(N/2 + N/2) where N represents the number of nodes in the Binary Tree.
        The main space consuming data structure is the queue used for BFS traversal.
         It acquires space proportional to the number of nodes in the level it is exploring hence 
         in the worst case of a balanced binary tree, the queue will have at most N/2 nodes which is 
         the maximum width.Additionally, the map is used to store the top view nodes based on their vertical
          positions hence its complexity will also be proportional to the greatest width level.
           In the worst case, it may have N/2 entries as well.
    */
    public static List<Integer>traverseTopView(Node root){
        List<Integer>ans = new ArrayList<Integer>();
        if(root == null){
            return ans;
        }

        TreeMap<Integer,Integer>mp = new TreeMap<>();
        Queue<SimpleEntry<Node,Integer>>eleQueue = new LinkedList<>();
        eleQueue.add(new SimpleEntry(root, 0));
        while(!eleQueue.isEmpty()){
            AbstractMap.SimpleEntry<Node,Integer>temp = eleQueue.poll();
            Node curr = temp.getKey();
            int col= temp.getValue();
            if(!mp.containsKey(col)){
                mp.put(col,curr.data);
            }

            if(curr.left != null){
                eleQueue.add(new SimpleEntry<>(curr.left,col-1));
            }

            if(curr.right != null){
                eleQueue.add(new SimpleEntry<>(curr.right,col+1));
            }
        }

        for(Integer i: mp.values()){
            ans.add(i);
        }
        return ans;
    }
}