package SlidingWindowAndTwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*

Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

constrain : 1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length -- because of this the single pass will work because every value of num should be less the arr length

*/

public class SubarrayWithKDifferentInteger{
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
        // ans = calculateBruteForceSubarray(arr,k);
        // ans = calculateSubarray(arr,k) - calculateSubarray(arr,k-1);
        ans = subarraysWithKDistinct(arr,k);
        System.out.println("The total subarray with exectly "+k+" element: "+ans);
    }

    public static int calculateBruteForceSubarray(int[] arr, int k){
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            Map<Integer,Integer>mp = new HashMap();
            for(int j = i; j<arr.length; j++){
                mp.put(arr[j],mp.getOrDefault(arr[j], 0)+1);
                if(mp.size() > k){
                    break;
                }
                if(mp.size() == k){
                    count++;
                }
            }
        }
        return count;
    }

    /*
    Same approach used in CountNumberOfNiceSubaary class
     */

    public static int calculateSubarray(int[]arr, int k){
        int i = 0, j = 0, n = arr.length, count = 0;
        Map<Integer,Integer>mp = new HashMap<>();
        while(i<n){
            mp.put(arr[i], mp.getOrDefault(arr[i], 0)+1);
            while(mp.size() > k){
                mp.put(arr[j],mp.getOrDefault(arr[j], 0)-1);
                if(mp.get(arr[j]) == 0){
                    mp.remove(arr[j]);
                }
                j++;
            }
            count += i-j+1;
            i++;
        }
       return count;
    }

    /*
        same approach as above but in single pass
    */

        public static int subarraysWithKDistinct(int[] nums, int k) {
            // Array to store the count of distinct values encountered
            int[] distinctCount = new int[nums.length + 1];
    
            int totalCount = 0;
            int left = 0;
            int right = 0;
            int currCount = 0;
    
            while (right < nums.length) {
                // Increment the count of the current element in the window
                if (distinctCount[nums[right++]]++ == 0) {
                    // If encountering a new distinct element, decrement K
                    k--;
                }
    
                // If K becomes negative, adjust the window from the left
                if (k < 0) {
                    // Move the left pointer until the count of distinct elements becomes valid again
                    --distinctCount[nums[left++]];
                    k++;
                    currCount = 0;
                }
    
                // If K becomes zero, calculate subarrays
                if (k == 0) {
                    // While the count of left remains greater than 1, keep shrinking the window from the left
                    while (distinctCount[nums[left]] > 1) {
                        --distinctCount[nums[left++]];
                        currCount++;
                    }
                    // Add the count of subarrays with K distinct elements to the total count
                    totalCount += (currCount + 1);
                }
            }
            return totalCount;
        }

}