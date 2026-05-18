package BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
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

/*
You are given the root of two BSTs, you have to merge this two BST and return the in-order traversal of the new BST.
*/

public class MergeTwoBST {
    public static void main(String[]args){
        Node root =new Node(8);
        root.left = new Node(5);
        root.right = new Node(12);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.left = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        Node root2 =new Node(10);
        root2.left = new Node(8);
        root2.right = new Node(12);
        root2.left.left = new Node(5);
        root2.left.right = new Node(9);
       
        List<Integer>ans1 = doInorderTraversal(root);
        List<Integer>ans2 = doInorderTraversal(root2);
        List<Integer>res = new ArrayList<>();

        // res.addAll(ans1);
        // res.addAll(ans2);
        // Collections.sort(res);

        //Merge using two pointer
        int i = 0,j = 0; 
        while(i<ans1.size() && j< ans2.size()){
            if(ans1.get(i)< ans2.get(j)){
                res.add(ans1.get(i));
                i++;
            }
            else{
                res.add(ans2.get(j));
                j++;
            }
        }

        while(i<ans1.size()){
            res.add(ans1.get(i));
            i++;
        }

        while(j<ans2.size()){
            res.add(ans2.get(j));
            j++;
        }

        System.out.println("The merged bst is : ");
        for(Integer val: res){
            System.out.print(val+" ");
        }


    }

    public static List<Integer> doInorderTraversal(Node root){
        Stack<Node>st = new Stack<>();
        List<Integer>ans = new ArrayList<>();
        Node curr = root;
        while(!st.empty() || curr != null){
            while(curr != null){
                st.add(curr);
                curr = curr.left;
            }
            curr = st.pop();
            ans.add(curr.val);
            curr = curr.right;
        }
        return ans;
    }
}
