package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SubarraySumEqualsK{
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

        System.out.println("Enter the k value: ");
        int k = Integer.parseInt(br.readLine());

        //using prefix sum
        //initiall setting the map value of 0 to 1 as sum -k can be 0
        //storing the sum and its count and adding the count taken from map;
        int count = findSubarraySum(arr,k);

        System.out.println("The count is: "+count);
    }

    public static int findSubarraySum(int []arr, int k){
        int count = 0, sum = 0;
        HashMap<Integer,Integer>mp = new HashMap<>();
        mp.put(0,1);
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];

            int rem = sum -k;

            count += mp.getOrDefault(rem,0);

            if(mp.containsKey(sum)){
                int val =mp.get(sum);
                mp.put(sum, val+1);
            }
            else{
                mp.put(sum,1);
            }
            
        }
        return count;
    }
}