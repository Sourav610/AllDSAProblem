
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberPuzzelPattern {
    public static void main(String []args)throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of rows you want to print: ");
        n = Integer.parseInt(br.readLine());

        printPattern(n);
    }    


    //logic  - subtract all value of matrix with n, we get below matrix , if n = 4
    /*  
     * 4 4 4 4 4 4 4                         0 0 0 0 0 0 0
       4 3 3 3 3 3 4                         0 1 1 1 1 1 0
       4 3 2 2 2 3 4                         0 1 2 2 2 1 0
       4 3 2 1 2 3 4 -- >  After subtracting 0 1 2 3 2 1 0  
       4 3 2 2 2 3 4                         0 1 2 2 2 1 0
       4 3 3 3 3 3 4                         0 1 2 2 2 1 0
       4 4 4 4 4 4 4                         0 0 0 0 0 0 0
     * 
     * After getting the new matrix (0-index), for every position we see that it is 
     * the minimum of all 4 direction like
     * for poisition (1,3) its value is min(distance from top(1), distance from left(3),distance from righ(3),distance from bottom(5)) = 1
     * same way for position (3,3)  min(distance from top(3), distance from left(3),distance from righ(3),distance from bottom(3)) = 3
     * for final result we subtract back by subtracting all new matrix value from n
     */
    public static void printPattern(int n){
        for(int i =0; i<2*n-1; i++){
            for(int j = 0; j<2*n-1; j++){
                int top = i;
                int left = j;
                int right = 2*n -2 -j;
                int bottom = 2*n -2 -i;

                int num = Math.min(top,Math.min(left, Math.min(right, bottom)));
                System.out.print(n-num+" ");
            }
            System.out.println();
        }
    }
}
