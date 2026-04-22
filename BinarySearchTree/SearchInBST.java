package BinarySearchTree;

import javax.print.attribute.standard.RequestingUserName;

class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
    }
}
public class SearchInBST {
    public static void main(String[]args){
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        int target = 3;
        // Node ans = findInBST(root,target);
        Node ans = findInBSTRecursive(root, target);

        printInorderTraversal(ans);
    }


    //T.C - O(log N) , S.C - O(1)
    public static Node findInBST(Node temp,int target){
        while(temp != null && temp.val != target){
            if(temp.val > target){
                temp = temp.left;
            }
            else{
                temp = temp.right;
            }
        }
        return temp;
    }

    //T.C - O(log N) , S.C - O(log N)
    public static Node findInBSTRecursive(Node temp,int target){
        if(temp == null){
            return null;
        }
        if(temp.val == target){
            return temp;
        }
        if(temp.val > target){
            return findInBSTRecursive(temp.left, target);
        }
        else{
            return findInBSTRecursive(temp.right, target);
        }
    }

    public static void printInorderTraversal(Node ans){
        if(ans == null){
            return;
        }

        printInorderTraversal(ans.left);
        System.out.print(ans.val+" ");
        printInorderTraversal(ans.right);
    }
}
