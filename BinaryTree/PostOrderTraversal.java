package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair{
    Node key;
    int val;

    Pair(Node key, int val){
        this.key = key;
        this.val = val;
    }

    Node getKey(){
        return key;
    }

    int getVal(){
        return val;
    }
}

public class PostOrderTraversal{
    public static void main(String[] args) {
        Solution sol  = new Solution();
        Node root = sol.createNode();
        List<Integer>ans = new ArrayList<>();
        ans = postOrderTraversal(root);
        for (int val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static List<Integer> postOrderTraversal(Node root){
        Stack<Integer>st1 = new Stack<>();
        
    }
}