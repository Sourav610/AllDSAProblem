package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/*
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 */
public class NextGreaterElement1 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of first array: ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter "+n+" element: ");
        int[] arr1 = new int[n];
        for(int i = 0; i<n; i++){
            arr1[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter the size of second array: ");
        int m = Integer.parseInt(br.readLine());
        System.out.println("Enter "+m+" element: ");
        int[] arr2 = new int[m];
        for(int i = 0; i<m; i++){
            arr2[i] = Integer.parseInt(br.readLine());
        }

        int []ans = {};
        // ans = findNGE(arr1,arr2);

        // ans = findOptimizeNGE(arr1,arr2);
        ans = findOptimizeNGECircularArr(arr1,arr2);
        System.out.println("The ans is: ");
        for(int i = 0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
        


    }

    /*
     * Brute force approach:
     * T.C - O(N*M);
     * S.C - O(1) not considering ans array.
     */
    public static int[] findNGE(int[]arr1, int[]arr2){
        int[]ans = new int[arr1.length];
        for(int i = 0; i<arr1.length; i++){
            int currInd = -1;
            int find = 0;
            for(int j = 0; j<arr2.length;j++){
                if(arr1[i] == arr2[j]){
                    currInd = j;
                }
                if(currInd != -1){
                    if(currInd != j && arr2[j] > arr2[currInd]){
                        ans[i] = arr2[j];
                        find = 1;
                        break;
                    }
                }
                
            }

            if(find == 0){
                ans[i] = -1;
            }
        }
        return ans;
    }

    /*
     * Approach: Monotonic Stack
     * -  we will store the greater element stack and for each element we will check if the top element is greater or less
     * if less remove and if greater add the value to ans and push the new element.
     * if stack is empty then ans will be -1
     * 
     * T.C - O(n+m)
     * S.c - O(n)
     */
    public static int[] findOptimizeNGE(int[]arr1, int[]arr2){
        Stack<Integer>st = new Stack();
        int[]indArr = new int[10001];
        for(int i = arr2.length-1; i>= 0; i--){
            while(!st.empty() && st.peek() < arr2[i]){
                st.pop();
            }
            indArr[arr2[i]] = st.empty()?-1:st.peek();
            st.push(arr2[i]);
        } 

        for(int i = 0; i<arr1.length; i++){
            arr1[i] = indArr[arr1[i]];
        }
        return arr1;
    }

    /*
     * This approach is same as above just for circular arr we increase the size of arr to two times and use modulo for circular array.
     * - modula = currentElement%totalsize - it will give 0 if reach last element and give correct index if less than array size.
     */
    public static int[] findOptimizeNGECircularArr(int[]arr1, int[]arr2){
        Stack<Integer>st = new Stack();
        int[]indArr = new int[10001];
        int n = arr2.length;
        for(int i = 2*n-1; i>= 0; i--){
            while(!st.empty() && st.peek() <= arr2[i%n]){
                st.pop();
            }
            if (i < n) {
                if (st.isEmpty() == false) indArr[arr2[i%n]] = st.peek();
                else indArr[arr2[i%n]] = -1;
            }
            st.push(arr2[i%n]);
        } 

        for(int i = 0; i<arr1.length; i++){
            arr1[i] = indArr[arr1[i]];
        }
        return arr1;
    }
}
