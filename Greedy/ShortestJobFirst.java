package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ShortestJobFirst{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of arr: ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter "+n+" element: ");
        int arr[] = new int[n];
        for(int i = 0;i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        long ans = 0;
        ans = calculateAvg(arr,n);

        System.out.println("The avg time taken to complete all job: "+ans);
    }

    public static long calculateAvg(int[]arr,int n){
        long sum = 0;
        long prev = 0;
        Arrays.sort(arr);

        for(int i = 0; i<arr.length; i++){
            sum += prev;
            prev += arr[i];
        }

        return sum/n;
    }
}
