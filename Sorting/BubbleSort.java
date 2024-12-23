package Sorting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort {
   public static void main(String []args)throws IOException{
    int n;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter the size of an array: ");
    n = Integer.parseInt(br.readLine());

    int arr[] = new int[n];
    System.out.println("Enter "+n+" element: ");
    for(int i = 0; i<n; i++){
        arr[i] = Integer.parseInt(br.readLine());
    }

    
    for(int i = 0; i<n; i++){
        for(int j = 1; j<n-i; j++){
            if(arr[j] < arr[j-1]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
            }
        }
    }

    for(int i = 0; i<n; i++){
        System.out.print(arr[i]+" ");
    }

   }

}
