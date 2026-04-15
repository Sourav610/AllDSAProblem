package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateBTWithInorderAndPreOrder{
    public static void main(String[]args){
        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {3, 9, 20, 15, 7};

        Map<Integer,Integer>mp = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            mp.put(inorder[i],i);
        }
        
        Node root = buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,mp);
        System.out.println("Inorder of Unique Binary Tree Created:");
        printInorder(root);

    }

    public static void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static buildTree(int[]preOrder,int preStart, int preEnd,int[]inOrder,int inStart, int inEnd,Map<Integer,Integer>mp){
        if(preStart> preEnd || inStart > inEnd){
            return null;
        }

        Node root = new Node(preOrder[preStart]);
        int inRoot = mp.get(root.data);
        int numLeft = inRoot - inStart;

        root.left = buildTree(preOrder,preStart+1, preStart+numLeft,inOrder,inStart,inRoot-1,mp);
        root.right = buildTree(preOrder,preStart+numLeft+1, preEnd,inOrder,inRoot+1,inEnd,mp);

        return root;
    }
}