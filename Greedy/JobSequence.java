package Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

public class JobSequence {
    public static void main(String[] args) {
        int[]deadline = new int[]{4,1,1,1};
        int[]profit = {20,10,40,30};

        int[]ans = {};
        // ans = calculateMaxProfit(deadline,profit);
        ans = calculateMaxProfitAlternate(deadline, profit);
        System.out.println("The maximum profit is: "+ans[0]+" "+ans[1]);
    }


    /* 
        Using priority queue size as duration e.g - 1 size 1 duarion 2 size - 2 duration like and if same duration 
        updating the maxProfit

        T.C - O(n * log(n)) Time and O(n) Space
    */ 
    public static int[] calculateMaxProfit(int[]deadline,int[]profit){
        List<int[]>job = new ArrayList<>();
        for(int i = 0; i<deadline.length; i++){
            job.add(new int[]{deadline[i],profit[i]});
        }

        job.sort(Comparator.comparingInt(a ->a[0]));

        PriorityQueue<Integer>pq = new PriorityQueue();
        
        for(int[] j: job){
            // System.out.println("Test: "+j[0]+" "+j[1]);
            if(j[0] > pq.size()){
                pq.add(j[1]);
            }
            else if(!pq.isEmpty() && pq.peek() < j[1]){
                pq.poll();
                pq.add(j[1]);
            }
        }

        int profitVal = 0;
        int count = 0;
        while(!pq.isEmpty()){
            profitVal += pq.poll();
            count++;
        }
        
        return new int[]{count,profitVal};

    }

    public static int[] calculateMaxProfitAlternate(int[]deadline,int[]profit){
        List<int[]>job = new ArrayList<>();
        int maxVal = -1;
        for(int i = 0; i<deadline.length; i++){
            job.add(new int[]{profit[i],deadline[i]});
            maxVal = Math.max(maxVal,deadline[i]);
        }

        job.sort(Comparator.comparingInt((int[]a) ->a[0]).reversed());
        int timeOut[] = new int[maxVal];
        for(int i = 0; i<maxVal; i++){
            timeOut[i] = -1;
        }
        
        int profitVal = 0;
        int count = 0;
        for(int[] j: job){
            // System.out.println("Test: "+j[0]+" "+j[1]);
            if(timeOut[j[1]-1] == -1){
                timeOut[j[1]-1] = 0;
                profitVal += j[0];
                count++;
            }
            else{
                for(int k = j[1]-1; k>=0; k--){
                    if(timeOut[k] == -1){
                        timeOut[k] = 0;
                        profitVal += j[0];
                        count++;
                        break;
                    }
                }
            }
        }
        
        return new int[]{count,profitVal};

    }
}
