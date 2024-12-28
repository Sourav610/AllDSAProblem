package Sorting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveInsertionSort {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of an array: ");
        n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];

        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        RecursiveInsertionSort(arr, 0);
        System.out.println("Element after sorting: ");
        for(int i = 0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        
    }

    public static void RecursiveInsertionSort(int arr[], int n){
        if(n == arr.length){
            return;
        }

        int j = n;
        while(j > 0 && arr[j-1] > arr[j]){
            int temp = arr[j-1];
            arr[j-1] = arr[j];
            arr[j]= temp;
            j--;
        }
        RecursiveInsertionSort(arr, n+1);
    }
}
