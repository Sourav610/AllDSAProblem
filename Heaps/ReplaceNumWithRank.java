package Heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReplaceNumWithRank {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of an array: ");
        int n= Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans[];
        ans = replaceWithRank(arr);
        // ans = replaceWithRank2(arr);

        for(int i = 0; i<n; i++){
            System.out.print(ans[i]+" ");
        }
    }

    /*
        T.c - O(n+logn)
    */

    public static int[] replaceWithRank(int[]arr){
        int[]temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        

        Map<Integer,Integer>mp = new HashMap<>();
        int k = 1;
        for(int i = 0; i<temp.length; i++){
            if(!mp.containsKey(temp[i])){
                mp.put(temp[i],k);
                k++;
            }
        }

        int ans[] = new int[arr.length];
        for(int i = 0; i<arr.length; i++){
            ans[i] = mp.get(arr[i]);
        }
        return ans;
    }

    public static int[] replaceWithRank2(int[]arr){
        int n = arr.length;
        int[]ans = new int[n];

        for(int i = 0; i<n; i++){
            Set<Integer>smaller= new HashSet<>();
            for(int j = 0; j<n; j++){
                if(arr[j] < arr[i]){
                    smaller.add(arr[j]);
                }
            }
            ans[i] = smaller.size()+1;
        }
        return ans;
    }
    


}
