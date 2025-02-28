package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FirstAndLastOccurenceInSortedArray {
    public static void main(String args[]) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        System.out.print("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the key you want to search: ");
        int k = Integer.parseInt(br.readLine());
        
        List<Integer>ans = new ArrayList<>();
        //we will use two binary serach for finding first and last element
        /*
         * in first binary search when we find the target element we will maintain a variable first which will be updated by mid and
         * high will take as mid-1 because we need to find the first occurence so we will take the left part. other thing will be same
         * 
         * for second binary search when we find the target element we will maintain a variable second which will be updated by mid and
         * low will take as mid+1 because we need to find the last occurence so we will take the right part.
         */
        ans = BinarySerachWithModification(arr,k);
        int val = 0;
        if(ans.get(0)== -1) val = 0;
        else{
            val = ans.get(1) - ans.get(0)+1;
        }
        System.out.println("The ans is: "+val);
        /*One other is to use lower bound and upperbound algorithm */
        // System.out.println("The ans is: "+ans);
    }

    public static List<Integer> BinarySerachWithModification(int []arr, int k){
        int low =0, high = arr.length-1;
        int first = -1 , last = -1;
        // first binary search
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == k){
                first = mid;
                high = mid-1;
            }
            else if(arr[mid] < k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        low = 0; high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == k){
                last = mid;
                low = mid+1;
            }
            else if(arr[mid] < k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        List<Integer>ans = new ArrayList<>();
        ans.add(first);
        ans.add(last);
        return ans;
    }
}
