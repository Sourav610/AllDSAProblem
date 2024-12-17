package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CountFrequencyOfElement {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the size of array: ");
        n = Integer.parseInt(br.readLine());
        System.out.println("Enter the element: ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        HashMap<Integer,Integer>mp = new HashMap<>();
        for(int i = 0; i<n; i++){
            int freq = 0;
            int key = arr[i];
            if(mp.containsKey(arr[i])){
                freq = mp.get(arr[i]);
            }
            freq++;
            mp.put(key, freq);

        }

        System.out.println("Enter the number for which you want count: ");
        int k = Integer.parseInt(br.readLine());

        System.out.println("The count is: "+mp.get(k));
    }
}
