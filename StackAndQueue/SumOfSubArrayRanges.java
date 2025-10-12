package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class SumOfSubArrayRanges{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of an array: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println("Enter "+n+" element: ");
        int[]arr = new int[n];

        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        long ans = 0; 
        // ans = findSubArrayRange(arr);
        // ans = findOptimizeSubArrayRange(arr);
        ans = findSubArrayRangeUsingSubminAndSubMax(arr);
        System.out.println("The result is : "+ans);

    }

    public static long findSubArrayRange(int[]arr){
        long sum = 0; 
        for(int i = 0; i<arr.length; i++){
            for(int j = i; j<arr.length; j++){
                int minVal = Integer.MAX_VALUE;
                int maxVal = Integer.MIN_VALUE;
                for(int k = i; k<=j; k++){
                    minVal = Math.min(minVal,arr[k]);
                    maxVal = Math.max(maxVal,arr[k]);
                }

                sum += (long)maxVal - (long)minVal;
            }
        }
        return sum;
    }

    public static long findOptimizeSubArrayRange(int[]arr){
        long sum = 0; 
        for(int i = 0; i<arr.length; i++){
            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;
            for(int j = i; j<arr.length; j++){
                minVal = Math.min(minVal,arr[j]);
                maxVal = Math.max(maxVal,arr[j]);
                sum += (long)maxVal - (long)minVal;
            }
        }
        return sum;
    }

    public static long findSubArrayRangeUsingSubminAndSubMax(int[]arr){
        int n =arr.length;
        long sumMin = 0;
        long sumMax = 0;
        int leftMin[] = new int[n];
        int rightMin[] = new int[n];

        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        Arrays.fill(leftMin,-1);
        Arrays.fill(leftMax,-1);
        Arrays.fill(rightMin,n);
        Arrays.fill(rightMax,n);

        Stack<Integer>st = new Stack();

        for(int i = 0; i<n; i++){
            while(!st.empty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(!st.empty()){
                leftMin[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        for(int i = n-1; i>= 0; i--){
            while(!st.empty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(!st.empty()){
                rightMin[i] = st.peek();
            }
            st.push(i);
        }

        for(int i = 0; i<n; i++){
            sumMin += (long)(i-leftMin[i])*(long)(rightMin[i] -i)*(long)arr[i];
        }

        st.clear();

        for(int i = 0; i<n; i++){
            while(!st.empty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            if(!st.empty()){
                leftMax[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        for(int i = n-1; i>= 0; i--){
            while(!st.empty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            if(!st.empty()){
                rightMax[i] = st.peek();
            }
            st.push(i);
        }

        for(int i = 0; i<n; i++){
            sumMax += (long)(i-leftMax[i])*(long)(rightMax[i] -i)*(long)arr[i];
        }

        long ans = sumMax - sumMin;
        return ans;
    }
}