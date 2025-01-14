package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TwoSum {
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

        System.out.println("Enter the sum you want to check : ");
        int k = Integer.parseInt(br.readLine());

        findIndces(arr, k);
    }

    public static void findIndces(int []arr, int k){
        HashMap<Integer,Integer>mp = new HashMap<>();
        int l  = 0, j = 0;
        for(int i = 0; i<arr.length; i++){
            int cal = k - arr[i];
            if(mp.containsKey(cal)){
                l = i;
                j = mp.get(cal);
                break;
            }
            else{
                mp.put(arr[i], i);
            }
        }

        System.out.println("the two indices whose sum is "+k+" is: "+l+" "+j);
    }
}
