package BinarySearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindMinInRotatedSubArray {
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

        int ans = -1;
        ans = minSearch(arr);
        System.out.println("The ans is: "+ans);
    }

    /*
     * checking if first half is sorted than taking min value and discard the first half
     * else second half is sorted then taking min and discard the second half.
     */
    public static int minSearch(int[]arr){
        int low = 0, high = arr.length-1;
        if(arr[low] <arr[high]){
            return arr[low];
        }
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[low] <= arr[mid]){
                ans = Integer.min(ans, arr[low]);
                low = mid+1;
            }
            else{
                ans = Integer.min(ans,arr[mid]);
                high = mid-1;
            }
        }
        return ans;
    }
}
