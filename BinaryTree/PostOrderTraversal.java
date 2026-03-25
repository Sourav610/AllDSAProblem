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
        Stack<Node>st1 = new Stack<>();
        Stack<Node>st2 = new Stack<>();
        List<Integer>ans = new ArrayList<Integer>();

        st1.add(root);
        while(!st1.empty()){
            Node curr = st1.pop();
            if(curr != null){
                st1.push(curr.left);
                st1.push(curr.right);
                st2.push(curr);
            }
        }

        while(!st2.empty()){
            Node curr = st2.pop();
            if(curr != null){
                ans.add(curr.data);
            }
        }
        return ans;
    }
}