package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution sol = new Solution();
        Node node = sol.createNode();
        int ans = 0;
        ans = calculateMaxDepth(node);
        System.out.println("The maximum depth of binary tree: "+ans);
    }

    public static int calculateMaxDepth(Node temp){
        Queue<Node>eleQueue = new LinkedList<>();
        int size = 0, length = 0;
        eleQueue.add(temp);
        if(temp == null){
            return 0;
        }
        while(!eleQueue.isEmpty()){
            size = eleQueue.size();
            length++;
            for(int i = 0; i<size; i++){
                Node curr = eleQueue.poll();
                if(curr.left != null){
                    eleQueue.add(curr.left);
                }
                if(curr.right != null){
                    eleQueue.add(curr.right);
                }
            }
            
        }
        return length;
    }
}