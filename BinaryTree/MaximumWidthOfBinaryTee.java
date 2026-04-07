package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTee{
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();
        int ans = 0;
        ans = calculateWidthBinaryTree(root);
        System.out.println("The width of Binary tree is: "+ans);
    }

    /*
        using index to keeping each node index and calculating child index basis on their parent index like below
        left child = 2* parent+1
        right child = 2*parent+2
        and finally on that level taking the first and last index and calculating the width = (right-left+1);
        for each and taking the maximum

        T.C - O(n)
        S.C - O(n)
    */

    public static int calculateWidthBinaryTree(Node root){
        int maxWidth = 0;
        Queue<Pair>elQueue = new LinkedList<>();
        elQueue.add(new Pair(root,0));
        while(!elQueue.isEmpty()){
            int size = elQueue.size();
            int first = 0, last = 0;
            for(int i = 0; i<size; i++){
                Pair temp = elQueue.poll();
                Node curr = temp.getKey();
                if(i == 0){
                    first = temp.getVal();
                }
                if(i == size-1){
                    last = temp.getVal();
                }

                if(curr.left != null){
                    elQueue.add(new Pair(curr.left, 2*temp.getVal()+1));
                }
                if(curr.right != null){
                    elQueue.add(new Pair(curr.right,2*temp.getVal()+2));
                }
            }

            maxWidth = Math.max(maxWidth,(last-first+1));
        }
        return maxWidth;
    }
}