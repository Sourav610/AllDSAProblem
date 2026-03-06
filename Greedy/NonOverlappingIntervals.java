package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals 
you need to remove to make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.
*/
public class NonOverlappingIntervals{
    public static void main(String[]args){
        int[][]arr = {
            {1,2},
            {2,3},
            {3,4},
            {1,3}
        };

        int ans = 0;
        // ans = calculateMinRemoval(arr,arr.length);
        ans = calculateMinRemovalOptimize(arr, arr.length);
        System.out.println("Minimum removal to make interval non overlapping: "+ans);
    }

    /*
        Using bit masking we are creating subsequecen like 000, 001,010,100,101,110,111 for n = 3;
        and then cheking overlap and taking the size of non overlap and substracting with arr size.

        T.C - O(2^n * nLogn )
        s.C - O(n)
    */
    public static int calculateMinRemoval(int[][]arr, int n){
        int maxValid = 0;
        
        for(int i = 0; i<(1<<n); i++){
            List<int[]>temp = new ArrayList<>();
            
            for(int j = 0; j<n; j++){
                if((i&(1<<j)) != 0){
                    temp.add(arr[j]);
                }
            }

            temp.sort(Comparator.comparingInt(t -> t[0]));

            boolean isValid = true;
            for(int k = 1; k<temp.size(); k++){
                if(temp.get(k)[0] < temp.get(k-1)[1]){
                    isValid = false;
                    break;
                }
            }

            if(isValid){
                maxValid = Math.max(maxValid,temp.size());
            }
        }

        return n-maxValid;
    }

    /*
        In this approach first sort the element in increasing order of ending time.
        Then check if current element overlap with other element increase the count and else if not 
        overlap then update the prevEnd with new value and continue again.

        T.C - O(n);
        S.C - (1);
    */
    public static int calculateMinRemovalOptimize(int[][]arr,int n){
        Arrays.sort(arr,(a,b) -> a[1]-b[1]);

        int count = 0;
        int prevEnd = arr[0][1];
        for(int i = 1; i<n; i++){
            if(arr[i][0] < prevEnd){
                count++;
            }
            else{
                prevEnd = arr[i][1];
            }
        }
        return count;
    }
}