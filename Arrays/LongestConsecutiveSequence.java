package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class LongestConsecutiveSequence{
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        n = Integer.parseInt(br.readLine());

        System.out.println("Enter "+n+" element: ");
        int []arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int ans = 0;
        // ans = countLong(arr);
        ans = countOptimizeLong(arr);
        System.out.println("The largest sequence is: "+ans);

    }

    public static int countLong(int []arr){
        Arrays.sort(arr);

        int start = Integer.MIN_VALUE;
        int count = 0, maxValue = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] -1 == start){
                count++;
                start = arr[i];
            }
            else if(start != arr[i]){
                count = 1;
                start = arr[i];
            }
            if(count> maxValue){
                maxValue = count;
            }
        }
        return maxValue;
    }

    public static int countOptimizeLong(int []arr){
        if(arr.length == 0){
            return 0;
        }
        int maxVal = 0;
        Set<Integer>st = new HashSet<>();
        for(int i = 0; i<arr.length; i++){
            st.add(arr[i]);
        }

        for(Integer i: st){
            if(!st.contains(i-1)){
                int count = 1;
                int x = i;
                while(st.contains(x+1)){
                    count++;
                    x++;
                }
                if(count > maxVal){
                    maxVal = count;
                }
            }
        }

        return maxVal;
    }
    
}
