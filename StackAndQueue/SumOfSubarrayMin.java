package StackAndQueue;
/*
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. 
 * Since the answer may be large, return the answer modulo 109 + 7.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class SumOfSubarrayMin {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter "+n+" element: ");
        int[]arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        // ans = findSumSubarrayMin(arr);
        ans = findSumSubarrayMin2(arr);
        // ans = findOptimizeSumSubarrayMin(arr);
        System.out.println("The ans is: "+ans);
    }

    /*
     * Brute force
     * T.C - O(n*n*n);
     * S.C - O(1);
     */
    public static int findSumSubarrayMin(int[]arr){
        int ans = 0; 
        int mod = (int)1e9+7;
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr.length -i; j++){
                int minVal = Integer.MAX_VALUE;
                for(int k = i; k<= i+j; k++){
                    minVal = Math.min(minVal,arr[k]);
                }

                ans = (ans%mod)+minVal;
            }
        }

        return ans;
    }

    /*
     * T.c - O(n^2);
     * S.C - O(1);
     */
    public static int findSumSubarrayMin2(int[]arr){
        int ans = 0;
        int mod = (int)1e9+7;
        int n = arr.length;
        for(int i = 0; i<n; i++){
            int minVal = arr[i];
            for(int j = i; j<n;j++){
                minVal = Math.min(minVal,arr[j]);
                ans = (ans + minVal)%mod;
            }
        }
        return ans;
    }

    /*
     * Approach:
     * first create two array left and right. left array will store index of prev min value of each element 
     * and right array will store next min or equal value of each element.
     * 
     * finally iterate over array and use below opertaion to calculate min value of the subarray
     * Once both left and right arrays are filled with proper indices, calculate the sum. By iterating over all indices i, 
     * find the product of the count of subarrays where arr[i] is the minimum
     *  ((i - left[i]) * (right[i] - i)) and arr[i]. This represents the sum of arr[i] for all i in its valid subarrays.
     * 
     * T.C - O(n);
     * S.C - O(n);
     */

    public static int findOptimizeSumSubarrayMin(int[]arr){
        int n = arr.length;
        int[]left = new int[n];
        int[]right = new int[n];
        Arrays.fill(left,-1);
        Arrays.fill(right,n);

        Stack<Integer>st = new Stack();

        for(int i = 0; i<n; i++){
            while(!st.empty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(!st.empty()){
                left[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();

        for(int i = n-1; i>= 0; i--){
            while(!st.empty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(!st.empty()){
                right[i] = st.peek();
            }
            st.push(i);
        }

        int mod = (int)1e9+7;
        long ans = 0;
        for(int i = 0; i<n; i++){
            ans += (long)(i-left[i])*(right[i]-i)%mod*arr[i]%mod;
            ans %= mod;
        }
        return (int)ans;
    }
}
