package Heaps;

import java.util.Arrays;
import java.util.Scanner;

/*
You are given an integer array coins representing coins of different denominations and an integer
 amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
*/
public class CoinChange {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of arr: ");
        int n = Integer.parseInt(sc.nextLine());
        int arr[] = new int[n];
        System.out.println("Enter "+n+" value: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.println("Enter the value of K: ");
        int k = Integer.parseInt(sc.nextLine());

        int ans = 0;
        // ans = calculateCoinChange(arr.length-1,arr,k);
        int[][]dp = new int[n][k+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        // ans = calculateCoinChangeMemoize(n-1, arr, k,dp);
        // ans = calculateCoinChangeBottomUp(arr,k);
        ans = calculateCoinChangeBottomUpSpaceOptimize(arr,k);
        if(ans == 1e9){
            ans = -1;
        }
        System.out.println("The minimum no. of coins req: "+ans);
        
    }

    /*
    T.C - >> O(2^n) so it is exponential
    S.C - O(target);
    */
    public static int calculateCoinChange(int ind, int[]arr,int k){
        if(ind == 0){
            if(k%arr[ind] == 0){
                return k/arr[ind];
            }
            return (int)1e9;
        }

        int take = Integer.MAX_VALUE;
        if(arr[ind]<k){
            take = 1+calculateCoinChange(ind, arr, k-arr[ind]);
        }
        int notTake = 0+calculateCoinChange(ind-1, arr, k);
        return Math.min(take,notTake);
    }


    /*
        T.C - O(n*k)
        S.C - O(n*k)+O(k)
    */

    public static int calculateCoinChangeMemoize(int ind, int[]arr,int k,int[][]dp){
        if(ind == 0){
            if(k%arr[ind] == 0){
                return k/arr[ind];
            }
            return (int)1e9;
        }
        if(dp[ind][k] != -1){
            return dp[ind][k];
        }
        int take = Integer.MAX_VALUE;
        if(arr[ind]<k){
            take = 1+calculateCoinChangeMemoize(ind, arr, k-arr[ind],dp);
        }
        int notTake = 0+calculateCoinChangeMemoize(ind-1, arr, k,dp);
        return dp[ind][k] = Math.min(take,notTake);
    }

    public static int calculateCoinChangeBottomUp(int[]arr,int k){
        int[][]dp = new int[k+1][k+1];

        for(int i =0; i<=k; i++){
            if(i%arr[0] == 0){
                dp[0][i] = i/arr[0];
            }
            else{
                dp[0][i] = (int)1e9;
            }
        }

        for(int i = 1; i<arr.length; i++){
            for(int j = 0; j<= k; j++){
                int take = Integer.MAX_VALUE;
                if(arr[i]<j){
                    take = 1+dp[i][j-arr[i]];
                }
                int notTake = 0+dp[i-1][j];
                dp[i][j] = Math.min(take,notTake);
            }
        }

        int res = dp[arr.length-1][k];
        return res;
    }


    public static int calculateCoinChangeBottomUpSpaceOptimize(int[]arr,int k){
        int[]prev = new int[k+1];
        int[]curr = new int[k+1];

        for(int i =0; i<=k; i++){
            if(i%arr[0] == 0){
                prev[i] = i/arr[0];
            }
            else{
                prev[i] = (int)1e9;
            }
        }

        for(int i = 1; i<arr.length; i++){
            for(int j = 0; j<= k; j++){
                int take = Integer.MAX_VALUE;
                if(arr[i]<j){
                    take = 1+curr[j-arr[i]];
                }
                int notTake = 0+prev[j];
                curr[j] = Math.min(take,notTake);
            }
            prev = curr;
        }

        int res = prev[k];
        return res;
    }
}
