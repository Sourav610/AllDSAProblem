package Heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


/*
You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. 
Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, 
but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.

Return the minimum number of CPU intervals required to complete all tasks.

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2

Output: 8

Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

After completing task A, you must wait two intervals before doing A again. 
The same applies to task B. In the 3rd interval, neither A nor B can be done, 
so you idle. By the 4th interval, you can do A again as 2 intervals have passed.

*/
public class TaskSchedule {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,k;
        System.out.println("Enter the size of arr: ");
        n = Integer.parseInt(br.readLine());
        char arr[] = new char[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = br.readLine().charAt(0);
        }

        System.out.println("Enter the value of k: ");
        k = Integer.parseInt(br.readLine());

        int ans = 0;
        ans = calculateTotalTime(arr,k);
        System.out.println("The total time taken to complete the task: "+ans);

    }


    /*
    
    Approach: 1 using heap

    Algorithm
Initialize an array freq of size 26 to store the frequency of each task.
Iterate through the tasks array and update the frequency of each task in the freq array.
Create a priority queue pq and insert the frequencies of the tasks into the queue.
Initialize a variable time to keep track of the total time taken.
While the priority queue is not empty, repeat the following steps:
Initialize a variable cycle to n + 1, which represents the cooling interval plus one (for the current task).
Initialize an empty array store to store frequencies of tasks that still need to be processed.
Initialize a variable taskCount to keep track of the number of tasks processed in the current cycle.
While cycle is greater than 0 and the priority queue is not empty, repeat the following steps:
Decrement cycle.
Pop the top element (task frequency) from the priority queue.
If the popped frequency is greater than 1, decrement it by 1 and store it in the store array.
Increment taskCount as it keeps track of the number of tasks processed in the current cycle.
After processing tasks in the cycle, restore the updated frequencies (stored in the store array) back to the priority queue.
Update the time by adding either taskCount (if the priority queue is empty) or n + 1 (cooling interval) to the total time.
Finally, return the total time

    
    Time Complexity:O(N log K), We count frequencies in O(N) and use a max heap of K unique tasks. 
    Each task can be pushed and popped from the heap multiple times resulting (log K) per operation.

Space Complexity:O(K), We store task frequencies in a hashmap and use a max heap, both taking O(K) 
space where K is the number of unique tasks.
    */
    public static int calculateTotalTime(char[]arr,int k){
        Map<Character,Integer>mp = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }

        //max heap
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<Character,Integer>test : mp.entrySet()){
            pq.add(test.getValue());
        }
        int time = 0;
        while(!pq.isEmpty()){
            List<Integer>temp = new ArrayList<>();
            int cycle = k+1;
            int i = 0;

            while(i<cycle && !pq.isEmpty()){
                int count = pq.poll();
                count--;

                if(count > 0){
                    temp.add(count);
                }

                time++;
                i++;
            }

            for(int j = 0; j<temp.size(); j++){
                pq.add(temp.get(j));
            }

            if(pq.isEmpty()){
                break;
            }
            time += (cycle-i);
        }
        return time;
    }

    /*
    
    Approach 2: Filling the Slots and Sorting
Intuition
We need to find the minimum time required to complete all tasks given the constraint 
that at least n units of time must elapse between two identical tasks. To minimize the time,
 we should first consider scheduling the most frequent tasks so that they are separated by n units of time.
  Then, we can fill the idle slots with the remaining tasks.

Example:
Consider the task list ['A', 'A', 'A', 'B', 'B', 'B'] with n = 2.

Calculate the frequency array: [3, 3, 0, ..., 0], as 'A' appears 3 times and 'B' appears 3 times.
Sort the frequency array in ascending order: [0, 0, ..., 3, 3].
Calculate maxFreq as freq[25] - 1. In this case, maxFreq = 3 - 1 = 2.
Calculate the number of idle slots: idleSlots = maxFreq * n = 2 * 2 = 4.
The loop starts from the second highest frequency (index 24 in the sorted array) and goes down to the lowest frequency.
 This ensures that the highest frequency task's idle slots are considered only once, as it was accounted for when 
 calculating maxFreq in the earlier step.
In each iteration, subtract the minimum of maxFreq and the current frequency from idleSlots. For the first iteration, 
subtract min(2, 2) = 2 from idleSlots, resulting in idleSlots = 4 - 2 = 2.
If idleSlots > 0, add the remaining idle slots to the total number of tasks. In this example, there are 2 idle slots,
 so the final result is obtained by adding these idle slots (2) to the total number of tasks (6).
Thus, the minimum time required to complete all tasks, considering the cooldown period, is 8.

## Algorithm ##

Create a freq array of size 26 to keep track of the count of each task.
Iterate through the tasks array and update the frequency array with the frequency of each task.
Sort the frequency array in non-decreasing order (ascending order = smallest to largest). This is done
 to process tasks with higher frequencies first.
Calculate the maximum frequency of the most frequent task. Subtract 1 because we want to find the number
 of intervals, not the number of occurrences.
Calculate the number of idleSlots that will be required by multiplying the maximum frequency by the cooldown period.
Iterate over the frequency array from the second highest frequency to the lowest frequency.
Subtract the minimum of the maximum frequency and the current frequency from the idleSlots.
If there are any idleSlots left, add them to the total number of tasks and return this as the answer. Otherwise, 
return the total number of tasks.

*/

public int leastInterval(char[] tasks, int n) {
        // Create a frequency array to keep track of the count of each task
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Sort the frequency array in non-decreasing order
        Arrays.sort(freq);
        // Calculate the maximum frequency of any task
        int maxFreq = freq[25] - 1;
        // Calculate the number of idle slots that will be required
        int idleSlots = maxFreq * n;

        // Iterate over the frequency array from the second highest frequency to the lowest frequency
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            // Subtract the minimum of the maximum frequency and the current frequency from the idle slots
            idleSlots -= Math.min(maxFreq, freq[i]);
        }

        // If there are any idle slots left, add them to the total number of tasks
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}
