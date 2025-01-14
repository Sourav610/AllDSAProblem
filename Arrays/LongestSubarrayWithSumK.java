package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class LongestSubarrayWithSumK {
    public static void main(String []args) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        System.out.print("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the sum you want to check : ");
        int k = Integer.parseInt(br.readLine());
        // LongestSubarray(arr, k);

        //optimized approach
        //using prefix sum - storing the sum till the index in ordered hash map and later try to find it by sum -k
        //if it is present use the index to calculate the length;
        LongestOptimizedSubarray(arr, k);
    }

    public static void LongestSubarray(int []arr, int k){
        int length = 0;
        for(int i = 0; i<arr.length; i++){
            int sum = 0;
            for(int j = i; j<arr.length; j++){
                sum += arr[j];

                if(sum == k){
                    length = Math.max((j-i+1), length);
                }
            }
        }

        System.out.println("The length of longest subarray is: "+ length);
    }

    public static void LongestOptimizedSubarray(int []arr, int k){
        int n = arr.length;
        int maxLen = 0;
        long sum = 0;
        HashMap<Long,Integer>mp = new HashMap<>();

        for(int i = 0; i<n; i++){
            sum += arr[i];

            if(sum == k){
                maxLen = Math.max(maxLen, i+1);
            }

            long rem = sum - k;
            if(mp.containsKey(rem)){
                int len = i - mp.get(rem);
                maxLen = Math.max(len, maxLen);

            }

            if(!mp.containsKey(sum)){
                mp.put(sum, i);
            }
        }
        System.out.println("the longest subarray length is: "+maxLen);

    }
}
