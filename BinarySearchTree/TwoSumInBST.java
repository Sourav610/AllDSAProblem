package BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
The previous approach uses O(N) space complexity which can be eliminated by leveraging the properties of a Binary Search Tree instead. 
As a prerequisite for this problem, make sure you are thorough with the concepts of Binary Search Tree Iterator. 
This BSTIterator class allows one to access the next and previous elements (in order predecessor and successor) in a BST.

Using the BSTIterator class implementation, initialise pointers 'i' and 'j' to the first and last elements of the BST's inorder traversal, 
respectively. These pointers are navigated through the BST using the next() and before() functions of the BSTIterator.
 The 'i' pointer progresses towards larger values with next(), while 'j' moves towards smaller values with before().
 This approach leverages on the BST properties to efficiently navigate through the elements and identify the pair satisfying the given sum without using any additional data structure to store the inorder traversal.

Initialise pointers ‘i’ and ‘j’ to the first and last elements of the BST’s inorder traversal using the BSTIterator class.
Utilise next() function to advance pointer ‘i’ towards larger values and the before() function to navigate ‘j’ 
towards smaller values within the BST.
If the sum of the values at these pointers is less than the target, increment the ‘i’ pointer. This will move towards larger values.
If the sum is greater than the target, decrement the ‘j’ pointer. This will move towards smaller values.
If the sum is equal to the target, return true.

*/
class BSTIterator{
    private Stack<Node>st;
    private boolean reverse;

    BSTIterator(Node root, boolean isReverse){
        st = new Stack<>();
        reverse = isReverse;
        pushAll(root);
    }

    boolean hasNext(){
        return !st.isEmpty();
    }

    int next(){
        Node tmpNode = st.pop();
        
        if(!reverse){
            pushAll(tmpNode.right);
        }
        else{
            pushAll(tmpNode.left);
        }

        return tmpNode.val;
    }

    private void pushAll(Node node){
        while(node != null){
            st.push(node);
            if(reverse){
                node = node.right;
            }
            else{
                node = node.left;
            }
        }
    }
}
public class TwoSumInBST {
    public static void main(String[]args) throws IOException{
        Node root =new Node(8);
        root.left = new Node(5);
        root.right = new Node(12);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.left = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the target value: ");
        int k = Integer.parseInt(br.readLine());
        boolean check = false;
        // List<Integer>ans = new ArrayList<>();
        // ans = doInorderTraversal(root);

        // int i = 0, j = ans.size()-1;
        
        // while(i<j){
        //     int sum = ans.get(i)+ans.get(j);
        //     if(sum == k){
        //         check = true;
        //         break;
        //     }
        //     else if(sum < k){
        //         i++;
        //     }
        //     else{
        //         j--;
        //     }
        // }

        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();

        while(i<j){
            if(i+j == k){
                check = true;
                break;
            }
            else if(i+j < k){
                i = l.next();
            }
            else{
                j = r.next();
            }
        }

        System.out.println("the sum of two element equal to "+k+" is exist?: "+check);
    }



    public static List<Integer> doInorderTraversal(Node root){
        Stack<Node>st = new Stack();
        Node curr = root;
        List<Integer>ans = new ArrayList<Integer>();

        while(!st.isEmpty() || curr != null){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            ans.add(curr.val);
            curr = curr.right;
        }
        return ans;
    }
}
