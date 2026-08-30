package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationToReachEnd{
    public static void main(String[]args){
        int start = 3, end = 30;
        int[] arr = {2, 5, 7};

        int ans = calculateMinimum(start,end,arr);

        System.out.println("the minimum multiplication required is: "+ans);
    }

    public static int calculateMinimum(int start, int end, int[]arr){
        int[]dist = new int[1000];
        Arrays.fill(dist,Integer.MAX_VALUE);

        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{start,0});
        dist[start] = 0;
        
        while(!q.isEmpty()){
            int[] val = q.poll();
            int ind = val[0];
            int step = val[1];

            if (ind == end) return step;

            for(int i = 0; i<arr.length; i++){
                int res = (arr[i]*ind)%1000;
                if(step+1 < dist[res]){
                    dist[res] = step+1;
                    q.add(new int[]{res,step+1});
                }
            }
        }

        return -1;
    }
}