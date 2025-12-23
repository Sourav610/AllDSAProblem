package SlidingWindowAndTwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k;
        String arr ="";
        System.out.println("Enter any string: ");
        arr = br.readLine();

        System.out.println("Enter the value of k: ");
        k = Integer.parseInt(br.readLine());

        int ans = 0;
        // ans = findLongestSubstring(arr,k);
        ans = findOptimizeLongestSubstring(arr,k);
        System.out.println("The maximum number of consecutives ones are: "+ans);
    }   

    public static int findLongestSubstring(String arr, int k){
        int maxCount = 0;
        for(int i = 0; i<arr.length(); i++){
            Map<Character,Integer>mp = new HashMap<>();
            for(int j = i; j<arr.length(); j++){
                mp.put(arr.charAt(j),mp.getOrDefault(arr.charAt(j),0)+1);
                if(mp.size() > k){
                   break;
                }
                maxCount = Math.max(maxCount,j-i+1);
            }
        }
        return maxCount;
    }

    public static int findOptimizeLongestSubstring(String arr,int k){
        Map<Character,Integer>mp = new HashMap();
        int i = 0, j = 0, maxCount = 0,n= arr.length();
        while(i<n){
            mp.put(arr.charAt(i),mp.getOrDefault(arr.charAt(i), 0)+1);
            while(mp.size() > k){
                mp.put(arr.charAt(j),mp.getOrDefault(arr.charAt(j), 0)-1);
                if(mp.get(arr.charAt(j)) == 0){
                    mp.remove(arr.charAt(j));
                }
                j++;
            }
            if(mp.size() == k){
                maxCount = Math.max(maxCount,i-j+1);
            }
            i++;
        }
        return maxCount;
    }
}