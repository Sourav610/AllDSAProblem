package Greedy;

import java.util.Arrays;

public class MinimumNumOfPlatFromReqForRailway {
    public static void main(String[] args) {
        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};

        int ans = 0;
        // ans = calculateMinPlatform(arr,dep);
        ans = calculateMinPlatformOptimize(arr,dep);
        System.out.println("Minimum number of Platforms required " +ans);
    }

    public static int calculateMinPlatform(int[]arr,int[]dep){
        int maxCount = 0;
        for(int i = 0; i<arr.length; i++){
            int count = 0;
            for(int j = 0; j<arr.length; j++){
                if((arr[i] >= arr[j] && arr[i] <=dep[j]) || (arr[j] >= arr[i]&& arr[j] <= dep[i])){
                    count++;
                }
            }
            maxCount = Math.max(count,maxCount);
        }
        return maxCount;
    }

    /*
     Each train has an arrival and departure time. We need to find the maximum number of trains that are at the station at the same time which will tells us how many platforms are needed. If we sort arrival and departure times separately, we can simulate the process. A platform is needed when a train arrives before another train departs and a platform is freed when a train departs before or exactly when the next train arrives.
Sort the list of arrival times and the list of departure times separately. Use two indices to walk through the sorted arrival and departure times.
Start with one platform needed and track the maximum platforms required.
If the next train arrives before or at the same time as the earliest departure, increase the platform count and move to the next arrival.
If the next train arrives after the earliest departure, reduce the platform count and move to the next departure.
Keep updating the maximum platform count during this process until all times are processed.

Time Complexity: O(N*logN), we sort both the arrival and departure arrays.
Space Complexity: O(1), constant additional space is used.
    */
    public static int calculateMinPlatformOptimize(int[]arr,int[]dep){
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0, count = 0,minCount = Integer.MIN_VALUE;
        while(i<arr.length && j<dep.length){
            if(arr[i] > dep[j]){
                count--;
                j++;
            }
            else{
                count++;
                i++;
                minCount = Math.max(count,minCount);
            }
        }
        return minCount;
    }
    
}
