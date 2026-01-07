package Heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* */

public class ConvertMinHeapToMaxHeap {
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

        convertToMaxHeap(arr,n);
        System.out.println("The ans is: ");
        for(int i = 0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        
    }

    public static int[] convertToMaxHeap(int[]arr,int n){

        for(int i = n/2-1; i>= 0; i--){
            maxHeapify(arr,n,i);
        }
        return arr;
    }

    static void maxHeapify(int[]arr, int n, int i){
        int largest = i;
        int right = i*2+2;
        int left = i*2+1;

        if(left < n && arr[left] > arr[largest]){
            largest = left;
        }

        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }
        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            maxHeapify(arr, n, largest);
        }
        
    }
}
