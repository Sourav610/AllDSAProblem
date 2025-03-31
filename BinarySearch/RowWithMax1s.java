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
        ans = optimizeFindMaxRowWith1s(arr);
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
}
