package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateArray {
    public static void main(String[]args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of an array: ");
        n = Integer.parseInt(br.readLine());
        
        int arr[] = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k;
        System.out.println("Enter number of times you want to rotate the array: ");
        k = Integer.parseInt(br.readLine());
        //bruteForce - left Rotate
        // Rotate(arr, k);

        //optimize - right rotate
        RotateOptimize(arr, k);

        System.out.println("The array after rotating: ");
        for(int i = 0; i<n; i++){
            System.out.print(arr[i]+" ");
        }

    }

    public static void Rotate(int []arr, int k){
        for(int i = 0; i<k; i++){
            int val = arr[0];
            for(int j = 1; j<arr.length; j++){
                arr[j-1] = arr[j];
            }
            arr[arr.length-1] = val;
        }
    }

    public static void RotateOptimize(int []arr, int k){
        int startInd = arr.length - k%arr.length; // taking reminder if k> arr length

        reverse(arr, 0, startInd-1);   
        reverse(arr, startInd, arr.length-1);
        reverse(arr, 0, arr.length-1);
        
    }

    public static void reverse(int []arr, int l, int e){
        while(l<e){
            int temp = arr[l];
            arr[l] = arr[e];
            arr[e]= temp;
            l++;
            e--;
        }
    }
}
