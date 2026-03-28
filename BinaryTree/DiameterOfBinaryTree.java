package BinaryTree;


/*
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
*/
public class DiameterOfBinaryTree{
    public static void main(String[] args) {
        Solution sol = new Solution();
        Node root = sol.createNode();
        int ans = 0;
        int diameter[] = new int[1];
        diameter[0] = 0;
        calculateDiameter(root,diameter);
        ans = diameter[0];
        System.out.println("The diameter of binary tree is: "+ans);
    }

    //Time complexity = O(n), Space complexity = O(n)
    public static int calculateDiameter(Node temp,int[]diameter){
        if(temp == null){
            return 0;
        }

        int left = calculateDiameter(temp.left, diameter);
        int right = calculateDiameter(temp.right, diameter);
        diameter[0] = Math.max(diameter[0],left+right);
        return Math.max(left,right)+1;
    }
}