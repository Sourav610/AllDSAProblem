package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreorderTraversal{
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();
        List<Integer>ans = new ArrayList<>();
        ans = doMorrisTraversal(root);
        for(Integer it: ans){
            System.out.print(it+" ");
        }
    }

    /*
        Morris Preorder Traversal is a tree traversal algorithm aiming to achieve a space complexity of O(1) 
        without recursion or an external data structure. The algorithm should efficiently visit each node in 
        the binary tree in preorder sequence, printing or processing the node values as it traverses, 
        without using a stack or recursion.

        T.C - O(n)
        S.C - O(1)
    */
    public static List<Integer> doMorrisTraversal(Node root){
        List<Integer>ans = new ArrayList<>();
        Node curr = root;

        while(curr != null){
            if(curr.left == null){
                ans.add(curr.data);
                curr = curr.right;
            }
            else{
                Node prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }

                if(prev.right == null){
                    ans.add(curr.data);
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }

        return ans;
    }
    
}