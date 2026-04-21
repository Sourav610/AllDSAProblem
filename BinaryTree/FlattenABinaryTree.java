package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class FlattenABinaryTree{
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();

        Node curr = root;
        //using extra space - T.C - O(n), s.c - O(n)
        // List<Node>ans = new ArrayList<>();
        // preOrderTraversal(ans,curr);
        // root.left = null;
        // root.right = null;
        // curr = root;
        // for(Node n: ans){
        //     curr.right = n;
        //     curr = curr.right;
        // }

        //Inplace algorithm - T.C - o(n), S.c - O(1)
        while(curr != null){
            if(curr.left != null){
                Node prev = curr.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
        printInorderTraversal(root);
    }

    public static void preOrderTraversal(List<Node>ans,Node root){
        if(root == null){
            return;
        }
        ans.add(root);
        preOrderTraversal(ans, root.left);
        preOrderTraversal(ans, root.right);
        root.left = null;
        root.right = null;
    }

    public static void printInorderTraversal(Node root){
        if(root == null){
            return;
        }
        printInorderTraversal(root.left);
        System.out.print(root.data+" ");
        printInorderTraversal(root.right);
        return;
    }
}