package Heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInArray {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,k;
        System.out.println("Enter the size of arr: ");
        n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the value of k: ");
        k = Integer.parseInt(br.readLine());

        int ans = 0;
        // ans = findKthLargestElement(arr,k);
        // ans = findKthLargestElementOptimize(arr, k);
        ans = kthLargest(arr,k);
        System.out.println("The "+k+"th largest element is: "+ans);
        
    }

    /*
        Brute Force approach:
        T.c - O(N*log(k))
        S.c - O(log(k))
    */

    public static int findKthLargestElement(int[]arr, int k){
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int i = 0; i<k; i++){
            pq.add(arr[i]);
        }

        for(int i = 0; i<arr.length; i++){
            if(arr[i] > pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
            
        }

        return pq.peek();
    }

    /*
    Choose a random index within the current search range as the pivot to avoid worst-case time complexity.
Partition Around the Pivot:
Swap the pivot element with the leftmost element to simplify the partitioning process.
Move elements greater than the pivot to the left portion of the array.
Move elements smaller than or equal to the pivot to the right portion of the array.
Place the pivot in its correct position, ensuring all larger elements are on its left and all smaller ones are on its right.
If the pivot index matches k-1, the element at this index is the Kth largest and is returned as the answer.
If the pivot index is greater than k-1, search continues in the left portion of the array.
If the pivot index is less than k-1, search continues in the right portion of the array.
The process continues until the Kth largest element is found.

Time Complexity: O(N), where N is the size of the given array.
In the average case (when the pivot is chosen randomly):
Assuming the array gets divided into two equal parts, with every partitioning step, the search range is reduced by half. Thus, the time complexity is O(N + N/2 + N/4 + ... + 1) = O(N).

In the worst-case scenario (when the element at the left or right index is chosen as the pivot):
In such cases, the array is divided into two unequal halves, and the search range is reduced by one element with every partitioning step. 
Thus, the time complexity is O(N + N-1 + N-2 + ... + 1) = O(N2). However, the probability of this worst-case scenario is negligible.

Space Complexity: O(1), as we are modifying the input array in place and using only a constant amount of extra space.
    */

    public static int kthLargest(int []arr, int k){
        if(k > arr.length-1){
            return -1;
        }
        // Pointers to mark the part of working array
        int left = 0, right = arr.length-1;

        // Until the Kth largest element is found
        while(true){
             // Get the pivot index
             int pivotIndex = randomIndex(left,right);

             //update the pivot index
             pivotIndex = partitionAndReturnIndex(arr,pivotIndex,left, right);

             if(pivotIndex == k -1) {
                return arr[pivotIndex];
             }
             else if(pivotIndex > k-1) right = pivotIndex -1;
             else left = pivotIndex+1;
        }

    }

     public static Random rand = new Random();

     public static int randomIndex(int left, int right) {
        // Length of the array
        int len = right - left + 1;
        
        // Return a random index from the array
        return rand.nextInt(len) + left;
    }

    public static int partitionAndReturnIndex(int[]arr,int pivotIndex,int left,int right){
        int pivot = arr[pivotIndex];
        int temp = arr[left];
        arr[left] = arr[pivotIndex];
        arr[pivotIndex] = temp;

        int ind = left+1;

        for(int i = left+1; i<=right; i++){
            if(arr[i] > pivot){
                temp = arr[ind];
                arr[ind] = arr[i];
                arr[i] = temp;
                ind++;
            }
        }

        temp = arr[left];
        arr[left] = arr[ind-1];
        arr[ind-1] = temp;

        return ind-1;

    }

// another code same as above

    public static int findKthLargestElementOptimize(int []arr, int k){
        int left = 0, right = arr.length-1;

        while(left <= right){
            int pivot = arr[left+(int)Math.random()%(right-left+1)];
            int gt = left, i = left, lt = right;
            while(i<= lt){
                if(arr[i] > pivot){
                    int temp = arr[i];
                    arr[i] = arr[gt];
                    arr[gt] = temp;  
                    i++;
                    gt++;          
                }
                else if(arr[i]< pivot){
                    int temp = arr[i];
                    arr[i] = arr[lt];
                    arr[lt] = temp;
                    lt--;
                }
                else{
                    i++;
                }
            }

            if(k-1 < gt){
                right = gt-1;
            }
            else if(k-1 > lt){
                left = lt+1;
            }
            else{
                return pivot;
            }
        }
        return -1;
    }
}
