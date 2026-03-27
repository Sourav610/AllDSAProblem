package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BalanceBinaryTree{
    public static void main(String[] args) {
        Solution sol = new Solution();
        Node node = sol.createNode();
        boolean ans = false;
        // ans = checkBalanceTree(node);
        int val = checkBalanceTreeOptimize(node);
        if(val == -1){
            ans = false;
        }
        else{
            ans = true;
        }
        
        System.out.println("Is the tree balanced?: "+ans);
    }

    public static boolean checkBalanceTree(Node node){
        if(node == null){
            return true;
        }

        Queue<Node>eleQueue = new LinkedList<>();
        eleQueue.add(node);
        while(!eleQueue.isEmpty()){
            int size = eleQueue.size();
            for(int i = 0; i<size; i++){
                Node temp = eleQueue.poll();
                if(temp.left != null){
                    eleQueue.add(temp.left);
                }
                if(temp.right != null){
                    eleQueue.add(temp.right);
                }
                int left = calculateHeight(temp.left);
                int right = calculateHeight(temp.right);

                if(Math.abs(left-right) > 1){
                    return false;
                }

            }
        }

        return true;
    }

    //Using post order traversal to check for height at each node
    //Time complexity = O(n);
    //Space Complexity = O(1);
    public static int calculateHeight(Node temp){
        if(temp == null){
            return 0;
        }

        int left = calculateHeight(temp.left);
        int right = calculateHeight(temp.right);
        return Math.max(left,right)+1; 
    }

    public static int checkBalanceTreeOptimize(Node temp){
        if(temp == null){
            return 0;
        }

        int left = checkBalanceTreeOptimize(temp.left);
        int right = checkBalanceTreeOptimize(temp.right);
        if(Math.abs(left-right)>1 || left == -1 || right == -1){
            return -1;
        }
        return Math.max(left,right)+1;
    }
}