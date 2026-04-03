package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightandLeftViewBinaryTree {
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();

        // List<List<Integer>>ans = new ArrayList<>();

        // ans = levelOrderTraversal(root);

        // System.out.println("The left view of binary tree is: ");
        // for(List<Integer> ele: ans){
        //     System.out.print(ele.get(0)+" ");
        // }
        // System.out.println();
        // System.out.println("The right view of binary tree is: ");
        // for(List<Integer> ele: ans){
        //    System.out.print(ele.get(ele.size()-1)+" ");
        // }

        List<Integer>leftView = new ArrayList<>();
        List<Integer>rightView = new ArrayList<>(); 
        leftOrderDfs(root,0,leftView);
        rightOrderDfs(root,0,rightView);

        System.out.println("The left view of binary tree is: ");
        for(int i = 0; i<leftView.size(); i++){
            System.out.print(leftView.get(i)+" ");
        }

        System.out.println();
        System.out.println("The right view of binary tree is: ");
        for(int i = 0; i<rightView.size(); i++){
            System.out.print(rightView.get(i)+" ");
        }
        
    }

    /*
    T.C - O(n)
    S.c - O(n)
    */
    public static List<List<Integer>> levelOrderTraversal(Node root){
        List<List<Integer>>ans = new ArrayList<>();
        Queue<Node>eleQueue = new LinkedList<>();

        eleQueue.add(root);
        while(!eleQueue.isEmpty()){
            int eleSize = eleQueue.size();
            List<Integer>temp = new ArrayList<>();
            for(int i = 0; i<eleSize; i++){
                Node curr = eleQueue.poll();
                temp.add(curr.data);

                if(curr.left != null){
                    eleQueue.add(curr.left);
                }

                if(curr.right != null){
                    eleQueue.add(curr.right);
                }
            }
            ans.add(temp);
        }

        return ans;
    }


     /*
    T.C - O(n)
    S.c - O(h) h is the height of the tree
    */
    public static void leftOrderDfs(Node root, int level, List<Integer>ans){
        if(root == null){
            return;
        }

        if(ans.size() == level){
            ans.add(root.data);
        }

        leftOrderDfs(root.left, level+1, ans);
        leftOrderDfs(root.right, level+1, ans);
    }

    public static void rightOrderDfs(Node root, int level, List<Integer>ans){
        if(root == null){
            return;
        }

        if(ans.size() == level){
            ans.add(root.data);
        }

        rightOrderDfs(root.right, level+1, ans);
        rightOrderDfs(root.left, level+1, ans);
    }
}
