package Greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class JumpGame{
    /*
    You are given an integer array nums. You are initially positioned at the array's first index,
     and each element in the array represents your maximum jump length at that position.

        Return true if you can reach the last index, or false otherwise
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter "+n+" element: ");
        int[]arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        boolean[]dp = new boolean[n];

        boolean ans = false;
        // ans = checkJump(0,arr);
        // ans = checkJumpMemo(0,arr,dp);
        // ans = checkJumpBottomUp(arr);
        ans = checkJumpOptimize(arr);
        System.out.println("can we reach the end: "+ans);

    }

    /*
        T.C - exponential
        S.C - O(n)
    */
    public static boolean checkJump(int i, int[]arr){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] == 0){
            return false;
        }

        for(int j = 1; j<= arr[i]; j++){
            if(checkJump(i+j, arr))return true;
        }
        return false;
    }

    /*
        T.C - O(n*n)
        s.C - O(n*n)
    */
    public static boolean checkJumpMemo(int i, int[]arr,boolean[]dp){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] == 0){
            return dp[i] = false;
        }

        for(int j = 1; j<= arr[i]; j++){
            if(checkJump(i+j, arr))return dp[i] = true;
        }
        return dp[i] = false;
    }

    public static boolean checkJumpBottomUp(int[]arr){
        boolean[] dp = new boolean[arr.length+1];
        dp[arr.length-1] = true;

        for(int i = arr.length-2; i>= 0; i--){
            for(int j = 1; j<= arr[i] && i+j<arr.length; j++){
                if(dp[i+j]){
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }

    /*
        T.c - O(n);
        S.C - O(1)
    */
    public static boolean checkJumpOptimize(int[]arr){
        int maxRange = 0;
        for(int i = 0; i<arr.length; i++){
            if(i> maxRange)return false;
            maxRange = Math.max(maxRange,i+arr[i]);
        }
        return maxRange !=0;
    }
}