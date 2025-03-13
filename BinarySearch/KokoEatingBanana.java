package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.
 */

public class KokoEatingBanana {
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
        System.out.println("Enter the maximum time: ");
        int hour =  Integer.parseInt(br.readLine());
        //for this problem we need to minimize the banana per hour time should be less then give time
        //so we will first take maximum banana in the array and everytime we will calculate total time 
        //take to eat all banana from piles by given rate,The minimum rate we will get will be the answer

        // ans = bananaEatingSpeed(arr,hour);
        ans = optimizeBananaEatingSpeed(arr, hour);
        
        System.out.println("The ans is: "+ans);
    }

    public static int bananaEatingSpeed(int[]arr, int hour){
        int val = max(arr);
        for(int i = 1; i<=val; i++){
            int totalHr = calcHour(arr, i);
            if(totalHr<= hour){
                return i;
            }
        }
        return -1;
    }

    public static int calcHour(int[]temp, int h){
        int total = 0;
        for(int i = 0; i<temp.length; i++){
            total += Math.ceil((double)(temp[i])/(double)(h));
        }
        return total;
    }

    public static int max(int[]temp){
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<temp.length; i++){
            if(temp[i] > ans){
                ans = temp[i];
            }
        }
        return ans;
    }

    public static int optimizeBananaEatingSpeed(int[]arr, int h){
        int ans= 0;
        int val = max(arr);
        int low = 0, high = val; 
        while(low<= high){
            int mid = (low+high)/2;
            int temp = calcHour(arr, mid);
            if(temp<= h){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}
