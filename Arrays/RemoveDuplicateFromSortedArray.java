package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDuplicateFromSortedArray {
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

        int k = RemoveDuplicate(arr);
        System.out.println("Array after remove duplicates: ");
        for(int i = 0; i<=k; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static int RemoveDuplicate(int []arr){
        int i = 0, j = 1;
        if(arr.length == 0){
            return 0;
        }
        while(i<arr.length-1 && j < arr.length){   
            if(arr[i] != arr[j]){
                arr[i+1] = arr[j];
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return i;
    }
}
