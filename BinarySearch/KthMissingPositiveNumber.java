package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.
 */
public class KthMissingPositiveNumber {
    public static void main(String args[]) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        System.out.print("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Enter the key you want to search: ");
        int k = Integer.parseInt(br.readLine());
        
        int ans = -1;
        //if nth missing element we need to find in sorted increasing array then we can simply
        //serach all element in array like arr[i] <= k then k++ until element we get is greater than k
        //then k is the missing element as we are adding the element present in array to k for finding exact missing number
        // ans = findMissingElement(arr, k);
        ans = optimizeFindMissingElement(arr, k);
        
        System.out.println("The ans is: "+ans);
    } 

    public static int findMissingElement(int[]arr, int k){
        for(int i = 0; i<arr.length; i++){
            if(arr[i] <= k){
                k++;
            }
            else{
                break;
            }
        }
        return k;
    }
/*
 * How to calculate the number of missing numbers for any index i?

From the above example, we can derive a formula to find the number of missing numbers before any array index, i. The formula is
Number of missing numbers up to index i = vec[i] - (i+1).
The given array, vec, is currently containing the number vec[i] whereas it should contain (i+1) if no numbers were missing. The difference between the current and the ideal element will give the result.

How to apply Binary Search?

We will apply binary search on the indices of the given array. For each index, we will calculate the number of missing numbers and based on it, we will try to eliminate the halves.

How we will get the answer after all these steps?

After completing the binary search on the indices, the pointer high will point to the closest neighbor(present in the array) that is smaller than the kth missing number. 

So, in the given array, the preceding neighbor of the kth missing number is vec[high]. 
Now, we know, up to index ‘high’,
the number of missing numbers = vec[high] - (high+1).
But we want to go further and find the kth number. To extend our objective, we aim to find the kth number in the sequence. In order to determine the number of additional missing values required to reach the kth position, we can calculate this as
more_missing_numbers = k - (vec[high] - (high+1)).
Now, we will simply add more_missing_numbers to the preceding neighbor i.e. vec[high] to get the kth missing number.
kth missing number = vec[high] + k - (vec[high] - (high+1))
        =  vec[high] + k - vec[high] + high + 1
        = k + high + 1.
 */
    public static int optimizeFindMissingElement(int[]arr, int k){
        int low =0, high = arr.length-1;
        while(low<= high){
            int mid = (low+high)/2;
            int missingNumber = arr[mid]-(mid+1);
            if(missingNumber<k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return k+high+1;
    }
}
