package SlidingWindowAndTwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.
*/

public class CountNumberOfNiceSubarray {
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
        
        better Explanation:
        A(k) = Set of subarrays that contain at most k odd numbers
        A(k−1) = Set of subarrays that contain at most k−1 odd numbers
        A(k−1) ⊆ A(k): The only subarrays that are in A(k) but not in A(k−1) are:
                Subarrays that have exactly k odd numbers

        A(k) − A(k−1) = Only subarrays with exactly k odd numbers
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
        int num = 0,count = 0;
        if(k< 0){
            return arr.length*(arr.length+1)/2; // formula of getting all subarray from an array
        }
        for(int i = 0; i<arr.length; i++){
            if(arr[i]%2 != 0){
                count++;
            }
            while(count > k){
               if(arr[j]%2 != 0){
                count--;
               }
               j++;
            }
            num += i-j+1;
        }
        return num;
    }
}
