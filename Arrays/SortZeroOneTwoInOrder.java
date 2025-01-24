package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortZeroOneTwoInOrder {
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
        //Using three pointer approach
        //l = 0, m = 0, h = n-1, always check m if it is one increment it, if it is two swap with high, if it is zero swap with low
        sort(arr);

        System.out.println("Element after sorting: ");
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void sort(int []arr){
        int l = 0, m = 0, h = arr.length-1;
        while(m<=h){
            if(arr[m] == 2){
                int temp = arr[h];
                arr[h] = arr[m];
                arr[m] = temp;
                h--;
            }
            else if( arr[m] == 0){
                int temp = arr[l];
                arr[l] = arr[m];
                arr[m] = temp;
                l++;
                m++;
            }
            else{
                m++;
            }
        }
    }
}
