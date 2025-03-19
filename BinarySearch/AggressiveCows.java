package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * You are given an array 'arr' of size 'n' which denotes the position of stalls.
You are also given an integer 'k' which denotes the number of aggressive cows.
You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.
Find the maximum possible minimum distance.
 */
public class AggressiveCows {
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
        System.out.println("Enter the maximum cows: ");
        int cows =  Integer.parseInt(br.readLine());
        //for this problem we need to distance between each cows 
        //so we will take distance from 1 to infinite and check if it is possible to place all cows
        //in that distance or not;

        // ans = cowsArrangement(arr,cows);
        ans = optimizeCowsArrangement(arr, cows);
        
        System.out.println("The ans is: "+ans);
    }

    public static int cowsArrangement(int[]arr, int cows){
        Arrays.sort(arr);
        int val = arr[arr.length-1] - arr[0];
        for(int i = 1; i<=val; i++){
            if(checkArrangement(arr, i, cows) == false){
                return i-1;
            }
        }
        return val;
    }

    public static boolean checkArrangement(int[]temp, int dist,int cows){
        int n = temp.length;
        int count = 1;
        int last = temp[0];
        for(int i = 1; i<n; i++){
            if(temp[i]-last >= dist){
                count++;
                last = temp[i];
            }
            if(count >= cows) return true;
        }
        return false;
    }


    public static int optimizeCowsArrangement(int[]arr, int cows){
        Arrays.sort(arr);
        int low = 0,high = arr[arr.length-1] - arr[0];

        while(low<= high){
            int mid = (low+high)/2;
            if(checkArrangement(arr, mid, cows) == true){
               low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return high;
    }
}
