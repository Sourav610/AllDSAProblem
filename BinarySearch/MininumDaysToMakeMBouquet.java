package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
 */
public class MininumDaysToMakeMBouquet {
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
        System.out.println("Enter the maximum bouque: ");
        int m =  Integer.parseInt(br.readLine());

        System.out.println("Enter the number of flower: ");
        int k = Integer.parseInt(br.readLine());  
        //same approach as kokoEatingBanana just for particular day had to check how many
        /* flowers bloom and is it enough for making bouquet if yes how many can be made
         */      
        ans = makeBouquet(arr,m,k);
        
        System.out.println("The ans is: "+ans);
    }

    public static int makeBouquet(int[]arr, int m, int k){
        List<Integer>temp = new ArrayList<>();
        temp= findMinMax(arr);
        int minValue  = temp.get(0);
        int maxValue = temp.get(1);
        long n = (long)m*(long)k;
        if(n > arr.length){
            return -1;
        }
        int low = minValue, high = maxValue;
        while(low<=high){
            int mid = (low+high)/2;
            int result = possiblebouquet(arr, k, mid);
            if(result>=m){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }

    public static List<Integer> findMinMax(int[]arr){
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for(int i = 0; i<arr.length; i++){
            if(arr[i] > maxVal){
                maxVal = arr[i];
            }
            if(arr[i]< minVal){
                minVal = arr[i];
            }
        }

        return Arrays.asList(minVal,maxVal);
    }

    public static int possiblebouquet(int[]arr, int k, int d){
        int count = 0;
        int countOfB = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] <= d){
                count++;
            }
            else{
                countOfB += count/k;
                count = 0;
            }
        }

        countOfB += count/k;
        return countOfB;
    }
}
