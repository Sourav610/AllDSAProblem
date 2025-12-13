package SlidingWindowAndTwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
 You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.
*/
public class LongestRepeatingCharacterSequence {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a String of character: ");
        String arr;
        arr = br.readLine();
        System.out.println("Enter the value of k: ");
        int k = Integer.parseInt(br.readLine());
        int ans = 0;
        // ans = calculateMaximumRepeatCh(arr,k);
        ans = calculateOptimizeRepeatCh(arr, k);
        System.out.println("The maximu repeat character is: "+ans);
    }

    /*
     Brute Force Approach: 
     - first we will create subarray.
     - then for each subarray we will count max Freq of the element in that subarray
     - By substracting the maxFreq from length of subarray we will get how many element we can update
     - if no. of element is less than the k then we will consider the length as maxLength else we will not consider that subarray

     T.c - O(n*n);
     S.c - O(26)
    */
    public static int calculateMaximumRepeatCh(String arr, int k){
        int maxLength = 0; 
        int[]temp = new int[26];
        for(int i = 0; i<arr.length(); i++){
            int maxFreq = 0; 
            for(int j = 1; j<arr.length(); j++){
                temp[arr.charAt(j)-'A']++;
                maxFreq = Math.max(maxFreq,temp[arr.charAt(j)-'A']);
                if(j-i+1 - maxFreq <= k){
                    maxLength = Math.max(maxLength,j-i+1);
                }
            }
        }

        return maxLength;
    }

    /*
     Optimize Approach: considering two pointe and a hashmap to store the freq if freq goes higher then k , kindly move j pointer one time
     as we get most optimal result only when length is high and freq is low so multiple time no need to move the j  pointer

     T.C - O(N)
     S.C - O(26)
    */

    public static int calculateOptimizeRepeatCh(String arr,int k){
        int maxLength = 0;
        int maxFreq = 0;
        int j = 0;
        Map<Integer,Integer>mp = new HashMap<>();
        for(int i = 0; i<arr.length(); i++){
            mp.put(arr.charAt(i)-'A',mp.getOrDefault(arr.charAt(i)-'A', 0)+1);
            maxFreq = Math.max(mp.get(arr.charAt(i)-'A'),maxFreq);
            if(i-j+1 - maxFreq > k){
                mp.put(arr.charAt(j)-'A',mp.getOrDefault(arr.charAt(j)-'A', 0)-1);
                j++;
            }
            maxLength = Math.max(maxLength,i-j+1);
        }
        return maxLength;
    }
}
