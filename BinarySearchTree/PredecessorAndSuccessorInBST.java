package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

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


public class PredecessorAndSuccessorInBST {
    public static void main(String[]args){
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        Node[] pre = new Node[1];
        Node[] suc = new Node[1];
        // usingPreorderTraversal(root, pre,suc,4);
        // findPreAndSucInBST(root, pre,suc, 4);
        // pre[0] = findPredecessor(root, 4);
        // suc[0] = findSuccessor(root, 4);
        findPreSuc(root, pre, suc, 7);
        System.out.println("The predecessor and successor of bst is: "+pre[0].val+" "+suc[0].val);
    }

    /*
     using preorder traversal
     T.C - O(n), S.C - O(1)
    */

    public static void usingPreorderTraversal(Node root, Node[]pre, Node[]suc, int key){
        if(root == null)return;

        if(root.val < key && (pre[0] == null || pre[0].val < root.val)){
            pre[0] = root;
        }

        if(root.val > key && (suc[0] == null || suc[0].val > root.val)){
            suc[0] = root;
        } 

        usingPreorderTraversal(root.left, pre, suc, key);
        usingPreorderTraversal(root.right, pre, suc, key);
    }

    /*
    Using two traversal
    T.C - O(h) h - height of tree, S.C - O(1)
    */

    public static Node findPredecessor(Node root, int key){
        Node predecessor = null;
        while(root != null){
            if(root.val < key){
                predecessor = root;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return predecessor;
    }

    public static Node findSuccessor(Node root, int key){
        Node successor = null;
        while(root != null){
            if(root.val > key){
                successor = root;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return successor;
    }

    /*
    using single pass
    */

    public static void findPreSuc(Node root, Node[]pre, Node[]suc, int key){
        while(root != null){
            if(root.val > key){
                suc[0] = root;
                root = root.left;
            }
            else if(root.val < key){
                pre[0] = root;
                root = root.right;
            }
            else{
                if(root.left != null){
                    pre[0] = rightMost(root.left);
                }
                if(root.right != null){
                    suc[0] = leftMost(root.right);
                }
                break;
            }
        }
    }

    public static Node rightMost(Node temp){
        while(temp.right != null){
            temp = temp.right;
        }
        return temp;
    }

    public static Node leftMost(Node temp){
        while(temp.left != null){
            temp = temp.left;
        }
        return temp;
    }
    public static void findPreAndSucInBST(Node root, Node[] pre, Node[] suc, int key){
        Queue<Node>ele = new LinkedList<>();
        ele.add(root);
        helper(root, pre, suc, key);

        while(!ele.isEmpty()){
            int size = ele.size();
            for(int i = 0; i<size; i++){
                Node temp = ele.poll();
                if(temp.left != null){
                    helper(temp.left, pre, suc, key);
                    ele.add(temp.left);
                }
                if(temp.right != null){
                    helper(temp.right, pre, suc, key);
                    ele.add(temp.right);
                }
            }
        }
    }

    public static void helper(Node curr, Node[] pre, Node[] suc, int key){
        if(curr.val > key){
            if(suc[0] != null){
                if(suc[0].val > curr.val){
                    suc[0] = curr;
                }
            }
            else{
                suc[0] = curr;
            }
        }
        else if(curr.val < key){
            if(pre[0] != null){
                if(pre[0].val < curr.val){
                    pre[0] = curr;
                }
            }
            else{
                pre[0] = curr;
            }
        }
    }
}
