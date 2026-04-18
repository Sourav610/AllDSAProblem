package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class CreateBTWithInorderAndPostOrder{
    public static void main(String[]args){
        int[]postorder = {40, 50, 20, 60, 30, 10};
        int[]inorder = {40, 20 , 50, 10, 60, 30};
        Map<Integer,Integer>mp= new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            mp.put(inorder[i],i);
        }
        Node root = null;
        // root = createBT(postorder,inorder,mp);
        root = buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,mp);
        inorderTraversal(root);
    }

    public static Node buildTree(int[]postorder,int postStart,int postEnd,int[]inorder,int inStart,int inEnd,Map<Integer,Integer>mp){
        if(postStart > postEnd || inStart > inEnd){
            return null;
        }

        Node root = new Node(postorder[postEnd]);
        int rootInd  = mp.get(postorder[postEnd]);
        int leftSubTreeSize = rootInd-inStart;
        root.left = buildTree(postorder, postStart, postStart+leftSubTreeSize-1, inorder, inStart, rootInd-1, mp);
        root.right = buildTree(postorder, postStart+leftSubTreeSize, postEnd-1, inorder, rootInd+1, inEnd, mp);
        return root;
    }

    public static Node createBT(int[]postorder,int[]inorde,Map<Integer,Integer>mp){
        Node root = new Node(postorder[postorder.length-1]);
        for(int i = postorder.length-2; i>= 0; i--){
            Node curr = root;
            Node prev = null;

            while(curr != null){
                if(mp.get(postorder[i])> mp.get(curr.data)){
                    prev = curr;
                    curr = curr.right;
                }
                else{
                    prev = curr;
                    curr = curr.left;
                }
            }
            
            Node ele = new Node(postorder[i]);
            if(mp.get(prev.data) > mp.get(ele.data)){
                prev.left = ele;
            }
            else{
                prev.right = ele;
            }
        }

        return root;
        
    }

    public static void inorderTraversal(Node root){
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data+" ");
        inorderTraversal(root.right);
    }
}