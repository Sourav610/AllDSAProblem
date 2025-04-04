package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPeakElementIn2dMatrix {
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

        List<Integer>ans = new ArrayList<>();
        ans = findPeakElement(arr);
        System.out.println("The ans is: "+ans);
    }


    /*
     * here we will use same approach as find peak element in an array
     * which is using binary search just small modification is that after finding 
     * mid element for that mid which is column index we will find the max element and in which row the
     * max element is present after finding row, based on that row we can select the left or right part just
     * like in an array. it will be like join of 2 - 3 small big pyramid structure.
     * 
     * so if mid value from that row is less than its left mean that mid lie in decreasing path or mountain and 
     * we will get peak element in left side. 
     * same way if mid value is less then right then mid is lie in increasing path of mountain and
     * we will get peak element at right side.
     * 
     * we are finding max element because it will reduce the searching of upper and lower index of that element.
     */
    public static List<Integer> findPeakElement(int[][]arr){
        int n =arr.length;
        int m = arr[0].length;
        int low = 0, high= m-1;
        while(low<= high){
            int mid = (low+high)/2;
            int row = maxRow(arr, n, m,mid);
            int left = mid-1>=0?arr[row][mid-1]:-1;
            int right = mid+1<m?arr[row][mid+1]:-1;
            if(arr[row][mid] > left && arr[row][mid] > right){
                return Arrays.asList(row,mid);
            }
            else if(arr[row][mid] < left){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return Arrays.asList(-1,-1);
    }

    public static int maxRow(int[][]temp, int n, int m, int col){
        int val = Integer.MIN_VALUE;
        int ind = -1;
        for(int i = 0; i<n; i++){
            if(temp[i][col] > val){
                val = temp[i][col];
                ind = i;
            }
        }
        return ind;
    }
}
