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

class NodeValue{
    int minVal, maxVal, ans;

    NodeValue(int minVal, int maxVal, int ans){
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.ans = ans;
    }
}

public class MaximumSumBST{
    public static int maxValue;
    public static void main(String[] args) {
        Node root =new Node(8);
        root.left = new Node(13);
        root.right = new Node(12);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.left = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        maxValue = 0;
        findMaxSumBST(root);

        System.out.println("The maximum sum of a bst is: "+maxValue);
    }

    /*
    Use postorder traversal (Left → Right → Root).
        For each subtree, return:
        minVal = minimum value in the subtree.
        maxVal = maximum value in the subtree.
        ans = sum of the subtree if it is a BST.
        For a null node:
        Return (min = +∞, max = -∞, sum = 0).
        Recursively get information from the left and right subtrees.
        Check if the current subtree is a BST:
        left.maxVal < root.val < right.minVal
        If it is a BST:
        Calculate sum = root.val + left.ans + right.ans.
        Update global maximum sum.
        Return:
        minVal = min(root.val, left.minVal)
        maxVal = max(root.val, right.maxVal)
        ans = sum
        If it is not a BST:
        Return (min = -∞, max = +∞) to invalidate all ancestors.
        Return the larger sum of the left or right subtree.
        The global variable maxValue always stores the maximum BST sum found so far.

        T.C - O(n), S.C - O(H) H - height of tree
    */

    public static NodeValue findMaxSumBST(Node root){
        if(root == null){
            return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }

        NodeValue left = findMaxSumBST(root.left);
        NodeValue right = findMaxSumBST(root.right);

        if(left.maxVal < root.val && root.val < right.minVal){
            int calc = root.val + left.ans+right.ans;
            maxValue  = Math.max(maxValue,calc);
            return new NodeValue(Math.min(root.val,left.minVal), Math.max(root.val, right.maxVal), calc);
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.ans,right.ans));
    }
}