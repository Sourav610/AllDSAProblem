package BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


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


public class InsertValInBST {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root =new Node(8);
        root.left = new Node(5);
        root.right = new Node(12);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.left = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        System.out.println("Enter the value to be insert in bst: ");
        int val = Integer.parseInt(br.readLine());
        root = insertInBST(root,val);
        printInorderTraversal(root);

    }

    public static void printInorderTraversal(Node ans){
        if(ans == null){
            return;
        }

        printInorderTraversal(ans.left);
        System.out.print(ans.val+" ");
        printInorderTraversal(ans.right);
    }

    public static Node insertInBST(Node root, int val){
        Node node= new Node(val);
        if(root == null){
            return node;
        }

        Node curr = root;
        Node prev = curr;
        while(curr != null){
            if(curr.val > val){
                prev = curr;
                curr = curr.left;
            }
            else{
                prev = curr;
                curr = curr.right;
            }
        }

        if(prev.val > val){
            prev.left = node;
        }
        else{
            prev.right = node;
        }

        return root;
    }
}
