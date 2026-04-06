package BinaryTree;

/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined 
between two nodes p and q as the lowest node in T that has both p and q as descendants
 (where we allow a node to be a descendant of itself).”
  */

public class LCABinaryTree{
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();

        Node ans = null;
        Node p = root.left;
        Node q = root.right;

        ans = traverseBT(root,p,q);
        System.out.println("The lca of p and q is: "+ans.data);
    }

    /*
    T.C - O(n), S.c - O(H)
    */
    public static Node traverseBT(Node root,Node p, Node q){
        if(root == null || root == p || root == q){
            return root;
        }

        Node left = traverseBT(root.left, p, q);
        Node right = traverseBT(root.right, p, q);

        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}