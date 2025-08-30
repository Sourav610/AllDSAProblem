
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.
 */


public class SingleNum2 {
    public static void main(String[]agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        int n= Integer.parseInt(br.readLine());
        int[]arr = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        // ans = findUniqueNum(arr);
        ans = findOptimizeNum(arr);
        // ans = findUniqueNumUsingBitwise(arr);
        System.out.println("The answer is: "+ans);
    }

    /*
     * Using hashing to keep the frequency of each element
     * T.C - O(n), S.C - O(n)
     */

    public static int findUniqueNum(int[]arr){
        Map<Integer,Integer>mp = new HashMap<>();
        int ans = 0;
        for(int i = 0; i<arr.length; i++){
            mp.put(arr[i],mp.getOrDefault(arr[i], 0)+1);
        }

        for(Map.Entry<Integer,Integer>id:mp.entrySet()){
            if(id.getValue() == 1){
                ans = id.getKey();
            }
        }
        return ans;
    }

    /*
     * sort the array and traverse by window of 3 and compare if arr[i-1] and arr[i]
     * are not equal then it cannot from a 3 size window and arr[i-1] will be our unique num.
     * 
     * t.C - O(nlogn) sorting takes n log n time.
     * S.C - O(1) 
     */
    public static int findOptimizeNum(int[]arr){
        Arrays.sort(arr);
        int i =1;
        while(i<arr.length){
            if(arr[i-1] != arr[i]){
                return arr[i-1];
            }
            i+= 3;
        }

        if(i >= arr.length){
            return arr[arr.length-1];
        }
        return arr[0];
    }

    // public static int findUniqueNumUsingBitwise(int[]arr){
    //     int ans = 0;
    //     for(int i = 0; i<= 31; i++){
    //         int count= 0;
    //         for(int j = 0; j<arr.length; j++){
    //             if((arr[j]&(1<<i)) == 1){
    //                 count++;
    //             }
    //         }
    //         if(count%3 == 1){
    //             ans = ans | (1<<i);
    //         }
    //     }
    //     return ans;
    // }

}
