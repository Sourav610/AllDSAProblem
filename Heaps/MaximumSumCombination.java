package Heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumSumCombination {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        System.out.println("Enter the size of arr: ");
        n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int val[] = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            val[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the value of k: ");
        int k = Integer.parseInt(br.readLine());

        List<Integer>ans = new ArrayList<>();
        // ans = calculateSum(arr,val,k);
        ans = calculateSumOptimize(arr, val, k);

        System.out.println("The answer is: ");
        for(int i = 0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }

    }

    public static ArrayList<Integer> calculateSum(int[]arr,int[]val, int k){
        int n = arr.length;
        List<Integer>ans = new ArrayList<Integer>();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                int sum = arr[i]+val[j];
                ans.add(sum);
            }
        }

        Collections.sort(ans,Collections.reverseOrder());

        ArrayList<Integer>temp = new ArrayList<>();
        for(int i = 0; i<k; i++){
            temp.add(ans.get(i));
        }
        return temp;
    }

    public static ArrayList<Integer>calculateSumOptimize(int[]arr,int[]val,int k){
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(val);

        PriorityQueue<int[]>pq= new PriorityQueue<>(
            (a,b) -> b[0]-a[0]
        );
        pq.offer(new int[]{arr[n-1]+val[n-1],n-1,n-1});

        ArrayList<Integer>res = new ArrayList<>();
        HashSet<String>visited = new HashSet<>();
        visited.add((n-1)+","+(n-1));

        while(res.size()<k && !pq.isEmpty()){
            int[]temp = pq.poll();
            int sum = temp[0];
            int i = temp[1];
            int j = temp[2];
            res.add(sum);
            if(i-1 >= 0 && !visited.contains(((i-1)+","+j))){
                pq.offer(new int[]{arr[i-1]+val[j],i-1,j});
                visited.add((i-1)+","+j);
            }

            if(j-1 >= 0 && !visited.contains((i+","+(j-1)))){
                pq.offer(new int[]{arr[i]+val[j-1],i,j-1});
                visited.add(i+","+(j-1));
            }

        }
        return res;
    }

}
