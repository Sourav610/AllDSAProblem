package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;


/*
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions 
(row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each 
column index starting from the leftmost column and ending on the rightmost column. 
There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

Time Complexity: O(N * log²N * log²N * log²N), where N represents the number of 
nodes in the Binary Tree. Postorder traversal is performed using BFS with a time
 complexity of O(N), since each node is visited exactly once. Multiset operations 
 for inserting overlapping nodes at specific vertical and horizontal levels take O(log²N)
  time. Map operations involve insertion and retrieval of nodes using vertical and level 
  as keys. Since there are two nested maps, the total complexity becomes O(log²N * log²N).

Space Complexity: O(N + N/2), where N represents the number of nodes in the Binary Tree.
 The map storing nodes based on vertical and level information occupies O(N) space,
  as it stores all N nodes of the tree. The queue for BFS traversal occupies space
   proportional to the maximum number of nodes at any level, which can be O(N/2) in the worst case for a balanced tree.
 
*/
class NewPair{
    Node root;
    int row;
    int col;

    NewPair(Node root, int r, int c){
        this.root = root;
        this.row = r;
        this.col = c;
    }
}
public class VerticalOrderTraversal {
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();
        List<List<Integer>>ans = new ArrayList<>();
        ans = verticalTraversal(root);

        for(List<Integer> val: ans){
            for(int i: val){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> verticalTraversal(Node root){
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>mp = new TreeMap();
        Queue<NewPair>eleQueue = new LinkedList<>();
        eleQueue.add(new NewPair(root,0,0));

        while(!eleQueue.isEmpty()){
            NewPair curr = eleQueue.poll();
            Node temp = curr.root;
            int row = curr.row;
            int col = curr.col;

            mp.putIfAbsent(col,new TreeMap<>());
            mp.get(col).putIfAbsent(row,new PriorityQueue<>());
            mp.get(col).get(row).offer(temp.data);

            if(temp.left != null){
                eleQueue.add(new NewPair(temp.left,row+1,col-1));
            }

            if(temp.right != null){
                eleQueue.add(new NewPair(temp.right, row+1,col+1));
            }
        }

        List<List<Integer>>ans = new ArrayList<>();

        for(TreeMap<Integer,PriorityQueue<Integer>> val : mp.values()){
            List<Integer>col = new ArrayList();
            for(PriorityQueue<Integer> pq: val.values()){
                while(!pq.isEmpty()){
                    col.add(pq.poll());
                }
            }

            ans.add(col);
        }
        return ans;
    }
}
