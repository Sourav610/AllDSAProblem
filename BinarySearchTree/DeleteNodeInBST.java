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

public class DeleteNodeInBST{
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

        printInorderTraversal(root);
        Node ans = deleteNode(root,10);
        System.out.println("After removing element: ");
        printInorderTraversal(ans);
    }

    public static void printInorderTraversal(Node ans){
        if(ans == null){
            return;
        }

        printInorderTraversal(ans.left);
        System.out.print(ans.val+" ");
        printInorderTraversal(ans.right);
    }

    /*
    To delete a node in bst we have some edge cases given below
    1. if key is root node then 
        - the root->left is null return right;
        - the root->right is null return left;
        - if both left and right null return null;
    2. if it is a leaf node then
    3. if it a node having only left child then return the left child and vice versa
    4. if it is a node having both child then
        - take any child subtree left/right and find the rightMostNode if taking left subtree, in that subtree and point the another subtree
        to the right of that found node.
    */
    public static Node deleteNode(Node root,int key){
        if(root == null){
            return null;
        }

        if(root.val == key){
            return findHelper(root);
        }

        Node curr = root;
        /* search the node and remove the element using helper function */
        while(curr != null){
            if(curr.val > key){
                if(curr.left != null && curr.left.val == key){
                    curr.left = findHelper(curr.left);
                    break;
                }
                else{
                    curr = curr.left;
                }
            }
            else{
                if(curr.right != null && curr.right.val == key){
                    curr.right = findHelper(curr.right);
                    break;
                }
                else{
                    curr = curr.right;
                }
            }
        }
        return root;
    }

    public static Node findHelper(Node root){
        if(root.left == null){
            return root.right;
        }
        else if(root.right == null){
            return root.left;
        }

        Node leftChild = root.left;
        Node lastLeftChild = findLeftMost(root.right);
        lastLeftChild.left = leftChild;
        return root.right;
    }

    public static Node findLeftMost(Node root){
        if(root.left == null){
            return root;
        }
        return findLeftMost(root.left);
    }
}