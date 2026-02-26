package Greedy;

/*
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Candy {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of arr: ");
        int n = Integer.parseInt(br.readLine());
        int range[] = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            range[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        // ans = countMinCandies(range);
        ans = countMinCandiesOptimize(range);
        System.out.println("The minimum candies required: "+ans);
    }

    public static int countMinCandies(int[]range){
        int[]ans = new int[range.length];
        for(int i = 0; i<ans.length; i++){
            ans[i] = 1;
        }

        for(int i = 1; i<range.length; i++){
            if(range[i] > range[i-1]){
                ans[i] = ans[i-1]+1;
            }
        }

        for(int j = range.length-2; j>=0; j--){
            if(range[j] > range[j+1] && ans[j] <= ans[j+1]){
                ans[j] = ans[j+1]+1;
            }
        }

        int count = 0;
        for(int i = 0; i<ans.length; i++){
            count += ans[i];
        }
        return count;
    }

    /*
    
        Treat the ratings as a combination of increasing and decreasing slopes. 
        At every peak (where the slope changes from increasing to decreasing), we need 
        to give the maximum number of candies. For valleys (local minima), the child should 
        always get 1 candy. The idea is to simulate the shape of the slope: while going up,
         increase candies; while going down, also increase a counter (valley depth). 
         To avoid double-counting the peak (which is counted from both sides),
          we subtract the smaller of the two slope heights.
        Start with giving 1 candy to each child, so initialize total candies with size of ratings.
        Iterate through the ratings from left to right using an index.
        If current rating equals the previous one, move ahead (as each already has 1 candy).
        If there's an increasing slope (current rating > previous rating):
        Count the increasing slope length (peak height).
        For each step up, add increasing value of candies to total.
        If there's a decreasing slope (current rating < previous rating):
        Count the decreasing slope length (valley depth).
        For each step down, add increasing value of candies to total.
        After one increasing and decreasing slope, subtract the smaller of the peak 
        and valley (as the peak child was double-counted).
        Continue this process until the end of the array.
        Return the total candies at the end.
    */

    public static int countMinCandiesOptimize(int[]range){
        int n = range.length;
        int i = 1;
        int count = n;

        while(i<n){
            if(range[i] == range[i-1]){
                i++;
                continue;
            }

            int peek = 0;
            while(i<n && range[i] > range[i-1]){
                peek++;
                count += peek;
                i++;
            }

            int valley = 0;
            while(i<n && range[i] < range[i-1]){
                valley++;
                count += valley;
                i++;
            }
            count -= Math.min(peek,valley);
        }
        return count;
    }
}
