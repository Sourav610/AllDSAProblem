package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/*
Given a Binary Tree and a reference to a root belonging to it. Return the path from the root node to the given leaf node.
Note: No two nodes in the tree have the same data value and it is assured that the given node is present and a path always exists.
*/

public class RootToLeafBinaryTree {
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();

        List<String>ans = new ArrayList<>();
        // traverseAllLeaf(root,ans,"");
        // traverseToParticularLeaf(root,ans,"",1);
        // for(String i: ans){
        //     System.out.print(i+" ");
        // }
        List<Integer>res = new ArrayList<>();
        getPath(root,res,7);
        for(Integer i: res){
            System.out.print(i+" ");
        }
    }

    public static void traverseAllLeaf(Node root, List<String>ans, String temp){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            temp += Integer.toString(root.data);
            ans.add(temp);
        }
        else{
            temp += Integer.toString(root.data)+"->";
        }

        traverseAllLeaf(root.left, ans, temp);
        traverseAllLeaf(root.right, ans, temp);

    }


    // here temp is refence but string is immutable so that why it is working

    public static boolean traverseToParticularLeaf(Node root, List<String>ans,String temp, int target){
        if(root == null){
            return false;
        }

        temp += Integer.toString(root.data)+",";
        if(root.left == null && root.right == null){
            if(root.data == target){
                ans.add(temp);
                return true;
            }
            return false;
        }

        if(traverseToParticularLeaf(root.left, ans, temp, target)){
            return true;
        }
        if(traverseToParticularLeaf(root.right, ans, temp, target)){
            return true;
        }
        return false;
    }

    public static boolean getPath(Node root, List<Integer> arr, int x) {
        // Base case: If node is null
        if (root == null)
            return false;

        // Add current node to path
        arr.add(root.data);

        // If current node is the target
        if (root.data == x)
            return true;

        // Recurse into left and right children
        if (getPath(root.left, arr, x) || getPath(root.right, arr, x))
            return true;

        // Backtrack if not found
        arr.remove(arr.size() - 1);
        return false;
    }
}
