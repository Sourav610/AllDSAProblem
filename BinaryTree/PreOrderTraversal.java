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

public class PreOrderTraversal{
    public static void main(String[] args) {
        Solution sol  = new Solution();
        Node root = sol.createNode();
        List<Integer>ans = new ArrayList<>();
        ans = preOrderTraversal(root);
        for (int val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static List<Integer> preOrderTraversal(Node root){
        Stack<Node>st1 = new Stack<>();
        List<Integer>ans = new ArrayList<>();
        st1.add(root);
        while(!st1.isEmpty()){
            Node curr = st1.pop();
            if(curr != null){
                ans.add(curr.data);
                st1.add(curr.right);
                st1.add(curr.left);
            }
        }

        return ans;
    }
}