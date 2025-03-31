package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RowWithMax1s {
    public static void main(String[]args) throws IOException{
        int n,m;
        System.out.println("Enter the n and m value of 2d array: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        int arr[][] = new int[n][m];

        for(int i = 0; i<n; i++){
            System.out.println("Enter "+(i+1)+"st row element: ");
            for(int j = 0; j<m; j++){
                arr[i][j] = Integer.parseInt(br.readLine());
            }
        }
        int ans = -1;
        // ans = findMaxRow(arr);
        // ans = optimizeFindMaxRowWith1s(arr);
        ans = usingBinarySearch(arr);
        System.out.println("The ans is: "+ans);
    }

    public static int findMaxRow(int[][]temp){
        int maxCount = Integer.MIN_VALUE;
        int ind = 0;
        for(int i = 0; i<temp.length; i++){
            int count = 0;
            for(int j = 0; j<temp[0].length; j++){
                if(temp[i][j] == 1){
                    count++;
                }
            }
            if(count > maxCount){
                maxCount = count;
                ind = i;
            }
        }
        return ind;
    }

    /*
     * The problem involves searching for the row with the maximum number of 1s in a
     *  boolean 2D array where each row is sorted. Since the rows are sorted, 
     * we can utilize this property to find the desired row efficiently. 
     * The algorithm starts from the top-right corner of the array and traverses
     *  the array while moving left if the current element is 1 or moving down 
     * if the current element is 0. This way, the algorithm narrows down the rows
     *  that could potentially have the maximum number of 1s. Eventually, it stops
     *  at the row with the maximum number of 1s.
     */

    public static int optimizeFindMaxRowWith1s(int[][]arr){
        int n = arr.length;
        int m = arr[0].length;
        int currRow = 0;
        int currCol = m-1;
        int maxIndex = -1;
        while(currRow < n && currCol >= 0){
            if(arr[currRow][currCol] == 1){
                currCol--;
                maxIndex = currRow;
            }
            else{
                currRow++;
            }
        }

        return maxIndex;
    }

    /*
     * We are going to use the Binary Search algorithm to optimize the approach.

The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate, thereby reducing the search space by half. It does this by determining a specific condition that ensures that the target is not present in that half.

We cannot optimize the row traversal but we can optimize the counting of 1’s for each row.

Instead of counting the number of 1’s, we can use the following formula to calculate the number of 1’s:
Number_of_ones = m(number of columns) - first occurrence of 1(0-based index).

As, each row is sorted, we can find the first occurrence of 1 in each row using any of the following approaches:

lowerBound(1) (ref: Implement Lower Bound)
upperBound(0) (ref: Implement Upper Bound)
firstOccurrence(1) (ref: First and Last Occurrences in Array)
     */

    public static int usingBinarySearch(int[][]arr){
        int maxCount = Integer.MIN_VALUE;
        int n = arr.length;
        int m = arr.length;
        int ind = 0;
        for(int i = 0; i<arr.length; i++){
            int count = m - lowerBound(arr[i],1,m);
            if(count > maxCount){
                maxCount = count;
                ind = i;
            }
        }
        return ind;
    }

    public static int lowerBound(int[]ans, int k, int m){
        int low = 0, high = m-1;
        int res = m;
        while(low<= high){
            int mid = (low+high)/2;
            if(ans[mid] >= k){
                res = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return res;
    }
}
