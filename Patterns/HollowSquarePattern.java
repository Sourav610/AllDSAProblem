
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HollowSquarePattern {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of rows you want to print: ");
        n = Integer.parseInt(br.readLine());

        // printPattern(n);
        doPattern(n);
    }

    // public static void printPattern(int n){
    //     for(int i = 0; i<n; i++){
    //         if(i == 0 || i == n-1){
    //             for(int j= 0; j<n; j++){
    //                 System.out.print("*");
    //             }
    //         }
    //         else{
    //            System.out.print("*");
    //            for(int j = 1; j<n-1; j++){
    //             System.out.print(" ");
    //            }
    //            System.out.print("*");
    //         }
    //         System.out.println();
    //     }
    // }

    public static void doPattern(int n){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i == 0 || i == n-1 || j == 0 || j == n-1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
           
        }
    }
}
