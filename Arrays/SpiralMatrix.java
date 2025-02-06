package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SpiralMatrix {
    public static void main(String []args) throws IOException{
        int n,m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter num of row:  ");
        n = Integer.parseInt(br.readLine());
        System.out.println("Enter number of column: ");
        m = Integer.parseInt(br.readLine());

        System.out.print("Enter "+n*m+" element: ");
        int arr[][] = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                arr[i][j] = Integer.parseInt(br.readLine());
            }
        }

        //approach
        /*
         * 1. Create and initialize variables top as starting row index, bottom as ending row index left as starting column index, and right as ending column index. As shown in the image given below.
         * 2. In each outer loop traversal print the elements of a square in a clockwise manner.
           3. Print the top row, i.e. Print the elements of the top row from column index left to right and increase the count of the top so that it will move to the next row.
           4. Print the right column, i.e. Print the rightmost column from row index top to bottom and decrease the count of right.
           5. Print the bottom row, i.e. if top <= bottom, then print the elements of a bottom row from column right to left and decrease the count of bottom
           6. Print the left column, i.e. if left <= right, then print the elements of the left column from the bottom row to the top row and increase the count of left.
           7. Run a loop until all the squares of loops are printed.
         */
        ArrayList<Integer>ans = new ArrayList<>();
        ans = printSpiralMatrix(arr,n,m);
        
        System.out.println("The element after operation: ");
        for(int i = 0; i<n*m; i++){
            System.out.print(ans.get(i)+" ");
        }

    }

    public static ArrayList<Integer> printSpiralMatrix(int[][] arr, int n, int m){
        ArrayList<Integer>ans = new ArrayList<Integer>();

        int top = 0, bottom = n-1, right = m-1, left = 0;

        while(top<= bottom && left <= right){
            for(int i = left; i<= right; i++){
                ans.add(arr[top][i]);
            }
            top++;

            for(int i = top; i<= bottom; i++){
                ans.add(arr[i][right]);
            }
            right--;

            if(top<= bottom){
                for(int i = right; i>= left; i--){
                    ans.add(arr[bottom][i]);
                }
                bottom--;
            }

            if(left <= right){
                for(int i = bottom; i>= top; i--){
                    ans.add(arr[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}
