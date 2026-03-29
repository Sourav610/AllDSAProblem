package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal{
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();

        List<List<Integer>>ans = new ArrayList<>();

        ans = traverseZigZag(root);
        for(List<Integer>it: ans){
            for(int i: it){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> traverseZigZag(Node root){
        Queue<Node>eleQueue = new LinkedList<>();
        eleQueue.add(root);
        boolean dir = false;
        List<List<Integer>>ans = new ArrayList<>();
        while(!eleQueue.isEmpty()){
            int size = eleQueue.size();
            List<Integer>temp = new ArrayList<>();
            for(int i = 0; i<size; i++){
                Node curr = eleQueue.poll();
                temp.add(curr.data);
                if(curr.left != null){
                    eleQueue.add(curr.left);
                }
                if(curr.right != null){
                    eleQueue.add(curr.right);
                }
            }
            if(dir == true){
                Collections.reverse(temp);
            }
            ans.add(temp);
            dir = !dir;
        }
        return ans;
    }
}