package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MedianInRowWiseSortedMatrix {
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
        ans = findMedian(arr);
        System.out.println("The ans is: "+ans);
    }

    /*
     * What is the search space where we will apply binary search?

If we carefully observe, our answer lies between the smallest and the largest number in the given matrix. So, the search space will be [min(matrix), max(matrix)].
While applying binary search how to check if an element ‘x’ is a possible median?

If ‘x’ is the median, the number of elements smaller or equal to ‘x’ will be surely greater than (MXN) // 2 (integer division).
How to check how many numbers are smaller or equal to an element ‘mid’?

One of the ways is to traverse the whole matrix and count the numbers. But in that case, the time complexity will be high. So, we have to find other ways. It is given that the matrix is row-wise sorted. So, we can apply the concept of upper bound
For every particular row, we will find the upper bound of the current element ‘mid’. The index returned will be the number of smaller or equal elements in that row.
We will do it for each row and add them to get the total number for the whole matrix.
Mathematically, smaller_equal_in_row = upperBound(matrix[row], mid)
We will just convert the above observation into code.

Algorithm:

Calculate min(matrix) and max(matrix): As the given matrix is row-wise sorted the minimum element will be the minimum element in the first column and the maximum will be the maximum in the last column.
Place the 2 pointers low and high: Initially, we will place the pointers. The pointer low will point to min(matrix) and the high will point to max(matrix).
Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula: mid = (low+high) // 2 ( ‘//’ refers to integer division)
Use the calculateSmallEqual() function to get the number of elements <= mid: Inside the function, we will use the above-mentioned upper bound formula for each row and calculate the total number of elements <= mid. Then we will return the total number from the function calculateSmallEqual().
If smallEqual <= (M*N) // 2: We can conclude that our median must be a bigger number. So, we will eliminate the left i.e. the smaller half (low = mid+1).
If smallEqual > (M*N) // 2: We can conclude that the element mid might be the median. But we have to reach the smallest number to find the actual median. So, in this case, we will remove the right half( i.e. high = mid-1).
The steps from 3-6 will be inside a loop and the loop will continue until low crosses high
     */

    public static int findMedian(int[][]arr){
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        int n = arr.length, m = arr.length;
        for(int i = 0; i<n; i++){
            if(arr[i][0] < low){
                low = arr[i][0];
            }
            if(arr[i][m-1] > high){
                high = arr[i][m-1];
            }
        }

        int req = (n*m)/2;
        while(low<= high){
            int mid = (low+high)/2;
            int val = calSmallValue(arr, n,m, mid);
            if(val <= req){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }

    public static int calSmallValue(int[][]arr, int n, int m, int mid){
        int count = 0; 
        for(int i = 0; i<n; i++){
            count += upperBound(arr[i], m, mid);
        }
        return count;
    }

    public static int upperBound(int[]arr, int col, int x){
        int low = 0, high = col-1;
        int ans=  col;
        while(low<= high){
            int mid = (low+high)/2;
            if(arr[mid]> x){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}
