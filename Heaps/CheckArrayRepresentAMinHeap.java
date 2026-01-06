package Heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckArrayRepresentAMinHeap {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        System.out.println("Enter the size of arr: ");
        n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Boolean ans  = checkMinHeap(arr,n);
        System.out.println("The array is min heap: "+ans);

    }

    /*
     T.C - O(n);
     S.C - O(1)
    */
    public static boolean checkMinHeap(int[]arr, int n){
        // Iterate through all non-leaf nodes
        for(int i = 0; i <= (n/2)-1; i++){
            int left = i*2+1;
            int right = i*2+2;
            if(left <n && arr[i] > arr[left]){
                return false;
            }

            if(right < n && arr[i] > arr[right]){
                return false;
            }
        }
        return true;
    }
}
