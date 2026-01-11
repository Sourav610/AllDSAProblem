package Heaps;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SortKSortedArray {
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

        // sortArrayBruteForce(arr,k);
        int ans[] =  sortArrayOpitimize(arr,k);
        for(int i = 0; i<ans.length; i++){
            System.out.println(ans[i]+" ");
        }
        
        
    }

    public static void sortArrayBruteForce(int[]arr, int k){
        for(int i = 0; i<arr.length; i++){
            for(int j = 1; j<arr.length; j++){
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /*
    
    This approach is built around the core idea of a k-sorted array — where each element is at most k positions away from its correct place.
     This means that the smallest element in the array must exist somewhere in the first k + 1 elements.

So instead of sorting the entire array, we can use a min heap to efficiently keep track of the smallest elements in a 
moving window of size k + 1.

By inserting the first k + 1 elements into the heap, we ensure the smallest element among them bubbles to the top. We then remove it
 and append it to the result. As we move forward, we keep adding new elements into the heap while removing the smallest (root).
  This way, we always process the next smallest valid number and build the sorted result — while leveraging the k-distance constraint
   for efficiency. This drastically reduces the time complexity compared to sorting the entire array.
Initialize an empty min heap
Insert the first k + 1 elements from the array into the heap
Start from the (k + 1)th element and iterate through the array
In each step, remove the smallest element from the heap and append it to the result
Push the current array element into the heap
After processing the full array, remove all remaining elements from the heap and append them to the result
Return the final result array

    */

    public static int[] sortArrayOpitimize(int[]arr,int k){
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        int ans[] = new int[arr.length];
        int j = 0;
        for(int i = 0; i<arr.length; i++){
            pq.add(arr[i]);
            if(pq.size() > k){
                ans[j++] = pq.poll();
            }
        }

        while(!pq.isEmpty()){
            ans[j++] = pq.poll();
        }
        return ans;
    }
}
