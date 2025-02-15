package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * Given an array of integers A and an integer B.

Find the total number of subarrays having bitwise XOR of all elements equals to B.

 */
public class SubArrayWithGivenXOR {
    public static void main(String[]args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of an array: ");
        n = Integer.parseInt(br.readLine());
        
        int arr[] = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the k value: ");
        int k = Integer.parseInt(br.readLine());

        int count = 0;
        count = findSubarrayWithXORk(arr, k);
        //using prefix sum(Optimized approach)
        //initiall setting the map value of 0 to 1 as sum -k can be 0
        //storing the sum and its count and adding the count taken from map;
        // count = findOptimizeSubarrayWithXORk(arr,k);

        System.out.println("The count is: "+count);
    }
    /*
     * In this approach, we are going to use the concept of the prefix XOR to solve this problem. Here, the prefix XOR of a subarray ending at index i, simply means the XOR of all the elements of that subarray.

    Observation: Assume, the prefix XOR of a subarray ending at index i is xr. In that subarray, we will search for another subarray ending at index i, whose XOR is equal to k. Here, we need to observe that if there exists another subarray ending at index i, with XOR k, then the prefix XOR of the rest of the subarray will be xr^k. The below image will clarify the concept:

        Now, for a subarray ending at index i with the prefix XOR xr, if we remove the part with the prefix XOR xr^k, we will be left with the part whose XOR is equal to k. And that is what we want.

        Now, there may exist multiple subarrays with the prefix XOR xr^k. So, the number of subarrays with XOR k that we can generate from the entire subarray ending at index i, is exactly equal to the number of subarrays with the prefix XOR xr^k, present in that subarray.

        So, for a subarray ending at index i, instead of counting the subarrays with XOR k, we can count the subarrays with the prefix XOR xr^k present in it.

        That is why, instead of searching the subarrays with XOR k, we will keep the occurrence of the prefix XOR of the subarrays using a map data structure. 

        In the map, we will store every prefix XOR calculated, with its occurrence in a <key, value> pair. Now, at index i, we just need to check the map data structure to get the number of times that the subarrays with the prefix XOR xr^k occur. Then we will simply add that number to our count.

        We will apply the above process for all possible indices of the given array. The possible values of the index i can be from 0 to n-1(where n = size of the array).

    Approach:
        The steps are as follows:

        First, we will declare a map to store the prefix XORs and their counts.
        Then, we will set the value of 0 as 1 on the map.
        Then we will run a loop(say i) from index 0 to n-1(n = size of the array).
        For each index i, we will do the following:
        We will XOR the current element i.e. arr[i] to the existing prefix XOR.
        Then we will calculate the prefix XOR i.e. xr^k, for which we need the occurrence.
        We will add the occurrence of the prefix XOR xr^k i.e. mpp[xr^k] to our answer.
        Then we will store the current prefix XOR, xr in the map increasing its occurrence by 1.
     */

    public static int findSubarrayWithXORk(int[]arr, int k){
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            int xor = 0;
            for(int j = i;  j<arr.length; j++){
                xor ^= arr[j];
                if(xor == k){
                    count++;
                }
            }
        }
        return count;
    }

    public static int findOptimizeSubarrayWithXORk(int []arr, int k){
        HashMap<Integer,Integer>mp = new HashMap<>();
        int count = 0;
        int xor = 0;
        mp.put(0,1);
        for(int i = 0; i<arr.length; i++){
            xor ^= arr[i];
            if(mp.containsKey(xor^k)){
                count += mp.get(xor^k);
            }
            if(mp.containsKey(xor)){
                int val = mp.get(xor);
                mp.put(xor,val+1);
            }
            else{
                mp.put(xor,1);
            }
        }
        return count;
    }
}
