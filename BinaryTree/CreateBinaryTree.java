package BinaryTree;

class Node{
    int data;
    Node left;
    Node right;

    Node(int key){
        data = key;
    }
}

class Solution{
    public Node createNode(){
        Node node = new Node(4);
        node.left = new Node(2);
        node.right = new Node(5);
        node.left.left = new Node(3);
        node.left.left.right = new Node(9);
        node.left.left.right.left = new Node(1);
        node.right.left= new Node(7);
        node.right.right = new Node(6);
        node.right.right.left  = new Node(8);
        return node;
    }
}
public class CreateBinaryTree {
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();
    }
}
