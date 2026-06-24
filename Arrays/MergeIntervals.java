package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        n = Integer.parseInt(br.readLine());

        System.out.println("Enter "+n*2+" element: ");
        int [][]arr = new int[n][2];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<2; j++){
                arr[i][j] = Integer.parseInt(br.readLine());
            }
        }

        List<List<Integer>>ans = new ArrayList<>();
        // ans = mergeIntervals(arr);
        // ans = optimizeMergeIntervals(arr);
        ans = mergeInterval2(arr);

        System.out.println("The array after mergin element: ");
        for (List<Integer> it : ans) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }

    }

    public static List<List<Integer>> mergeIntervals(int[][]arr){
        List<List<Integer>>ans = new ArrayList<>();
    

        for(int i = 0; i<arr.length; i++){
            int start = arr[i][0];
            int end = arr[i][1];

            if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)){
                continue;
            }

            for(int j = i+1;  j<arr.length; j++){
                if(arr[j][0] <= end){
                    end = Math.max(end, arr[j][1]);
                }
                else{
                    break;
                }
            }

            ans.add(Arrays.asList(start,end));
        }

        return ans;
    }

    public static List<List<Integer>> optimizeMergeIntervals(int[][]arr){
        List<List<Integer>>ans = new ArrayList<>();
        Arrays.sort(arr,new Comparator<int[]>(){
            public int compare(int []a, int []b){
                return a[0] - b[0];
            }
        });
    
        for(int i = 0; i<arr.length; i++){
              // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if(ans.isEmpty() || arr[i][0] > ans.get(ans.size()-1).get(1)){
                ans.add(Arrays.asList(arr[i][0],arr[i][1]));
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else{
                ans.get(ans.size()-1).set(1,Math.max(ans.get(ans.size()-1).get(1),arr[i][1]));
            }
        }
        return ans;
    }

    public static List<List<Integer>> mergeInterval2(int[][]arr){
        Arrays.sort(arr,(a,b) ->Integer.compare(a[0], b[0]));
        //if arr is list the sorting will be like below
        //arr.sort((a,b)->Integer.compare(a.get(0),b.get(0)));
        List<List<Integer>>ans = new ArrayList<>();

        int i = 0, j = 0;
        while(i<arr.length){
            int start = arr[i][0];
            int end = arr[i][1];
            j = i+1;

            while(j<arr.length && end >= arr[j][0]){
                start = Math.min(start,arr[j][0]);
                end = Math.max(end,arr[j][1]);
                j++;
            }
            ans.add(Arrays.asList(start,end));
            i = j;
        }
        return ans;
    }
}
