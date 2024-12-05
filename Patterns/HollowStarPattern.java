
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HollowStarPattern {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of rows you want to print: ");
        n = Integer.parseInt(br.readLine());

        // printPattern(n);
        // doPattern(n);
        printSolvePattern(n);
    }

    // public static void printPattern(int n){
    //     for(int i = 0; i<2*n; i++){
    //         if(i < n){
    //             for(int j = n-i-1; j>= 0; j--){
    //                 System.out.print("*");
    //             }
    //             for(int k = 0; k<2*i; k++){
    //                 System.out.print(" ");
    //             }
    //             for(int j = n-i-1; j>= 0; j--){
    //                 System.out.print("*");
    //             }
    //             System.out.println();
    //         }
    //         else{
    //             for(int j = 0; j<= i-n; j++){
    //                 System.out.print("*");
    //             }
                
    //             for(int k = 2*(n-1)-2*(i-n); k> 0; k--){    
    //                 System.out.print(" ");
    //             }
    //             for(int j = 0; j<= i-n; j++){
    //                 System.out.print("*");
    //             }
    //             System.out.println();

    //         }
            
    //     }
    // }

    // public static void doPattern(int n){
    //     //first half

    //     for(int i = 0; i<n; i++){
    //         for(int j = n-i-1; j>=0; j--){
    //             System.out.print("*");
    //         }
    //         for(int k = 0; k<2*i; k++){
    //             System.out.print(" ");
    //         }
    //         for(int j = n-i-1; j>= 0; j--){
    //             System.out.print("*");
    //         }
    //         System.out.println();
    //     }

    //     for(int i = 0; i<n; i++){
    //         for(int j = 0; j<= i; j++){
    //             System.out.print("*");
    //         }

    //         for(int k = 2*(n-1-i); k>0; k--){
    //             System.out.print(" ");
    //         }
    //         for(int j = 0; j<= i; j++){
    //             System.out.print("*");
    //         }
    //         System.out.println();
    //     }
    // }

    public static void printSolvePattern(int n){
        //first half
        int spaceNo = 0;
        for(int i = 0; i<n; i++){
            for(int j = n-i-1; j>=0; j--){
                System.out.print("*");
            }
            for(int k = 0; k<spaceNo; k++){
                System.out.print(" ");
            }
            for(int j = n-i-1; j>= 0; j--){
                System.out.print("*");
            }
            spaceNo += 2;
            System.out.println();
        }

        spaceNo = 2*n -2;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<= i; j++){
                System.out.print("*");
            }

            for(int k = 0; k<spaceNo; k++){
                System.out.print(" ");
            }
            for(int j = 0; j<= i; j++){
                System.out.print("*");
            }
            spaceNo -= 2;
            System.out.println();
        }
    }
}
