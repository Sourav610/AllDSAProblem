package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumProductSubArray {
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
        ans = majorProductSubarr(arr);
        
        System.out.println("The majority element is: "+ans);

    }

    public static int majorProductSubarr(int[]arr){
        int ans = Integer.MIN_VALUE;
        int pre = 1;
        int suff = 1;
        for(int i = 0; i<arr.length; i++){
            if(pre == 0) pre = 1;
            if(suff == 0) suff = 1;

            pre *= arr[i];
            suff *= arr[arr.length-i-1];

            ans = Math.max(ans, Math.max(pre,suff));
        }

        return ans;
    }

}
