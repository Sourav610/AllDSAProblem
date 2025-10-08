package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfSubArrayRanges{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of an array: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println("Enter "+n+" element: ");
        int[]arr = new int[n];

        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        long ans = 0; 
        // ans = findSubArrayRange(arr);
        ans = findOptimizeSubArrayRange(arr);
        System.out.println("The result is : "+ans);

    }

    public static long findSubArrayRange(int[]arr){
        long sum = 0; 
        for(int i = 0; i<arr.length; i++){
            for(int j = i; j<arr.length; j++){
                int minVal = Integer.MAX_VALUE;
                int maxVal = Integer.MIN_VALUE;
                for(int k = i; k<=j; k++){
                    minVal = Math.min(minVal,arr[k]);
                    maxVal = Math.max(maxVal,arr[k]);
                }

                sum += (long)maxVal - (long)minVal;
            }
        }
        return sum;
    }

    public static long findOptimizeSubArrayRange(int[]arr){
        long sum = 0; 
        for(int i = 0; i<arr.length; i++){
            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;
            for(int j = i; j<arr.length; j++){
                minVal = Math.min(minVal,arr[j]);
                maxVal = Math.max(maxVal,arr[j]);
                sum += (long)maxVal - (long)minVal;
            }
        }
        return sum;
    }
}