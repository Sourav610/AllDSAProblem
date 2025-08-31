
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
        // ans = findOptimizeNum(arr);
        // ans = findUniqueNumUsingBitwise(arr);
        ans = findUniqueNumUsingBucket(arr);
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
    /*
     * ex - [2, 2,3,2, 4, 4,4] we conver all number to binary
     *   2 1 0  - index 
     *   0 1 0 - 2
     *   0 1 0 - 2
     *   0 1 1 - 3
     *   0 1 0 - 2
     *   1 0 0 - 4
     *   1 0 0 - 4
     *   1 0 0 - 4  
     *  we can see that in 0 index we have only 1 set bit
     *  in 1st index we have 4 set bit and 3rd index we have 3 set bit 
     *  
     *  so we can consider if in every index if the set bit is not multiple of 3
     * then that index value need to set for ans in this way we can get the unique value. 
     */

    public static int findUniqueNumUsingBitwise(int[]arr){
        int ans = 0;
        for(int i = 0; i<= 31; i++){
            int count= 0;
            for(int j = 0; j<arr.length; j++){
                if((arr[j]&(1<<i)) != 0){
                    count++;
                }
            }
            if(count%3 == 1){
                ans = ans | (1<<i);
            }
        }
        return ans;
    }

    /*
     * in this approach we will use bucket concept.
     * let considert two bucket ones and twos and below rules 
     * -- arr[i] will go th ones, if it is not in twos
     * -- arr[i] will go to tows if it is in ones
     *
     * 
     * - so if we take first elment and if it goes to ones it will be adding
     *  if it will go to two then adding in twos and deleting from ones.
     * 
     * we will be using like ((ones ^ arr[i]) & ~twos)  for first bucket - here ^ use to add and ~twos to remove from twos
     * ((twos^arr[i])& (~ones)) for 2nd bucket
     * 
     * 
     * Note: not sorting because we are doing operation in bitwise which not required sorting
     * T.c - O(n)
     * S.c - O(1)
     */

    public static int findUniqueNumUsingBucket(int[]arr){
        int ones=0,twos = 0;
        for(int i = 0; i<arr.length; i++){
            ones = (ones^arr[i]) & (~twos);
            twos = (twos^arr[i]) & (~ones);
        }

        return ones;
    }

}
