package BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

public class TwoSumInBST {
    public static void main(String[]args) throws IOException{
        Node root =new Node(8);
        root.left = new Node(5);
        root.right = new Node(12);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.left = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the target value: ");
        int k = Integer.parseInt(br.readLine());
        List<Integer>ans = new ArrayList<>();
        ans = doInorderTraversal(root);

        int i = 0, j = ans.size()-1;
        boolean check = false;
        while(i<j){
            int sum = ans.get(i)+ans.get(j);
            if(sum == k){
                check = true;
                break;
            }
            else if(sum < k){
                i++;
            }
            else{
                j--;
            }
        }

        System.out.println("the sum of two element equal to "+k+" is exist?: "+check);
    }

    public static List<Integer> doInorderTraversal(Node root){
        Stack<Node>st = new Stack();
        Node curr = root;
        List<Integer>ans = new ArrayList<Integer>();

        while(!st.isEmpty() || curr != null){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            ans.add(curr.val);
            curr = curr.right;
        }
        return ans;
    }
}
