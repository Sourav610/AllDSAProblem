package Sorting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RecursionBubbleSort {
    public static void main(String []args) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of an array: ");
        n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        //inner loop will be same just outer is converted to recursive call
        recursiveBubbleSort(arr,n);

        System.out.println("Array after sorting: ");
        for(int i = 0; i<n; i++){
            System.out.print(arr[i]+" ");
        }

    }

    public static void recursiveBubbleSort(int []arr, int i){
        if(i == 1){
            return;
        }
        
        for(int k = 0; k<i-1; k++){
            if(arr[k] > arr[k+1]){
                int temp = arr[k];
                arr[k] = arr[k+1];
                arr[k+1] = temp;
            }
        }
        recursiveBubbleSort(arr, i-1);
    }
}
