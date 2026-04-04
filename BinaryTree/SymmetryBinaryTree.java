package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

*/
public class SymmetryBinaryTree{
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();

        if(root == null){
            System.out.println("The tree is symmetric");
        }
        // System.out.println("is the tree symmetric: "+checkSymmetry(root.left,root.right));
        System.out.println("is the tree symmetric: "+checkSymmetryIterative(root.left,root.right));
    }

    // T.C - O(n), S.C - O(1)
    public static boolean checkSymmetry(Node temp1, Node temp2){
        if(temp1 == null || temp2 == null){
            return temp1 == temp2;
        }

        if(temp1.data == temp2.data){
            return checkSymmetry(temp1.left, temp2.right) && checkSymmetry(temp1.right, temp2.left);
        }
        return false;
    }

    // T.C - O(n), S.C - O(n)
    public static boolean checkSymmetryIterative(Node root1, Node root2){
        Queue<Node>q1 = new LinkedList<>();
        Queue<Node>q2 = new LinkedList<>();
        q1.add(root1);
        q2.add(root2);

        while(!q1.isEmpty() && !q2.isEmpty()){
            Node temp1 = q1.poll();
            Node temp2 = q2.poll();

            if(temp1.data != temp2.data){
                return false;
            }
            if(temp1 == null || temp2 == null){
                return temp1 == temp2;
            }

            q1.add(temp1.left);
            q1.add(temp1.right);
            q2.add(temp1.right);
            q2.add(temp2.left);
        }

        if(q1.size() == q2.size()){
            return true;
        }
        
        return false;
    }
}