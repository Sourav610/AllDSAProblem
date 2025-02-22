package Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/*
 * Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

0 <= i < j < nums.length and
nums[i] > 2 * nums[j].
 
 */
public class ReversePair {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array: ");
        n = Integer.parseInt(br.readLine());

        System.out.println("Enter "+n+" element: ");
        int []arr1 = new int[n];
        for(int i = 0; i<n; i++){
           arr1[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        // count = countReversePair(arr1);

        //using mergeSort algorithm with extra modification
        count = mergeSort(arr1,0,arr1.length-1);

        System.out.println("The array after mergin element: "+count);
        
    }

    /*
     * The steps are basically the same as they are in the case of the merge sort algorithm. The change will be just in the mergeSort() function:

In order to count the number of pairs, we will keep a count variable, cnt, initialized to 0 beforehand inside the mergeSort().
We will add the numbers returned by the previous mergeSort() calls.
Before the merge step, we will count the number of pairs using a function, named countPairs().
We need to remember that the left half starts from low and ends at mid, and the right half starts from mid+1 and ends at high.
The steps of the countPairs() function will be as follows:

We will declare a variable, cnt, initialized with 0.
We will run a loop from low to mid, to select an element at a time from the left half.
Inside that loop, we will use another loop to check how many elements from the right half can make a pair.
Lastly, we will add the total number of elements i.e. (right-(mid+1)) (where right = current index), to the cnt and return it.
     */

    public static int countReversePair(int[]arr){
        int count = 0;
        for(int i = 0; i<arr.length;i++){
            for(int j = i+1; j<arr.length; j++){
                if(arr[i] > 2*arr[j]){
                    count++;
                }
            }
        }

        return count;
    }

    public static int mergeSort(int[]arr, int low, int high){
        int count = 0;
        if(low >= high){
            return count;
        }
        int mid = (low+high)/2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid+1, high);
        count += countPair(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }

    public static int countPair(int[]arr, int low, int mid, int high){
        int right = mid+1;
        int count = 0;

        for(int i = low; i<=mid; i++){
            while(right <= high && arr[i] > 2 *(long)arr[right])right++;
            count += (right -(mid+1));
        }
        return count;
    }

    public static void merge(int[]arr, int low, int mid, int high){
        ArrayList<Integer>temp = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }

        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }

        while(right <= high){
            temp.add(arr[right]);
            right++;
        }

        for(int i = low; i<= high; i++){
            arr[i] = temp.get(i-low);
        }
    }
}

