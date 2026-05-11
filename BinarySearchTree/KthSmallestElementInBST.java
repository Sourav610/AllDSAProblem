package BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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


public class KthSmallestElementInBST {
    private static int k = 0;
    private static int result = -1;
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
        System.out.println("Enter the smallest num value you want: ");
        k = Integer.parseInt(br.readLine());
        int rem = k;

        // List<Integer>ans = new ArrayList<>();
        // findKSmallest(root,ans);
        // System.out.println("The smallest "+k+"th value is: "+ans.get(k-1));

        findKSmallestOptimize(root);
        System.out.println("The smallest "+rem+"th value is: "+result);

    }

    public static void findKSmallest(Node root, List<Integer>ans){
        if(root == null){
            return;
        }
        findKSmallest(root.left, ans);
        ans.add(root.val);
        findKSmallest(root.right, ans);
    }

    public static void findKSmallestOptimize(Node root){
        if(root == null){
            return;
        }
        findKSmallestOptimize(root.left);
        k--;
        if(k == 0){
            result = root.val;
            return;
        }
        findKSmallestOptimize(root.right);
    }


}
