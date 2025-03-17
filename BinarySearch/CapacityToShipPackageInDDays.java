package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.List;

public class CapacityToShipPackageInDDays {
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
   
        ans = findWeight(arr,m);
        
        System.out.println("The ans is: "+ans);
    }

    public static int findWeight(int[]arr, int m){
        int ans = 0;
        List<Integer>temp = findMax(arr);
        int minVal = temp.get(0);
        int maxVal = temp.get(1);
        int low = minVal, high = maxVal;
        while(low<= high){
            int mid = (low+high)/2;
            int total = findDays(arr, mid);
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

    public static List<Integer> findMax(int[]arr){
        int val = Integer.MIN_VALUE;
        int sum  = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
            if(arr[i] > val){
                val = arr[i];
            }
        }
        return Arrays.asList(val,sum);
    }

    public static int findDays(int[]arr, int cap){
        int days =1;
        int load = 0;
        for(int i = 0; i<arr.length; i++){
            if(load+arr[i] > cap){
                days += 1;
                load = arr[i];
            }
            else{
                load += arr[i];
            }
        }
        return days;
    }
}
