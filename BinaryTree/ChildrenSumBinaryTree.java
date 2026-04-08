package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class ChildrenSumBinaryTree{
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();
        calculateChildrenSum(root);
        List<List<Integer>>ans = new ArrayList<>();
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        ans = levelOrderTraversal.levelOrderTraverse(root);
        for(List<Integer>ls : ans){
            for(Integer i: ls){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    /*
    Only node values can be increased; decreasing is not allowed. Tree structure stays fixed.
    Bottom-up adjustment fails when child sum is more than the parent, since we can't reduce parent.
    If children sum is less than the node, we increase children's values recursively to match.
    Use recursion to visit every node and check the Children Sum Property at each level.
    Compare this sum with the parent value and adjust accordingly.
    If children ≥ node, update node to match child sum.
    If children < node, update one child to match parent (since we can't decrease).
    After processing both children, update node value to final left + right sum.

    T.C - O(n)
    S.C - O(n) - this is beacuse at one time the call stack keep all function operation in a stack  like this   
    call stack like:
    changeTree(1)
    → changeTree(2)
      → changeTree(3)
        → changeTree(4)
    */

    public static void calculateChildrenSum(Node root){
        if(root == null){
            return;
        }

        int childSum = 0;
        if(root.left != null){
            childSum += root.left.data;
        }
        if(root.right != null){
            childSum += root.right.data;
        }

        if(childSum >= root.data){
            root.data = childSum;
        }
        else{
            if(root.left != null){
                root.left.data = root.data;
            }
            else if(root.right != null){
                root.right.data = root.data;
            }
        }

        calculateChildrenSum(root.left);
        calculateChildrenSum(root.right);

        int total = 0;
        if(root.left != null){
            total += root.left.data;
        }
        if(root.right != null){
            total += root.right.data;
        }

        if(root.left != null || root.right != null){
            root.data = total;
        }
    }
}