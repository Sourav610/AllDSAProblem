package  Heaps;
import java.util.PriorityQueue;

/*

You are part of a university admissions office and need to keep track of the kth highest 
test score from applicants in real-time. This helps to determine cut-off marks for interviews 
and admissions dynamically as new applicants submit their scores.

You are tasked to implement a class which, for a given integer k, maintains a stream of test 
scores and continuously returns the kth highest test score after a new score has been submitted.
 More specifically, we are looking for the kth highest score in the sorted list of all scores.

Implement the KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of test scores nums.
int add(int val) Adds a new test score val to the stream and returns the element representing the kth
 largest element in the pool of test scores so far.*/

/* 
 Time Complexity: O(log k), per insertion each insertion into the min-heap takes O(log k) time. 
  qqSince we maintain a heap of at most k elements, both inserting a new number and removing the smallest (if needed) are log k operations.

Space Complexity:O(k),The min-heap stores only the top k largest elements at any time. So space usage is proportional to k.

*/
class Solution {
    // Min-heap to store top k elements
    PriorityQueue<Integer> minHeap;
    int size;

    // Constructor to initialize heap with initial elements
    public Solution(int k, int[] nums) {
        size = k;
        minHeap = new PriorityQueue<>();

        // Add numbers to heap
        for (int num : nums) {
            minHeap.offer(num);

            // If heap exceeds k, remove the smallest
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    // Adds new value to stream and returns k-th largest
    public int add(int val) {
        // Add new element
        minHeap.offer(val);

        // Maintain size of k
        if (minHeap.size() > size) {
            minHeap.poll();
        }

        // Return root (k-th largest)
        return minHeap.peek();
    }
}

// Driver class
public class KthLargestElementInStream {
    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        Solution kthLargest = new Solution(3, nums);
        System.out.println(kthLargest.add(3));   // Output: 4
        System.out.println(kthLargest.add(5));   // Output: 5
        System.out.println(kthLargest.add(10));  // Output: 5
        System.out.println(kthLargest.add(9));   // Output: 8
        System.out.println(kthLargest.add(4));   // Output: 8
    }
}
