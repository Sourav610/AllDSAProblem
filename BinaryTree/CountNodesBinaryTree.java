package BinaryTree;

public class CountNodesBinaryTree{
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();

        int ans = 0;
        ans = countNodes(root);
        System.out.println("the number of nodes are: "+ans);
    }

    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return (left+right)+1;
    }
}