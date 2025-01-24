package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSubarray {
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
        // ans = MaximumSubarraySums(arr);

        //optimized approrach - kadane's algorithm
        //not considering -ve value if sum < 0 then sum = 0 and then check which is maximum sum.
        ans = OptimizedSubarraySum(arr);

        extendedOptimizedSubarraySum(arr);
        System.out.println("The maximum sum is: "+ans);
        
    }
    public static int MaximumSubarraySums(int[]arr){
        int sum = 0,maxSum = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            sum = 0;
            for(int j  = i; j<arr.length; j++){
                sum += arr[j];
                maxSum = Math.max(sum,maxSum);
            }
        }
        return maxSum;
    }

    public static int OptimizedSubarraySum(int []arr){
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0){
                sum = 0;
            }

        }
        return maxSum;
    }

    public static void extendedOptimizedSubarraySum(int []arr){
        int sum = 0, maxSum = Integer.MIN_VALUE;
        int start = 0, end = 0, ansStart=0;
        for(int i = 0; i<arr.length; i++){
            if(sum == 0) start = i;
            sum += arr[i];
            if(sum > maxSum){
                maxSum = sum;
                ansStart = start;
                end = i;
            }
            if(sum < 0){
                sum = 0;
            }

        }
        
        System.out.println("The sub array is : ");
        for(int i = ansStart; i<=end; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
