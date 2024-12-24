package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSort {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of an array to be sorted: ");
        n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        System.out.print("Enter "+n+" no. of element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        //insertion sort - consider two array one sorted and one unsorted. put the element from unsorted array to shorted array. 
        //initiall shorted array will be empty and unsorted array will be full mantain using index. 
        //then check the element from unshorted array to be placed at which position in sorted array then replace by shifting and swapp
        for(int i = 0; i<n; i++){
            int j = i;
            while(j> 0 && arr[j-1] > arr[j]){ 
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        System.out.println("The element after sorting is: ");
        for(int t = 0; t<n; t++){
            System.out.print(arr[t]+" ");
        }
    }
}
