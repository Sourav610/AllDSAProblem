package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/* 
 * Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

same as bookAllocationProblem
*/

/*
 * PATTERN - Try to think in question what we need to maximize or minimize then
 * take that value from array like min value and maxValue and traverse in that range and try what question
 * ask like number of subarrays, no. of books and check if it is equals to the number question provide, if it 
 * then that is your answer.
 */

public class SplitArrayLargestSum {
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
        System.out.println("Enter the maximum sub array: ");
        int key =  Integer.parseInt(br.readLine());
      
        // ans = splitArray(arr,key);
        ans = optimzeSplitArray(arr, key);
        
        System.out.println("The ans is: "+ans);
    }

    public static int splitArray(int[]arr, int key){
        if(arr.length<key)return -1;
        List<Integer>ans = findMaxAndSum(arr);
        int low = ans.get(0);
        int high = ans.get(1);
        for(int i = low; i<=high; i++){
            if(checkArrangement(arr, i) == key){
                return i;
            }
        }
        return low;
    }

    public static int checkArrangement(int[]temp, int page){
        int n = temp.length;
        int count = 0;
        int student = 1;
        for(int i = 0; i<n; i++){
            if(count+temp[i] <= page){
                count += temp[i];
            }
            else{
                student++;
                count = temp[i];
            }
        }
        return student;
    }


    public static int optimzeSplitArray(int[]arr, int student){
        if(arr.length<student)return -1;
        List<Integer>ans = findMaxAndSum(arr);
        int low = ans.get(0),high = ans.get(1);
        while(low<= high){
            int mid = (low+high)/2;
            if(checkArrangement(arr, mid) > student){
               low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }

    public static List<Integer>findMaxAndSum(int[]arr){
        int max = -1, sum = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
            sum += arr[i];
        }
        return Arrays.asList(max,sum);
    }
}
