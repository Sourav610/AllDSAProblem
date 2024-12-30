package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort{
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];

        System.out.println("Enter "+" n element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        //first finding the pivot point(which will be taken randomly) then place the pivot value to correct position so that
        // the element less than pivot value should be on left and greater value should be on right of pivot value.
        // then recursively call the left half and right the array.
        // QuickSortAlgo(arr, 0, arr.length);

        OptimizedQuickSort(arr, 0, arr.length-1);
        System.out.println("The sorted array are: ");
        for(int i = 0; i<n; i++){
            System.out.print(arr[i]+" ");
        }

    }

    // public static void QuickSortAlgo(int []arr,  int n, int size){
    //     if(n == size){
    //         return;
    //     }

    //     int pivot = partition(arr, n, size);

    //     QuickSortAlgo(arr, n, pivot);
    //     QuickSortAlgo(arr, pivot+1, size);
    // }

    public static void OptimizedQuickSort(int []arr, int n, int size){
       if(n> size){
        return;
       }

        int pivot = optimizedPartition(arr, n, size);

        OptimizedQuickSort(arr, n, pivot-1);
        OptimizedQuickSort(arr, pivot+1, size);
        
    }


    // public static int partition(int []arr, int l, int r){
    //     int pivot = l;
    //     for(int i = 0; i<r; i++){
    //         if(i != pivot){
    //             if(arr[pivot] > arr[i]){
    //                 for(int j = i; j> pivot; j--){
    //                     int temp = arr[j];
    //                     arr[j] = arr[j-1];
    //                     arr[j-1] = temp;
    //                 }
    //             }
    //         }
    //     }

    //     return pivot;
    // }

    public static int optimizedPartition(int []arr, int l, int r){
        int pivot = arr[l];
        int i = l;
        int j = r;
        while(i < j){
            while(arr[i] <= pivot && i<=r-1){
                i++;
            }

            while(arr[j] > pivot && j>= l+1){
                j--;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;
        return j;
    }
}