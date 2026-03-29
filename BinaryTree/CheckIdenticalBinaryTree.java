package BinaryTree;

import java.util.Stack;

/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
*/
public class CheckIdenticalBinaryTree{
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root1 = sol.createNode();
        Node root2 = sol.createNode();

        boolean ans = false;
        // ans = checkIdenticalTree(root1,root2);
        ans = checkIdenticalTreeIterative(root1, root2);
        System.out.println("Are the trees identical: "+ans);
    }

    public static boolean checkIdenticalTree(Node temp1, Node temp2){
        if(temp1 == null && temp2 == null){
            return true;
        }

        if(temp1 == null || temp2 == null){
            return false;
        }

        if(temp1.data != temp2.data){
            return false;
        }

        boolean left = checkIdenticalTree(temp1.left, temp2.left);
        boolean right = checkIdenticalTree(temp1.right, temp2.right);

        return left && right;
    }

    public static boolean checkIdenticalTreeIterative(Node temp1, Node temp2){
        Stack<Node>st1 = new Stack<>();
        Stack<Node>st2 = new Stack<>();
        st1.push(temp1);
        st2.push(temp2);

        while(st1.isEmpty() || st2.isEmpty()){
            Node ele1 = st1.pop();
            Node ele2 = st2.pop();
            if(ele1 != null && ele2 != null){
                st1.push(ele1.right);
                st2.push(ele2.right);
                if(ele1.data != ele2.data){
                    return false;
                }
                st1.push(ele1.left);
                st2.push(ele2.left);
            }
            else if(ele1 == null && ele2 == null){
                continue;
            }
            else{
                return false;
            }

        }
        return true;
    }
}