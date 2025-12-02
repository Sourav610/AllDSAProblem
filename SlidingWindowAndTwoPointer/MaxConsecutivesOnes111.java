package SlidingWindowAndTwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
*/
public class MaxConsecutivesOnes111 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        System.out.println("Enter the size of an array: ");
        n = Integer.parseInt(br.readLine());
        int[]arr = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the value of k: ");
        k = Integer.parseInt(br.readLine());

        int ans = 0;
        ans = findConsecutiveOnes(arr,k);
        System.out.println("The maximum number of consecutives ones are: "+ans);
    }

    /*
    T.C - O(n)
    S.c - O(1)
    */

    public static int findConsecutiveOnes(int[]arr, int k){
        int maxCount = Integer.MIN_VALUE;
        int zeroCount = 0;
        int j = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == 0){
                zeroCount++;
            }

            while(zeroCount > k){
                if(arr[j] == 0){
                    zeroCount--;
                }
                j++;
            }
            maxCount = Math.max(maxCount,i-j+1);
        }
        return maxCount;
    }
}
