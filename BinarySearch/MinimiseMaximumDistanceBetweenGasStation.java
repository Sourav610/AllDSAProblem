package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MinimiseMaximumDistanceBetweenGasStation {
    public static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String args[]) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        n = Integer.parseInt(br.readLine());
        double ans = 1;
        int[]arr = new int[n];
        System.out.println("Enter the value of array: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter the number of gas station you want to insert: ");
        int m =  Integer.parseInt(br.readLine());

        // ans = placeGasStation(arr,m);
        // ans = optimizePlaceGasStation(arr,m);
        ans = optimalPlaceGasStation(arr, m);
        System.out.println("The ans is: "+ans);
    }

    public static double placeGasStation(int[]arr, int k){
        int n = arr.length;
        int howMany[] = new int[n-1];

        for(int gasStation = 1; gasStation<=k; gasStation++){
            int maxInd =-1;
            double maxSec = -1;
            for(int i = 0; i<arr.length-1; i++){
                double diff = arr[i+1]-arr[i];
                double secLeng = diff/(double)(howMany[i]+1);
                if(secLeng > maxSec){
                    maxSec = secLeng;
                    maxInd = i;
                }
            }
            howMany[maxInd]++;
        }

        double maxAns = -1;
        for(int i = 0; i<arr.length-1; i++){
            double diff = arr[i+1]-arr[i];
            double secLength = diff/(double)(howMany[i]+1);
            maxAns = Math.max(maxAns,secLength);
        }
        return maxAns;
    }

    public static double optimizePlaceGasStation(int[]arr, int size){
        int n = arr.length;
        int[] howMany = new int[n-1];
        PriorityQueue<Pair>pq = new PriorityQueue<Pair>((a,b)->Double.compare(b.first,a.first));
        for(int i = 0; i<n-1; i++){
            pq.add(new Pair(arr[i+1]-arr[i],i));
        }

        for(int gasSt = 1; gasSt <= size; gasSt++){
            Pair tp = pq.poll();
            int secInd = tp.second;

            howMany[secInd]++;

            double indDiff = arr[secInd+1]-arr[secInd];
            double newSecLen = indDiff/(double)(howMany[secInd]+1);
            pq.add(new Pair(newSecLen, secInd));
        }
        return pq.peek().first;
    }

    //for using binarySearch in this question
    //we will loop for this condition (high-low > 10^-6) and always do low = mid, high = mid;
    public static double optimalPlaceGasStation(int[]arr, int gas){
        int n = arr.length;
        double low = 0;
        double high  = 0;
        for(int i = 0; i<n-1; i++){
            high = Math.max(high, (double)(arr[i+1]-arr[i]));
        }

        double diff = 1e-6;
        while(high-low >diff){
            double mid = (low+high)/(2.0);
            int cnt = noOfGasStReq(mid,arr);
            if(cnt >gas){
                low = mid;
            }
            else{
                high = mid;
            }
        }
        return high;
    }

    public static int noOfGasStReq(double dist, int[]arr){
        int cnt = 0;
        for(int i = 1; i<arr.length; i++){
            int numInBet = (int) ((arr[i]-arr[i-1])/dist);
            if((arr[i]-arr[i-1]) == (numInBet*dist)){
                numInBet--;
            }
            cnt += numInBet;
        }

        return cnt; 
    }
}
