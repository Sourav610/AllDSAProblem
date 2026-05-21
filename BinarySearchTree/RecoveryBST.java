package BinarySearchTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake.
 Recover the tree without changing its structure.
*/

class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val  = val;
        left = null;
        right = null;
    }
}

public class RecoveryBST {
    public static void main(String[] args) {
        Node root =new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);
        root.left.left = new Node(5);
        root.left.right = new Node(7);
        root.left.right.left = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        System.out.println("Element before recovering: ");
        printInorderTraversal(root);
        List<Integer>ans = new ArrayList<>();
        doInorderTraversal(root,ans);
        
        Collections.sort(ans);
        Stack<Node>st = new Stack<>();
        Node curr = root;
        int i = 0;
        while(!st.empty() || curr != null){
            while(curr != null){
                st.add(curr);
                curr = curr.left;
            }

            curr = st.pop();
            curr.val = ans.get(i);
            i++;
            curr = curr.right;
        }
        System.out.println("Element after recovering: ");
        printInorderTraversal(root);
    }

    public static void doInorderTraversal(Node root, List<Integer>ans){
        if(root == null){
            return ;
        }

        doInorderTraversal(root.left, ans);
        ans.add(root.val);
        doInorderTraversal(root.right, ans);

    }

    public static void printInorderTraversal(Node root){
        if(root == null){
            return ;
        }

        printInorderTraversal(root.left);
        System.out.print(root.val+" ");
        printInorderTraversal(root.right);

    }
}
