package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/*
 * Given an array of integers heights representing the histogram's bar height
 *  where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 */

public class LargestRectangleInHistogram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of an array: ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter "+n+" element: ");
        int[]arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans= 0;
        // ans = findLargestRectangle(arr,n);
        // ans = findOptimizeLargetRectangle(arr,n);
        ans = findLargestRectangleUsingOnePass(arr, n);
        
        System.out.println("The ans is: "+ans);
    }

    public static int findLargestRectangle(int[]arr, int n){
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            int minHeight = Integer.MAX_VALUE;
            for(int j = i; j<n; j++){
                minHeight = Math.min(minHeight,arr[j]);
                maxArea = Math.max(maxArea,minHeight*(j-i+1));
            }
        }
        return maxArea;
    }

    /*
     * The intuition behind the approach is the same as finding the smaller element on
     *  both sides but in an optimized way using the concept of the next greater element
     *  and the next smaller element.
     * 
     * So for each element we will find previous smaller and next smaller element and finally we will calculate the area.
     */
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

    /*

      Intution: This approach is a single pass approach instead of a two-pass approach. 
      When we traverse the array by finding the next greater element, we found that 
      some elements were inserted into the stack which signifies that after them the smallest element is themselves
    So we can find the area of the rectangle by using arr[i] * (right smaller - left smaller -1 ).

     * we will use same approach of next smaller element. while calculating next small the stack will be in increasing order
     * so for particular index if we find stack top value is large that mean current index is right smaller and after pop out
     * the element the top will be the previous smaller. use this we calculate the are in single pass.
     */
    public static int findLargestRectangleUsingOnePass(int[]arr,int n){
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer>st = new Stack<>();
        for(int i = 0; i<= n; i++){
            while(!st.empty() && (i == n || arr[st.peek()] >= arr[i])){
                int height = arr[st.peek()];
                st.pop();
                int width=0;
                if(st.empty()){
                    width = i;
                }
                else{
                    width = i-st.peek()-1;
                }
                maxArea = Math.max(maxArea,width*height);
            }
            st.push(i);
        }
        return maxArea;
    }

}
