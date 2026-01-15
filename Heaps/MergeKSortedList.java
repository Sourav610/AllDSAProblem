package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}


/*
Approach: Store all values in a list or array and sort it and the create new linked list with sorted value.
Time Complexity:O(N log N) ,We traverse all the nodes once to collect their values, which takes O(N) where N 
is the total number of nodes across all lists. Sorting these N values takes O(N log N). Building the new linked 
list from the sorted array takes O(N). So the overall time complexity is O(N log N).

Space Complexity:O(N) ,We use an additional array to store all the node values, which requires O(N) space.
 Plus, the new merged linked list also takes O(N) space, but since this is the required output,
only the temporary storage is considered extra.

*/
class Solution{
    public ListNode mergeKList(ListNode[] lists){
        List<Integer> values = new ArrayList<>();
        
        for(ListNode head : lists){
            while(head != null){
                values.add(head.val);
                head = head.next;
            }
        }

        Collections.sort(values);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for(int i: values){
            ListNode val = new ListNode(i);
            curr.next = val;
            curr = curr.next;
        }
        return dummy.next;
    }

    /*

    Approach: Instead of extracting all values and sorting them again, we can merge the lists by 
    always picking the smallest current node among all lists. This can be achieved efficiently 
    using a min-heap (or priority queue), where we store the current node of each list and always 
    extract the node with the smallest value. By pushing the next node of the extracted node back 
    into the heap, we ensure that at any point, the heap contains the next smallest potential candidates. 
    This approach avoids unnecessary sorting and leverages the fact that each list is already sorted.
    Create a min-heap that stores the current head node of each list.
    Push the head of each non-empty list into the min-heap.
    Initialize a dummy node to build the resulting merged list.
    While the heap is not empty:
    Pop the node with the smallest value from the heap.
    Append this node to the result list.
    If the popped node has a next node, push it into the heap.
    Return the node next to the dummy as the head of the merged list.
    
    Time Complexity:O(N * log K) ,Where N is the total number of nodes across all K linked lists.
     Each insertion and extraction operation on the min-heap takes O(log K) time,
      and we perform such operations N times (once per node). Hence, the overall time complexity becomes O(N * log K).

    Space Complexity:O(K),The heap stores at most K nodes at any time one from each of the K linked lists.
    Therefore, the auxiliary space used by the priority queue is O(K). The final merged linked list uses O(1)
    extra space if we disregard the output list, as the nodes are rearranged rather than copied.
    */
    public ListNode mergeKListOptimize(ListNode[] lists){
        PriorityQueue<ListNode>pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        for(ListNode i: lists){
            if(i != null){
                pq.add(i);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();
            ListNode head = new ListNode(smallest.val);
            curr.next = head;
            curr = curr.next;
            if(smallest.next != null){
                pq.add(smallest.next);
            }
        }
        return dummy.next;
    }
}

public class MergeKSortedList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);

        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);

        ListNode c = new ListNode(2);
        c.next = new ListNode(6);

        ListNode[] list = new ListNode[]{a,b,c};

        Solution sol = new Solution();
        // ListNode res = sol.mergeKList(list);
        ListNode res = sol.mergeKListOptimize(list);
        
        while(res != null){
            System.out.println(res.val+" ");
            res = res.next;
        }

    }
}
