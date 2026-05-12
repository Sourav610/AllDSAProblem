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

        res = validateBSTUsingMinMax(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
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

    //in this approach when going left the left value should not be greater than the curr val
    //when going right the right val should not be less than the curr val
    public static boolean validateBSTUsingMinMax(Node root, int min, int max){
        if(root == null){
            return true;
        }

        if(root.val<= min || root.val >= max){
            return false;
        }

        return validateBSTUsingMinMax(root.left, min, root.val) && validateBSTUsingMinMax(root.right, root.val, max);
    }
}