package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * Given an array of integers arr, your task is to find the Next Smaller Element (NSE) for every element in the array.
The Next Smaller Element for an element x is defined as the first element to the right of x that is smaller than x.

If there is no smaller element to the right, then the NSE is -1.
 */
public class NextSmallesElement {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of first array: ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter "+n+" element: ");
        int[] arr1 = new int[n];
        for(int i = 0; i<n; i++){
            arr1[i] = Integer.parseInt(br.readLine());
        }

        int []ans = {};
        ans = findOptimizeNSEArr(arr1);
        System.out.println("The ans is: ");
        for(int i = 0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
        
    }

    public static int[] findOptimizeNSEArr(int[]arr){
        Stack<Integer>st = new Stack();
        int ans[] = new int[arr.length];
        for(int i = arr.length-1; i>= 0; i--){
            while(!st.empty() && st.peek() > arr[i]){
                System.out.println(0);
                st.pop();
            }
            if(!st.empty()){
                ans[i] = st.peek();
            }
            else{
                ans[i] = -1;
            }
            st.push(arr[i]);
        }
        return ans;
    }
}
