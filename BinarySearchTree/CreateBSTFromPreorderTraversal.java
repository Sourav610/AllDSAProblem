package BinarySearchTree;

import java.util.Stack;

/*
Given an array of integers preorder, which represents the preorder traversal of a BST
 (i.e., binary search tree), construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree with the 
given requirements for the given test cases.
*/

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

/*
Logic in points:
    Create root from first element.
    Push root into stack.
    For every next value:
    Create a new node.
    If value is smaller than stack top:
    It belongs to the left subtree.
    Attach as left child of stack top.
    Otherwise:
    It belongs somewhere in the right subtree.
    Keep popping until finding the correct parent.
    The last popped node becomes parent.
    Attach new node as right child.
    Push new node into stack for future comparisons.
    T.C - O(n), S.C - O(n)
 */

public class CreateBSTFromPreorderTraversal {
    public static void main(String[]args){
        int[]preorder = {8,5,1,7,10,12};
        // Node root = new Node(preorder[0]);
        // Stack<Node>st = new Stack<>();
        // st.push(root);
        // for(int i = 1; i<preorder.length; i++){
        //     Node node = new Node(preorder[i]);
        //     if(st.peek().val > preorder[i]){
        //         st.peek().left=  node;
        //     }
        //     else{
        //         Node parent = null;
        //         while(!st.empty() && st.peek().val < preorder[i]){
        //             parent = st.pop();
        //         }
        //         parent.right = node;
        //     }
        //     st.push(node);
        // }
        int[]index = {0};

        // Node root = createBST(preorder, index, Integer.MAX_VALUE);
        Node root = createBSTWithRange(preorder, index,Integer.MIN_VALUE, Integer.MAX_VALUE);

        System.out.println("The created binary tree is: ");
        inorderTraversal(root);
    }

    /*
    Start with first element as root.
        Keep an index to track current element.
        Keep an upperBound to know which values are allowed.
        Create node only if:
        index is valid
        current value ≤ upperBound
        Recursively build:
        Left subtree with upper bound = current node value
        Right subtree with old upper bound

        T.C - O(n), S.C - O(n)
    */

    public static Node createBST(int[]preOrder, int[] index, Integer upperBound){
        if(index[0] >= preOrder.length || preOrder[index[0]] > upperBound){
            return null;
        }

        Node root = new Node(preOrder[index[0]++]);
        root.left = createBST(preOrder, index, root.val);
        root.right = createBST(preOrder, index, upperBound);
        return root;
    }


    /*
     T.C - O(n), S.C- O(log n) , worst case s.c - O(n)
    */

    public static Node createBSTWithRange(int[]preOrder, int[] index, int minVal, int maxVal){
        if(index[0] >= preOrder.length){
            return null;
        }

        if(preOrder[index[0]] < minVal || preOrder[index[0]] > maxVal){
            return null;
        }
        Node root = new Node(preOrder[index[0]++]);
        root.left = createBSTWithRange(preOrder, index,minVal, root.val);
        root.right = createBSTWithRange(preOrder, index, root.val,maxVal);
        return root;
    }
    public static void inorderTraversal(Node root){
        Stack<Node>st = new Stack<>();
        Node curr = root;
        while(!st.empty() || curr != null){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            System.out.print(curr.val+" ");
            curr = curr.right;
        }
    }
}
