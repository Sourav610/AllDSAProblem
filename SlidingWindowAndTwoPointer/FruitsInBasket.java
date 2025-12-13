package SlidingWindowAndTwoPointer;
/*
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an 
integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. 
The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick. */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FruitsInBasket {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        System.out.println("Enter the length of array: ");
        n = Integer.parseInt(br.readLine());
        System.out.println("Enter "+n+" element: ");
        int []arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0; 
        ans = calculateMaxFruits(arr,n);
        System.out.println("The maximum no. of fruits are: "+ans);
    }

    /*
        Approach: while traversing putting the element in the map, if map size greater than 2 we will move 2nd pointer and finally store the size
        T.C - O(n);
        S.C - O(n)
    */

    public static int calculateMaxFruits(int[]arr, int n){
        Map<Integer,Integer>mp = new HashMap();
        int j = 0; 
        int maxCount = 0;
        for(int i = 0; i<n; i++){
            mp.put(arr[i],mp.getOrDefault(arr[i], 0)+1);
            while(mp.size() > 2){
                mp.put(arr[j],mp.getOrDefault(arr[j], 0)-1);
                if(mp.get(arr[j]) == 0){
                    mp.remove(arr[j]);
                }
                j++;
            }
            maxCount = Math.max(maxCount,i-j+1);
        }
        return maxCount;
    }
}
