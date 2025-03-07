package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SingleElementInSortedArray {
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
        
        ans = SearchSingleElement(arr);

        System.out.println("The ans is: "+ans);
    }

    public static int SearchSingleElement(int[]arr){
        int n = arr.length;
        if(n == 1){
            return arr[0];
        }
        if(arr[0] != arr[1])return arr[0];
        if(arr[n-1] != arr[n-2]) return arr[n-2];

        int low = 1, high = n-2;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
                return arr[mid];
            }
            else if((mid%2 == 0 && arr[mid] == arr[mid+1]) || (mid%2 == 1 && arr[mid] == arr[mid-1])){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}
