package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

The test cases are generated so that there will be an answer.
 */
public class SmalledDivisorInGivenThreshold {
    public static void main(String args[]) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        n = Integer.parseInt(br.readLine());
        int ans = 1;
        int[]arr = new int[n];
        System.out.println("Enter the value of array: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter the threshold: ");
        int m =  Integer.parseInt(br.readLine());
   
        ans = findDivisor(arr,m);
        
        System.out.println("The ans is: "+ans);
    }

    public static int findDivisor(int[]arr, int m){
        int ans = 0;
        int maxValue = findMax(arr);
        int low = 1, high = maxValue;
        while(low<= high){
            int mid = (low+high)/2;
            int total = calcDiv(arr, mid);
            if(total <= m){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static int findMax(int[]arr){
        int val = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > val){
                val = arr[i];
            }
        }
        return val;
    }

    public static int calcDiv(int[]arr, int ind){
        int total = 0;
        for(int i = 0; i<arr.length; i++){
            double temp = Math.ceil((double)(arr[i])/(double)(ind));
            total += (int)temp;
        }
        return total;
    }
}


