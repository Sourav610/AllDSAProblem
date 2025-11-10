package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/*
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 */
public class MaximalRectangle {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the row of an array: ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter the col of an array: ");
        int m = Integer.parseInt(br.readLine());

        System.out.println("Enter "+n*m+" element: ");
        int[][]arr = {
            {1,0,1,0,0},
            {1,0,1,1,1},
            {1,1,1,1,1},
            {1,0,0,1,0}
        };
        // for(int i = 0; i<n; i++){
        //     for(int j = 0; j<m; j++){
        //         arr[i][j] = Integer.parseInt(br.readLine());
        //     }
            
        // }


        /*
         * Approach: 
         * we will calculate every column height from first column for that row and in this way that row will represent like a histogram
         * now we can apply largestRectangleInHistogram  approach for each row to calculate its area and take the maximum.
         */
        int[][]prefixSum = new int[n][m];
        for(int i = 0; i<m; i++){
            int sum = 0; 
            for(int j = 0; j<n; j++){
                sum += arr[j][i];
                if(arr[j][i] == 0) sum = 0;
                prefixSum[j][i] = sum;
            }
        }

        int ans = 0;
        for(int i = 0; i<n; i++){
            int val = findOptimizeLargetRectangle(prefixSum[i],m);
            ans = Math.max(ans, val);
        }
        
        System.out.println("The ans is: "+ans);
    }

    public static int findOptimizeLargetRectangle(int[]arr,int n){
        int[]leftSmall = new int[n];
        int[]rightSmall = new int[n];
        Stack<Integer>st = new Stack();
        Arrays.fill(leftSmall,-1);
        Arrays.fill(rightSmall,n);
        for(int i = 0; i<n; i++){
            while(!st.empty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(!st.empty()){
                leftSmall[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        for(int i = n-1; i>= 0; i--){
            while(!st.empty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(!st.empty()){
                rightSmall[i] = st.peek();
            }
            st.push(i);
        }

        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            maxArea = Math.max(maxArea,(rightSmall[i] - leftSmall[i] -1)*arr[i]);
        }
        return maxArea;
    }

}
