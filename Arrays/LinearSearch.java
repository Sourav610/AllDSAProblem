package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinearSearch {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        n = Integer.parseInt(br.readLine());

        System.out.println("Enter "+n+" element: ");
        int []arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.print("Enter element to be search in arr: ");
        int k = Integer.parseInt(br.readLine());
        Search(arr,k);

    }

    public static void Search(int []arr, int k){
        int ind = -1;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == k){
                ind = i;
                break;
            }
        }
        System.out.println("the index is at: "+ind);
    }
}
