package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* question:
 * Given an array arr[], with 0-based indexing, select any two indexes, i and j such that i < j.
 *  From the subarray arr[i...j], select the smallest and second smallest numbers and add them, 
 * you will get the score for that subarray. Return the maximum possible score across all the subarrays of array arr[].
 */
public class MaximumScoreFromSubarrayMinimum{
     public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        n = Integer.parseInt(br.readLine());

        System.out.println("Enter "+n+" element: ");
        int []arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int ans = 0;
        
        //BruteForce approach
        // ans = MaximumSubSum(arr);

        //optimized approach
        // since we only need to compare the sum of small and secSmall for any subarray then 
        // we only compare the maximum sum of two value from the array
        ans = OptimizedSubSum(arr);
        System.out.println("The maximum sum is: "+ans);
        
    }

    public static int MaximumSubSum(int []arr){
        int maxVal = 0;
        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j< arr.length; j++){
                int small = Integer.MAX_VALUE, secSmall = Integer.MAX_VALUE;
                for(int k = i; k<= j; k++){
                    if(arr[k] <= small){
                        secSmall = small;
                        small = arr[k];
                    }
                    if(arr[k] < secSmall && arr[k] > small){
                        secSmall = arr[k];
                    }
                }
                int total = small+ secSmall;
                if(total > maxVal){
                    maxVal = total;
                }
            }
        }

        return maxVal;
    }

    public static int OptimizedSubSum(int []arr){
        int maxVal = Integer.MIN_VALUE;
        for(int i = 1; i<arr.length; i++){
            int total = arr[i-1]+arr[i];
            if(total > maxVal){
                maxVal = total;
            }
        }
        return maxVal;
    }
}