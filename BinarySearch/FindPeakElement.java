package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindPeakElement {
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
        
        //for searching this type of problem, always check its previous and next element;
        //for choosing left or right part check which part the point lie, like if it is less than next
        /* element then its lie on left part and we need to move to right and vice versa.
         */
        ans = searchPickElementIndex(arr);

        System.out.println("The ans is: "+ans);
    }

    public static int searchPickElementIndex(int[]arr){
        int n = arr.length;
        if(n == 1) return 1;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2])return n-1;
        int low = 1, high = n-2;
        while(low<= high){
            int mid = (low+high)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }
            else if(arr[mid] < arr[mid+1]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}
