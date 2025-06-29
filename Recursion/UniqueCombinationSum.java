

/*
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class UniqueCombinationSum {
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
        System.out.println("Enter a target: ");
        k = Integer.parseInt(br.readLine());
        
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        ArrayList<Integer>temp = new ArrayList<>();
        Arrays.sort(arr);
        calCombination(0,arr,k,temp,ans);
        for(ArrayList<Integer> i: ans){
            System.out.println("The subsequenc present in arr is "+i);
        }
    }

    public static void calCombination(int i, int[]arr, int k, ArrayList<Integer>temp,ArrayList<ArrayList<Integer>>ans){
        if(k == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int ind = i; ind <arr.length; ind++){
            if(ind > i && arr[ind-1] == arr[ind])continue;
            if(k < arr[ind])return;
            temp.add(arr[ind]);
            calCombination(ind+1, arr, k-arr[ind], temp, ans);
            temp.removeLast();
        }
    }
}
