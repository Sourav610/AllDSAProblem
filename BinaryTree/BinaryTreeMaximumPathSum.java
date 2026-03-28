package BinaryTree;

/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the 
sequence has an edge connecting them. A node can only appear in the sequence at most once. 
Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.
*/
public class BinaryTreeMaximumPathSum{
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();
        int ans = 0;
        int length[] = new int[1];
        length[0] = Integer.MIN_VALUE;
        calculateMaxPath(root,length);
        ans = length[0];
        System.out.println("the maximum path value is: "+ans);
    }

    public static int calculateMaxPath(Node root,int[] length){
        if(root == null){
            return 0;
        }

        int left = Math.max(0,calculateMaxPath(root.left, length));
        int right = Math.max(0,calculateMaxPath(root.right, length));
        length[0] = Math.max(length[0],left+right+root.data);
        return Math.max(left,right)+root.data;
    }
}