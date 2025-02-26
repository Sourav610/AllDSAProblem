package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchInsertPosition {
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
        
        int ans = -1;
        ans = searchPosition(arr,k);
        System.out.println("The ans is: "+ans);
    }

    //if sorted arr is pass
    public static int searchPosition(int[] arr, int k){
        int low = 0, high = arr.length-1;

        while(low<= high){
            int mid = (low+high)/2;
            if(arr[mid] == k){
                return mid;
            }
            else if(arr[mid] > k){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}
