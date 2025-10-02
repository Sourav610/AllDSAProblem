package StackAndQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrappingRainWaterProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter "+n+" element: ");
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        // ans = countTrapWater(arr);
        // ans = optimizeCountTrapWater(arr);
        ans = countTrapWaterUsingTwoPointer(arr);

        System.out.println("The total trap water is: "+ans);

    }

    /*
     * Approach:
     *  For each index, we have to find the amount of water that can be stored and we have to sum it up.If we observe carefully the amount the water stored at a 
     * particular index is the minimum of maximum elevation to the left and right of the index minus the elevation at that index.
     * 
     * T.C - O(N*N)
     * S.C - O(1)
     */

    public static int countTrapWater(int[]arr){
        int ans = 0; 
        int n = arr.length;

        for(int i = 0; i<n; i++){
            int left = 0, right = 0; 
            int j = i;
            while(j>= 0){
                left = Math.max(left, arr[j]);
                j--;
            }
            j = i;
            while(j<n){
                right = Math.max(right,arr[j]);
                j++;
            }
            ans += Math.min(left,right) - arr[i];
        }
        return ans;
    }

    /*
     * Same Approach as first, but we will calculate left maxium, right maximum of each index previously then we will go through loop and calculate 
     * the trap water.
     * T.c - O(3*n);
     * S.C - O(n) + O(n)
     */

    public static int optimizeCountTrapWater(int[]arr){
        int ans= 0; 
        int n = arr.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0] = arr[0];
        suffix[n-1] = arr[n-1];
        for(int i = 1; i<n; i++){
            prefix[i] = Math.max(prefix[i-1],arr[i]);
        }

        for(int j = n-2; j>= 0; j--){
            suffix[j] = Math.max(suffix[j+1],arr[j]);
        }

        for(int i = 0; i<n; i++){
            ans += Math.min(prefix[i],suffix[i])-arr[i];
        }
        return ans;
    }

    /*
     * 
     * Solution 3:Optimal Solution(Two pointer approach)

Approach: Take 2 pointers l(left pointer) and r(right pointer) pointing to 0th and (n-1)th index respectively. 
    Take two variables leftMax and rightMax and initialize them to 0. If height[l] is less than or equal to height[r] 
    then if leftMax is less than height[l] update leftMax to height[l] else add leftMax-height[l] to your final answer 
    and move the l pointer to the right i.e l++. If height[r] is less than height[l], then now we are dealing with the right block. 
    If height[r] is greater than rightMax, then update rightMax to height[r] else add rightMax-height[r] to the final answer. 
    Now move r to the left. Repeat these steps till l and r crosses each other.

    Intuition: We need a minimum of leftMax and rightMax.So if we take the case when height[l]<=height[r] we 
    increase l++, so we can surely say that there is a block with a height more than height[l] to the right of l.
    And for the same reason when height[r]<=height[l] we can surely say that there is a block to the left of r 
    which is at least of height[r]. So by traversing these cases and using two pointers approach the time complexity 
    can be decreased without using extra space.
     */

    public static int countTrapWaterUsingTwoPointer(int[]arr){
        int n = arr.length;
        int l = 0, r = n-1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while(l<=r){
            if(arr[l] <= arr[r]){
                if(arr[l] >= leftMax){
                    leftMax = arr[l];
                }
                else{
                    ans += leftMax - arr[l];
                }
                l++;
            }
            else{
                if(arr[r] >= rightMax){
                    rightMax = arr[r];
                }
                else{
                    ans += rightMax - arr[r];
                }
                r--;
            }
        }
        return ans;
    }
}
