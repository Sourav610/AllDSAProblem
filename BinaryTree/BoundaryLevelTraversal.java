package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
Given a Binary Tree, perform the boundary traversal of the tree. The boundary traversal is 
the process of visiting the boundary nodes of the binary tree in the anticlockwise direction, starting from the root.
*/
public class BoundaryLevelTraversal{
    public static void main(String[]args){
        Solution sol  = new Solution();
        Node root = sol.createNode();
        List<Integer>ans = new ArrayList<>();
        doBoundaryTraversal(root,ans);
        for(int i: ans){
            System.out.print(i+" ");
        }
    }

    /*
    for boundary level traversal - first we traverse left tree then leafNodes and then right tree in reverse order;
    T.C - O(N);
    S.C - O(N)
     */

    public static boolean isLeaf(Node temp){
        if(temp.left == null && temp.right == null){
            return true;
        }
        return false;
    }
    
    public static void doBoundaryTraversal(Node root, List<Integer>ans){
        if(root == null){
            return;
        }

        if(!isLeaf(root)){
            ans.add(root.data);
        }

        traverseLeft(root.left,ans);
        traverseLeafNode(root,ans);
        traverseRight(root.right,ans);
    }

    public static void traverseLeft(Node root, List<Integer>temp){
        Node curr = root;
        while(curr != null){
            if(!isLeaf(curr)){
                temp.add(curr.data);
            }

            if(curr.left != null){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
    }

    public static void traverseRight(Node root, List<Integer>temp){
        Node curr = root;
        List<Integer>ans = new ArrayList<>();
        while(curr != null){
            if(!isLeaf(curr)){
                ans.add(curr.data);
            }

            if(curr.right != null){
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }

        Collections.reverse(ans);
        for(int i: ans){
            temp.add(i);
        }
    }

    public static void traverseLeafNode(Node root, List<Integer>temp){
        if(isLeaf(root)){
            temp.add(root.data);
            return;
        }

        if(root.left != null){
            traverseLeafNode(root.left, temp);
        }
        if(root.right != null){
            traverseLeafNode(root.right, temp);
        }
        return;
    }
}