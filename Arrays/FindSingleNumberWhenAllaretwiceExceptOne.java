package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.*;

public class FindSingleNumberWhenAllaretwiceExceptOne {
    public static void main(String[] args) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        System.out.print("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        FirstApproach(arr);
        //using xor property
        // SecondApproach(arr);
    }

    public static void FirstApproach(int []arr){
        HashMap<Integer,Integer>mp = new HashMap<>();

        for(int i = 0; i<arr.length; i++){
            int value = mp.getOrDefault(arr[i], 0);
            mp.put(arr[i],value+1);
        }

        for(Map.Entry<Integer,Integer> auto : mp.entrySet()){
            if(auto.getValue() == 1){
                System.out.println("the unique number is: "+auto.getKey());
                break;
            }
        }
    }

    public static void SecondApproach(int []arr){
        int xor1 = 0;

        for(int i = 0; i<arr.length; i++){
            xor1 ^= arr[i];
        }
        System.out.println("the unique number is: "+xor1);
    }
}
