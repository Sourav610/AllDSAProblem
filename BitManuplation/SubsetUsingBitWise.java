/*
 * Given an integer array nums of unique elements, return all possible subsets (the power set).

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SubsetUsingBitWise {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        int n= Integer.parseInt(br.readLine());
        int[]arr = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        ans = createSubset(n,arr);
        for(ArrayList<Integer> i: ans){
            System.out.println(i);
        }
    }

    public static ArrayList<ArrayList<Integer>> createSubset(int n, int[]arr){
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        for(int i= 0; i<(1<<n); i++){
            ArrayList<Integer>temp = new ArrayList<>();
            for(int j = 0; j<n; j++){
                if((i&(1<<j)) != 0){
                    temp.add(arr[j]);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
