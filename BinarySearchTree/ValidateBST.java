package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
    }
}

public class ValidateBST{
    public static void main(String[]args){
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        List<Integer>ans = new ArrayList<>();
        boolean res = true;
        doInOrderTraversal(root,ans);
        for(int i = 1; i<ans.size(); i++){
            if(ans.get(i-1) >= ans.get(i)){
                res= false;
                break;
            }
        }
        System.out.println("The bst is valid? "+res);
    }

    public static void doInOrderTraversal(Node root,List<Integer> ans){
        if(root == null){
            return;
        }
        doInOrderTraversal(root.left, ans);
        ans.add(root.val);
        doInOrderTraversal(root.right, ans);
    }
}