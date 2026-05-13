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

        Start by checking if the current root node is null or matches one of the target nodes (x or y). 
        If the root is null or matches either target node, return the root, as it could be the LCA or 
        simply indicate the end of the search path.
    Perform a recursive search in the left subtree to find nodes x and y by calling the LCA function on the left
     child of the current root.
    Similarly, perform a recursive search in the right subtree by calling the LCA function on the right 
    child of the current root.
    After completing the recursive searches, analyze the results of both subtree searches:
    If both recursive calls return non-null values, it means one target node was found in each subtree.
     In this case, the current root node must be the LCA, as it is the common ancestor of both nodes.
    If only one of the subtree searches returns a non-null result, 
    it implies both target nodes are located within the same subtree. 
    Return the non-null result, which represents the LCA found in that subtree.
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