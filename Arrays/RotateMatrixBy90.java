package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateMatrixBy90 {
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


        // arr = Rotate(arr);
        optimizeRotate(arr);
        System.out.println("The element after operation: ");
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static int[][] Rotate(int[][]arr){
        int [][]rotated = new int[arr.length][arr.length];
        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j <arr.length; j++) {
                rotated[j][arr.length - i - 1] = arr[i][j];
            }
        }
        return rotated;
    }

    //here we will first take transpose of the matrix then we will reverse every row element;

    public static void optimizeRotate(int[][]arr){

        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<i; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length / 2; j++) {
                int temp = 0;
                temp = arr[i][j];
                arr[i][j] = arr[i][arr.length - 1 - j];
                arr[i][arr.length - 1 - j] = temp;
            }
        }
    }

}
