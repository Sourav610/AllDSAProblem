package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * Given an array of integers arr[]. Find the Inversion Count in the array.
Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum. 
 */
public class CountInversion {
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
        //if need to merge in a single array
        // count = countInversionArray(arr1);

        //using mergeSort algorithm
        count = mergeSort(arr1,0,arr1.length-1);

        System.out.println("The array after mergin element: "+count);
        
    }

    /*
     * The steps of the merge() function were the following:

In the merge function, we will use a temp array to store the elements of the two sorted arrays after merging. 
Here, the range of the left array is low to mid and the range for the right half is mid+1 to high.
Now we will take two pointers left and right, where left starts from low and right starts from mid+1.
Using a while loop( while(left <= mid && right <= high)), we will select two elements, one from each half, 
and will consider the smallest one among the two. Then, we will insert the smallest element in the temp array. 
After that, the left-out elements in both halves will be copied as it is into the temp array.
Now, we will just transfer the elements of the temp array to the range low to high in the original array.
Modifications in merge() and mergeSort(): 

In order to count the number of pairs, we will keep a count variable, cnt, initialized to 0 beforehand inside the merge().
While comparing a[left] and a[right] in the 3rd step of merge(), if a[left] > a[right], we will simply add this line:
cnt += mid-left+1 (mid+1 = size of the left half)
Now, we will return this cnt from merge() to mergeSort(). 
Inside mergeSort(), we will keep another counter variable that will store the final answer. With this cnt, we will add the answer returned from mergeSort() of the left half, mergeSort() of the right half, and merge().
Finally, we will return this cnt, as our answer from mergeSort().
     */

    public static int countInversionArray(int[]arr){
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                if(arr[i] > arr[j]){
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
        int mid = (low + high)/2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid+1, high);
        count += merge(arr, low, mid, high);
        return count;
    }

    public static int merge(int[]arr, int low, int mid, int high){
        int left = low;
        int right = mid+1;

        ArrayList<Integer>temp = new ArrayList<>();
        int count = 0;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                count += (mid-left+1);
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
        return count;
        
    }
}
