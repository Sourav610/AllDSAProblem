package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
The next greater number of a number x is the first greater number to its traversing-order next
 in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
 */

public class NextGreaterElement2 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of first array: ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter "+n+" element: ");
        int[] arr1 = new int[n];
        for(int i = 0; i<n; i++){
            arr1[i] = Integer.parseInt(br.readLine());
        }
        int []ans = {};
        ans = findOptimizeNGECircularArr(arr1);
        System.out.println("The ans is: ");
        for(int i = 0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }

    }
    // This approach is same as nextgreater element 1 just for circular arr we increase the size of arr to two times and use modulo for circular array.
    // * - modula = currentElement%totalsize - it will give 0 if reach last element and give correct index if less than array size.

    public static int[] findOptimizeNGECircularArr(int[]arr){
        int[]ans =new int[arr.length];
        Stack<Integer>st = new Stack();
        int n= arr.length;
        for(int i = 2*n-1; i>= 0; i--){
            while(!st.empty() && st.peek() <= arr[i%n]){
                st.pop();
            }
            if(i<n){
                if(!st.empty()){
                    ans[i] = st.peek();
                }
                else{
                    ans[i] = -1;
                }
            }
            st.push(arr[i%n]);
        }
        return ans;
    }
}
