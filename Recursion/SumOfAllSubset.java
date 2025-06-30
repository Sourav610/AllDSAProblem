
/*
 * Given an array print all the sum of the subset generated from it, in the increasing order
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SumOfAllSubset {
    public static void main(String[]args) throws IOException{
        int n,k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a size: ");
        n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        ArrayList<Integer>temp = new ArrayList<>();
        calSubsetSum(0,arr,temp,0);
        for(Integer i: temp){
            System.out.println("The subsequenc present in arr is "+i);
        }
    }

    public static void calSubsetSum(int i, int[]arr, ArrayList<Integer>temp,int sum){
        if(i == arr.length){
            temp.add(sum);
            return;
        }

        calSubsetSum(i+1, arr,temp, sum+arr[i]);
        calSubsetSum(i+1, arr, temp, sum);
    }
}
