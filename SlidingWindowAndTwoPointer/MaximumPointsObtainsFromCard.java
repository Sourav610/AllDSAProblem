package SlidingWindowAndTwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
*/

public class MaximumPointsObtainsFromCard{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        System.out.println("Enter the size of an array: ");
        n = Integer.parseInt(br.readLine());
        int[]arr = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the value of k: ");
        k = Integer.parseInt(br.readLine());

        int ans = 0;
        ans = findMaximumSumFromCard(arr,k);
        System.out.println("The maximum number of consecutives ones are: "+ans);
    }

    /*
        Approach: we will maintain a window of size k. first fill the window from first index and then we will traverse the window and
        remove one element from the window and add the last index element and take maximum each time.
    */

    public static int findMaximumSumFromCard(int[]arr,int k){
        int i = 0, sum = 0;
        while(i<k){
            sum += arr[i];
            i++;
        }

        int currVal = sum;
        for(int j = k-1; j>= 0; j--){
            currVal -= arr[j];
            currVal += arr[arr.length-k+j];  // length-k+i is maintain the length from last index;
            sum = Math.max(sum,currVal);
        }

        //more simple calculation
        // int j = arr.length-1;
        // i = k-1;
        // while(i>=0){
        //     sum -= arr[i];
        //     sum += arr[j];
        //     currVal = Math.max(currVal,sum);
        //     i--;
        //     j--;
        // }

        return sum;
    }

}