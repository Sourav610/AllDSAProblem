package Heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given an array, arr[] of rope lengths, 
connect all ropes into a single rope with the minimum total cost. 
The cost to connect two ropes is the sum of their lengths. 
*/
public class MinimumCostOfRopes {
    public static void main(String[]args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        System.out.println("Enter the size of arr: ");
        n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // int ans  = calculateCost(arr,n);.
        int ans = calculateCostBruteForce(arr, n);
        System.out.println("The minimum cost to create rope is: "+ans);
    }


    /*
    Optimal approach: using heap
    T.C - O(n*log(n))
    s.C - O(n)
    */
    public static int calculateCost(int[]arr,int size){
        if(size < 2){
            return 0;
        }

        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int i = 0; i<size; i++){
            pq.add(arr[i]);
        }
        int cost = 0;
        while(pq.size() > 1){
            int val1 = pq.poll();
            int val2 = pq.poll();
            cost += val1+val2;
            pq.add(val1+val2);
        }
        return cost;
    }

    /*
    Brute force:
    T.C - O(n*2 * log(n))
    S.C - O(n)
    */

    public static int calculateCostBruteForce(int[]arr,int n){
        if(n < 2){
            return 0;
        }
        
        int cost = 0;
        while(n>1){
            Arrays.sort(arr,0,n);
            int val1 = arr[0];
            int val2 = arr[1];
            int res = val1+val2;

            cost += res;
            for(int i = 2; i<n; i++){
                arr[i-2] = arr[i];
            }
            arr[n-2] = res;
            n--;

        }
        return cost;
    }
}
