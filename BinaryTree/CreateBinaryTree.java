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
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.right = new Node(5);
        return node;
    }
}
public class CreateBinaryTree {
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();
    }
}
