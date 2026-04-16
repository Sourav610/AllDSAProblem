package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();
        List<Integer>ans = new ArrayList<>();
        
        ans = useMorrisTraversal(root);
        for(Integer it : ans){
            System.out.print(it+" ");
        }
    }


    /*
        Initialise a current to traverse the tree. Set current to the root of the Binary Tree.
    While the current is not null: If the current node has no left child,
     print the current node's value and move to the right child ie. set the current to its right child.
    If the current node has a left child, we find the in-order predecessor of the current node.
     This in-order predecessor is the rightmost node in the left subtree or the left subtree's rightmost node.
    If the right child of the in-order predecessor is null, set the right child to the current node. 
    Move to the left child (i.e., set current to its left child).
    If the right child of the in-order predecessor is not null, Revert the changes made
     in the previous step by setting the right child as null. Print the current node's value. Move to the right child (i.e., set current to its right child).
    Repeat until entire tree is not traversed.


    Time Complexity: O(2N), the time complexity is linear, as each node is visited at most 
    twice (once for establishing the temporary link and once for reverting it).
Space Complexity: O(1), the space complexity is constant, as the algorithm uses only a 
constant amount of extra space irrespective of the input size.

    */
    public static List<Integer> useMorrisTraversal(Node root){
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
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    ans.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }

}
