package BinarySearchTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p
 and q as descendants (where we allow a node to be a descendant of itself).
*/

public class LCAInBST {
    public static void main(String[]args){
        Node root =new Node(8);
        root.left = new Node(5);
        root.right = new Node(12);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.left = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        Node ans = null;

        ans = findParentNode(root,4,7);
        System.out.println("The parent node is:"+ans.val);
        int val = findParentNodeIterative(root,4,7);

        System.out.println("The parent node is:"+val);
    }

    /*
      Recursive LCA Logic (Summary)
Start from the root and recursively search both left and right subtrees.
Base case:
If current node is NULL → return NULL
If current node is p or q → return current node

For each node:

Recursively search left subtree
Recursively search right subtree

After recursion:

If both left and right return non-null:
Current node has one target in left subtree and one in right subtree
So current node = LCA ✅
If only one side returns non-null:
Both nodes are in the same subtree
Return that non-null node upward
If both return NULL:
Neither node found
Return NULL
Core intuition
Each subtree tells its parent:
“I found p”
“I found q”
“I found nothing”
The first node that gets a non-null answer from both sides is the Lowest Common Ancestor.
    */

    public static Node findParentNode(Node root,int p, int q){
        if(root == null || root.val == p || root.val == q){
            return root;
        }

        Node left = findParentNode(root.left, p, q);
        Node right = findParentNode(root.right, p, q);

        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }

    /*
    Iterative LCA Logic (Summary)
Start from root and do DFS/BFS traversal.
Maintain a parent map:
child → parent
Keep traversing until both target nodes p and q are found.

After parent mapping is ready:

Start from node p
Move upward using parent pointers:
p → parent[p] → parent[parent[p]]...
Store all ancestors of p in a set.

Then:

Start from node q
Move upward using parent pointers.
At each step, check:
Is current node present in p's ancestor set?
The first node that matches = Lowest Common Ancestor.
Core intuition
One node’s ancestors are stored.
Move upward from the second node.
First common meeting point = LCA.
    */

    public static int findParentNodeIterative(Node root, Integer p, Integer q){
        if(root == null){
            return 0;
        }

        Map<Integer,Integer>mp = new HashMap<>();
        mp.put(root.val,null);
        Stack<Node>st = new Stack<>();
        st.push(root);

        while(!st.empty()){
            Node temp = st.pop();
            if(temp.left != null){
                mp.put(temp.left.val,temp.val);
                st.push(temp.left);
            }
            if(temp.right != null){
                mp.put(temp.right.val,temp.val);
                st.push(temp.right);
            }
        }

        Set<Integer>parent = new HashSet<>();
        while(p != null){
            parent.add(p);
            p = mp.get(p);
            
        }

        while(!parent.contains(q)){
           q = mp.get(q);
        }
        return q;
    }
}
