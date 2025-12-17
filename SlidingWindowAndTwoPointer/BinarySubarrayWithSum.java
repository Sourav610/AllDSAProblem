package SlidingWindowAndTwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array. 
*/
public class BinarySubarrayWithSum {
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
        /*
        to get sum == goal, we are subtracint (sum <= goal) - (sum <= goal-1)
         */
        ans = calculateSumWithGoal(arr,k)- calculateSumWithGoal(arr,k-1);
        System.out.println("The subarray with sum goal is: "+ans);
    }

    /*
        - Here we are calculating sum <= goal by two pointer. First pointer will add to sum if sum > goal second pointer will move to remove it
        and every time sum <= goal the number of subarray will be equal to the distance between first and second pointer. So we are adding this 
        to count to get total count;
    */

    public static int calculateSumWithGoal(int[]arr,int k){
        int j = 0;
        int sum = 0,count = 0;
        if(k< 0){
            return 0;
        }
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
            while(sum > k){
                sum -= arr[j];
                j++;
            }
            count += i-j+1;
        }
        return count;
    }
}
