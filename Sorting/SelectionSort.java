package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
