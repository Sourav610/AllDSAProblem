package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/*
 * You are given an array of integers nums, there is a sliding window of size k which is moving 
 * from the very left of the array to the very right. You can only see the k numbers in the window.
 *  Each time the sliding window moves right by one position.

Return the max sliding window.
 */

public class SlidingWindowMax {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        int n = Integer.parseInt(br.readLine());
        int[]arr = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the key value: ");
        int k = Integer.parseInt(br.readLine());
        
        int[]ans ={};
        ans = maxSlidingWindow(arr,k);
        // ans = solveSlidingMax(arr,k);
        System.out.println("The ans is: ");
        for(int i = 0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
    }

    /*
     * Optimize approach:
     * We address this problem with the help of a data structure that keeps checking whether the incoming element is larger
     *  than the already present elements. This could be implemented with the help of a de-queue. 
     * When shifting our window, we push the new element in from the rear of our de-queue.
Every time before entering a new element, we first need to check whether the element present
 at the front is out of bounds of our present window size. If so, we need to pop that out. 
 Also, we need to check from the rear that the element present is smaller than the incoming element. 
 If yes, there’s no point storing them and hence we pop them out. Finally, the element present at the front would be our largest element.

 T.C - O(N);
 S.C- O(k)
     */

    public static int[] solveSlidingMax(int[]arr, int k){
        Deque<Integer>dq = new ArrayDeque<>();
        int result[] = new int[arr.length-k+1];
        int res = 0;
        for(int i = 0; i<arr.length; i++){
            while(!dq.isEmpty() && dq.peek() == i-k){
                dq.poll();
            }
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i >= k-1){
                result[res++] = arr[dq.peek()];
            }

        }
        return result;
    }

    /*
     * Brute force:
     * T.C - O(n*n)
     * S.C - O(k)
     */

    public static void GetMax(int arr[], int l, int r, ArrayList < Integer > maxx) {
        int i, maxi = Integer.MIN_VALUE;
        for (i = l; i <= r; i++)
            maxi = Math.max(maxi, arr[i]);
        maxx.add(maxi);
    }
    public static int[] maxSlidingWindow(int arr[], int k) {
        int left = 0, right = 0;
        int i, j;
        ArrayList < Integer > maxx = new ArrayList < > ();
        while (right < k - 1) {
            right++;
        }
        while (right < arr.length) {
            GetMax(arr, left, right, maxx);
            left++;
            right++;
        }
        int[]ans = new int[maxx.size()];
        for(int m = 0; m<maxx.size(); m++){
            ans[m] = maxx.get(m);
        }
        return ans;
    }
}
