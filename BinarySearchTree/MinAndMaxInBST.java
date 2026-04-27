package BinarySearchTree;

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

public class MinAndMaxInBST{
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

        int ans = findMin(root);
        System.out.println("The minimum value in binary search Tree is: "+ans);
        ans = findMax(root);
        System.out.println("The maximum value in binary Search Tree is: "+ans);

    }

    public static int findMin(Node root){
        Node curr = root;
        while(curr.left != null){
            curr = curr.left;
        }

        return curr.val;
    }

    public static int findMax(Node root){
        Node curr = root;
        while(curr.right != null){
            curr = curr.right;
        }
        return curr.val;
    }
}