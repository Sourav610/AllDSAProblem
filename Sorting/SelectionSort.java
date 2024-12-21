package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * Selection Sort:
 * Selection Sort is a comparison-based sorting algorithm. It sorts an array by repeatedly selecting the smallest (or largest) element
 *  from the unsorted portion and swapping it with the first unsorted element. This process continues until the entire array is sorted.

    First we find the smallest element and swap it with the first element. This way we get the smallest element at its correct position.
    Then we find the smallest among remaining elements (or second smallest) and swap it with the second element.
    We keep doing this until we get all elements moved to correct position.
 */
public class SelectionSort {
    public static void main(String []args) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the size of array: ");
        n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Sorting(arr);

        System.out.println("Element after sorting: ");
        for(int i = 0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void Sorting(int []arr){
       for(int i = 0; i<arr.length-1; i++){
            int ind = i;
            for(int j = i+1; j<arr.length; j++){
                if(arr[ind] > arr[j]){
                    ind = j;
                }
            }
            System.out.print(arr[ind]+" ");
            int reserve  = arr[ind];
            arr[ind] = arr[i];
            arr[i] = reserve;
       }
    }
}
