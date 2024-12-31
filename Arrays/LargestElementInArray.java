package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestElementInArray {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of an array: ");
        n = Integer.parseInt(br.readLine());

        System.out.print("Enter "+n+" element: ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("the max element from the array is: "+MaxElement(arr));

    }

    public static int MaxElement(int arr[]){
        int val = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > val){
                val = arr[i];
            }
        }
        return val;
    }
}
