package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*

Problem Statement: There is one meeting room in a firm. You are given two arrays, start and end
 each of size N. For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i] 
 will denote the ending time of the ith meeting. Find the maximum number of meetings that can be accommodated
  if only one meeting can happen in the room at a particular time. Print the order in which these meetings will be performed.
*/

public class NmeetingInOneRoom {
    public static void main(String[]args){
          int[] start = {1, 3, 0, 5, 8, 5};
        int[] end   = {2, 4, 6, 7, 9, 9};


        /*
            Approach: alwys sort by end time as after end only the next start meeting happend
            Time Complexity: O(N*logN) + O(N), We sort the entire start and end time array and then iterate over every interval one by one.
Space Complexity: O(N), additional space used to store tuple of start time, end time and index.

        */
        List<Integer> res = new ArrayList<>();
        List<int[]>meeting = new ArrayList<>();
        for(int i = 0; i<start.length; i++){
            meeting.add(new int[]{end[i],start[i],i+1});
        }

        meeting.sort(Comparator.comparingInt(a -> a[0]));
        int lastEnd = -1;
        for(int[] i:meeting){
            if(i[1] > lastEnd){
                res.add(i[2]);
                lastEnd = i[0];
            }
        }

        for (int idx : res) {
            System.out.print(idx + " ");
        }
    }

}
