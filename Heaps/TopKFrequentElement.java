package Heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Collection;

class Pair{
    int a;
    int b;
    Pair(){

    }

    Pair(int i,int j){
        a = i;
        b = j;
    }

    int getKey(){
        return a;
    }

    int getValue(){
        return b;
    }
}

public class TopKFrequentElement {
    int[]unique;
    Map<Integer,Integer>freq = new HashMap<>();
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of an array: ");
        int n= Integer.parseInt(br.readLine());
        int[]arr = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter the value of k: ");
        int k = Integer.parseInt(br.readLine());

        // int[]ans = calculateTopKFrequent(arr,k);
        TopKFrequentElement topEle = new TopKFrequentElement();
        int[]ans = topEle.topKElementOptimize(arr,k);
        System.out.println("The top "+k+"frequent element are: ");
        for(int i = 0; i<k; i++){
            System.out.print(ans[i]+" ");
        }
    }


    /*
        T.C - O(N+N log K);
        S.C - O(N+k)
    */
    public static int[] calculateTopKFrequent(int[]arr,int k){
        Map<Integer,Integer>mp = new HashMap<>();
        PriorityQueue<Pair>pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        for(int i = 0; i<arr.length; i++){
            mp.put(arr[i],mp.getOrDefault(arr[i], 0)+1);
        }
        for(Map.Entry<Integer,Integer>val :mp.entrySet()){
            pq.offer(new Pair(val.getValue(),val.getKey()));
            if(pq.size()> k){
                pq.poll();
            }
        }
        int ans[] = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            ans[i] = pq.poll().getValue();
            i++;
        }
        return ans;
    }

    /*
        Optimize approach: 
        Quickselect is a textbook algorithm typically used to solve the problems "find kth something": kth smallest,
         kth largest, kth most frequent, kth less frequent, etc. Like quicksort, quickselect was developed by 
         Tony Hoare and is also known as Hoare's selection algorithm.

        It has O(N) average time complexity and is widely used in practice. It is worth noting that its worst-case 
        time complexity is O(N*2), although the probability of this worst-case is negligible.

    */

    public int[] topKElementOptimize(int[]arr,int k){
        for(int i = 0; i<arr.length; i++){
            freq.put(arr[i],freq.getOrDefault(arr[i], 0)+1);
        }
        int l = 0;
        int lengthVal = freq.size();
        unique = new int[lengthVal];
        for(int key :freq.keySet()){
            unique[l] = key;
            l++;
        }
        quickselect(0, lengthVal-1, lengthVal-k);
        return Arrays.copyOfRange(unique,lengthVal-k,lengthVal);

    }

    public void quickselect(int left,int right, int kSmallest){
        if(left == right){
            return;
        }
        int pivotIndex = left+(int)Math.random()%(right-left+1);
        pivotIndex = partition(left,right,pivotIndex);
        if(kSmallest == pivotIndex){
            return;
        }
        else if(kSmallest<pivotIndex){
            quickselect(left, pivotIndex-1, kSmallest);
        }
        else{
            quickselect(pivotIndex+1, right, kSmallest);
        }

    }

    public int partition(int left,int right, int pivotIndex){
        int pivotFreq = freq.get(unique[pivotIndex]);
        swap(pivotIndex,right);
        int startInd = left;
        for(int i = left; i<=right; i++){
            if(freq.get(unique[i])<pivotFreq){
                swap(startInd,i);
                startInd++;
            }
        }

        swap(startInd,right);
        return startInd;
    }

    void swap(int l,int k){
        int temp = unique[l];
        unique[l] = unique[k];
        unique[k] = temp;
    }

}
