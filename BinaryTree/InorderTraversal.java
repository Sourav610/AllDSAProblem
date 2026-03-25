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

public class InorderTraversal{
    public static void main(String[] args) {
        Solution sol  = new Solution();
        Node root = sol.createNode();
        List<Integer>ans = new ArrayList<>();
        ans = inOrderTraversal(root);
        for (int val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static List<Integer> inOrderTraversal(Node root){
        Stack<Node>st1 = new Stack<>();
        List<Integer>ans = new ArrayList<Integer>();
        Node curr = root;
        while(!st1.empty() || curr != null){
            while(curr != null){
                st1.add(curr);
                curr = curr.left;
            }
            curr = st1.pop();
            ans.add(curr.data);
            curr = curr.right;
        }
        return ans;
        
    }
}