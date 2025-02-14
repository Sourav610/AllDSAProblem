package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * Given an array arr containing both positive and negative integers, the task is to compute the length of the largest subarray that has a sum of 0.
 */
public class LongestSubarrayWithSumZero {
     public static void main(String []args) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        System.out.print("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        // ans = LongestSubarray(arr);

        //optimized approach
        /*
         * First, let us initialize a variable say sum = 0 which stores the sum of elements traversed so far and another variable says max = 0 which stores the length of the longest subarray with sum zero.
Declare a HashMap<Integer, Integer> which stores the prefix sum of every element as a key and its index as a value.
Now traverse the array, and add the array element to our sum. 
 (i)  If sum = 0, then we can say that the subarray until the current index has a sum = 0,      so we update max with the maximum value of (max, current_index+1)

(ii)  If the sum is not equal to zero then we check the hashmap if we’ve seen a subarray with this sum before

if HashMap contains sum -> this is where the above-discussed case occurs (subarray with equal sum), so we update our max 

else -> Insert (sum, current_index) into hashmap to store prefix sum until the current index

After traversing the entire array our max variable has the length of the longest substring having a sum equal to zero, so return max.
NOTE: we do not update the index of a sum if it’s seen again because we require the length of the longest subarray
         */
        ans = LongestOptimizedSubarray(arr);

        System.out.println("The longest subarray with sum 0 is: "+ans);
    }

    public static int LongestSubarray(int[]arr){
        int maxValue = 0;
        for(int i = 0; i<arr.length; i++){
            int sum = 0;
            for(int j = i; j<arr.length; j++){
                sum += arr[j];
                if(sum == 0){
                    if(maxValue < (j-i+1)){
                        maxValue = j-i+1;
                    }
                }
            }
        }
        return maxValue;
    }

    public static int LongestOptimizedSubarray(int[]arr){
        int maxValue = 0;
        int sum = 0;
        HashMap<Integer,Integer>mp = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
            if(sum == 0){
                if(maxValue < i+1){
                    maxValue = i+1;
                }
            }
            else{
                if(mp.containsKey(sum)){
                    int j = mp.get(sum);
                    if(maxValue < i-j){
                        maxValue = i-j;
                    }
                }
                else{
                    mp.put(sum,i);
                }
            }
            
        }
        return maxValue;
    }
}
