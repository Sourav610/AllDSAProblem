package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal{
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();

        List<List<Integer>>ans  = new ArrayList<>();
        ans = levelOrderTraverse(root);
        for(List<Integer> val: ans){
            for(int i :val){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrderTraverse(Node root){
        Queue<Node>queue = new LinkedList<>();
        List<List<Integer>>ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer>temp = new ArrayList<>();
            for(int i = 0; i<size; i++){
                Node node = queue.poll();
                temp.add(node.data);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            ans.add(temp);
        }
        return ans;
    }   
}