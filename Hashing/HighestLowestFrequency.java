package Hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

public class HighestLowestFrequency {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // HighestAndLowestFrequency(arr, n);
        OptimizeFrequencyCheck(arr, n);
    }

    // public static void HighestAndLowestFrequency(int []arr, int size){
    //     boolean []visited = new boolean[size];
    //     int []ans = new int[size];
        
    //     for(int i = 0; i<size; i++){
    //         int ele = arr[i];
    //         int count = 1;
            
    //         int ind = -1;
    //         if(visited[i] == true){
    //             continue;
    //         }
    //         for(int j = i+1; j<size; j++){
    //             if(arr[i] == arr[j]){
    //                 count++;
    //                 visited[j] = true;
    //             }
    //         }
            
    //        ans[i] = count;
    //     }
    //     int maxValue = Integer.MIN_VALUE;
    //     int maxIndex = -1, minIndex = -1;
    //     int minValue = Integer.MAX_VALUE;
    //     for(int i = 0; i<ans.length; i++){
    //         if(ans[i] != -1){
    //             if(ans[i] > maxValue){
    //                 maxValue = ans[i];
    //                 maxIndex = i;
    //             }
    //             if(ans[i] < minValue){
    //                 minValue = ans[i];
    //                 minIndex = i;
    //             }
    //         }
           
    //     }

    //     System.out.println("The highest frequency number is: "+arr[maxIndex]+" with frequency "+maxValue+" with index "+maxIndex);
    //     System.out.println("The lowest frequency number is: "+arr[minIndex]+" with frequency "+minValue+" with index "+minIndex);
    // }

    public static void OptimizeFrequencyCheck(int []arr, int n){
        HashMap<Integer,Integer>mp = new HashMap<>();
        for(int i = 0; i<n; i++){
            int freq = 1;
            if(mp.containsKey(arr[i])){
                freq = mp.get(arr[i]);
                freq++;
            }
            mp.put(arr[i],freq);
        }
        int maxVal = 0;
        int maxKey = 0;
        int minVal = n;
        int minKey = 0;
        for(Map.Entry<Integer,Integer>map : mp.entrySet()){
            int key = map.getKey();
            int val = map.getValue();
            if(val > maxVal){
                maxVal = val;
                maxKey = key;
            }
            if(val < minVal){
                minVal = val;
                minKey = key;
            }
        }
        System.out.println("The highest frequency number is: "+maxKey+" with frequency "+maxVal);
        System.out.println("The lowest frequency number is: "+minKey+" with frequency "+minVal);
    }

}
