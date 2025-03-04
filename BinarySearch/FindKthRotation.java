package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindKthRotation {
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

        int ans = -1;
        // ans = kthRotation(arr);
        ans = optimizeKthRotation(arr);
        System.out.println("The ans is: "+ans);
    }

    public static int kthRotation(int[]arr){
        int ans = -1;
        for(int i = 1; i<arr.length; i++){
            if(arr[i-1] >  arr[i]){
                ans = i-1;
                break;
            }
        }

        return ans+1;
    }

    public static int optimizeKthRotation(int[]arr){
        int low = 0, high = arr.length-1;
        int ind = -1;
        if(arr[low] <arr[high]){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[low] <= arr[mid]){
                if(arr[low] < ans){
                    ans = arr[low];
                    ind = low;
                }
                low = mid+1;
            }
            else{
                if(arr[mid] < ans){
                    ans = arr[mid];
                    ind = mid;
                }
                high = mid-1;
            }
        }
        return ind;
    }
}
