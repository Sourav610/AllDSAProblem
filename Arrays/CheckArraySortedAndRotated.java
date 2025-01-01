package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckArraySortedAndRotated {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        System.out.print("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean val = checkSortedAndRotated(arr);
        System.out.println("The answer is: "+val);
    }

    public static boolean checkSortedAndRotated(int []arr){
        //if sorted element is rotated then there should be only one single break point.
        int flag  = 0;
        for(int i = 1; i<arr.length; i++){
            if(arr[i-1] > arr[i]){
                flag++;
            }
        }
        
        //if array is rotated at some point then the last element should be small then first element.
        if(arr[arr.length-1] > arr[0]){
            flag++;
        }


        return flag <= 1;
    }
}
