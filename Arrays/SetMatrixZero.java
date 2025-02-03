package Arrays;

import java.io.*;

/*
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 */
public class SetMatrixZero {
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

        /*
         * here we maintain a row and a column to store which row and which column we are getting the value 0
         * then when we iterate 2nd time we will check in row or col arr if index is present there and if present 
         * then we change the value in matrix for that row or col val
         */
        // SetZero(arr,n,m);

        SetOptimizeZero(arr,n,m);
        System.out.println("The element after operation: ");
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void SetZero(int [][]arr,int n, int m){
        int row[] = new int[n];
        int col[] = new int[m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(arr[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j= 0; j<m; j++){
                if(row[i] == 1 || col[j] == 1){
                    arr[i][j] = 0;
                }
            }
        }
    }

    /*
     * Here instead of using adding row and col array we will take first row and first column from existing array and apply same
     * approach, and for (0,0) we will maintain a single variable like below approach
     * 
     * 1. First, we will traverse the matrix and mark the proper cells of 1st row and 1st column with 0 accordingly. The marking will be like this: if cell(i, j) contains 0, we will mark the i-th row i.e. matrix[i][0] with 0 and we will mark j-th column i.e. matrix[0][j] with 0.
        If i is 0, we will mark matrix[0][0] with 0 but if j is 0, we will mark the col0 variable with 0 instead of marking matrix[0][0] again.
       2. After step 1 is completed, we will modify the cells from (1,1) to (n-1, m-1) using the values from the 1st row, 1st column, and col0 variable.
        We will not modify the 1st row and 1st column of the matrix here as the modification of the rest of the matrix(i.e. From (1,1) to (n-1, m-1)) is dependent on that row and column.
       3. Finally, we will change the 1st row and column using the values from matrix[0][0] and col0 variable. Here also we will change the row first and then the column.
        If matrix[0][0] = 0, we will change all the elements from the cell (0,1) to (0, m-1), to 0.
        If col0 = 0, we will change all the elements from the cell (0,0) to (n-1, 0), to 0.
     */

    public static void SetOptimizeZero(int[][]arr, int n, int m){

        int col0 = 1;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(arr[i][j] == 0){
                    arr[i][0] = 0;
                    if(j != 0){
                        arr[0][j] = 0;
                    }
                    else{
                        col0 = 0;
                    }
                }
            }
        }

        for(int i = 1; i<n; i++){
            for(int j = 1; j<m; j++){
                if(arr[i][0] == 0 || arr[0][j] == 0){
                    arr[i][j] = 0;
                }
            }
        }

        if(arr[0][0] == 0){
            for(int i = 0; i<m; i++){
                arr[0][i] = 0;
            }
        }
        if(col0 == 0){
            for(int k = 0; k<n; k++){
                arr[k][0] = 0;
            }
        }
    }
}
