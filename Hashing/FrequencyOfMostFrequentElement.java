package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class FrequencyOfMostFrequentElement {
    public static void main(String []args) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of an array: ");
        n = Integer.parseInt(br.readLine());

        System.out.println("Enter "+n+" element: ");
        int []arr = new int[n];
        for(int i = 0; i< n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the value of k: ");
        int k = Integer.parseInt(br.readLine());

        // using sort + slidingWindow
        /*
         * formula is -  the sliding window size will increase only when
         * arr[j] * windowSize < total+k
         * because we have only k budget we can use . so if window size is 3 and then jth element is 8
         * then total left value will be 24, but our buget is sum of element within the window(4+5+3) + 3(k) = 15
         * since k is less we cannot use it to make all the element in that window equal, so will decrease the window size by increas
         * i value.
         */
        System.out.println("The maximum frequency of element is: "+CountFrequency(arr, k));
    }

    public static int CountFrequency(int []arr, int k){
        Arrays.sort(arr);
        int size = arr.length;
        int i = 0, j = 0;
        long total = 0;
        int ans = 0;
        while(j< size){
            long target = arr[j];
            total += target;
            while((j-i+1)*target > total + k){
                total -= arr[i];
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;

        }
        return ans;
    }
}
