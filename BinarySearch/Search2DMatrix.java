package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Search2DMatrix {
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
        System.out.println("Enter the key you want to search: ");
        int k = Integer.parseInt(br.readLine());

        boolean ans = false;
        // ans = findTarget(arr, k);
        ans = optimizeFindTarget(arr,k);
        System.out.println("The ans is: "+ans);
    }

    public static boolean findTarget(int[][]arr, int target){
        for(int i = 0; i<arr.length; i++){
            int low = 0, high = arr[i].length-1;
            if(arr[i][0] <= target && arr[i][high] >= target){
                while(low<=high){
                    int mid = (low+high)/2;
                    if(arr[i][mid] == target){
                        return true;
                    }
                    else if(arr[i][mid] < target){
                        low = mid+1;
                    }
                    else{
                        high = mid-1;
                    }
                }
            }
        }
        return false;
    }

    /*
       note: If index = i, and no. of columns in the matrix = m, the index i corresponds to the cell with
        row = i / m and col = i % m. More formally, the cell is (i / m, i % m)(0-based indexing).

     * we will flatten the 2d array to 1d array by calculating row and column from 
     * mid value with the below formula
     * row = mid/(column length), col = mid%(column length)
     * low = 0, high = m*n-1;
     */
    public static boolean optimizeFindTarget(int[][]arr, int k){
        int n = arr.length, m = arr[0].length;
        int low = 0, high = n*m-1;
        while(low<=high){
            int mid = (low+high)/2;
            int row = mid/m;
            int col = mid%m;
            if(arr[row][col] == k){
                return true;
            }
            else if(arr[row][col] < k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}
