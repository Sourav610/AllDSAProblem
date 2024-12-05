import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseHollowStarPattern {
    public static void main(String [] args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of rows you want to print: ");
        n = Integer.parseInt(br.readLine());

        // printPattern(n);
        doPattern(n);
    }    

    // public static void printPattern(int n){
    //     for(int i = 0; i<n; i++){
    //         for(int j = 0; j<= i; j++){
    //             System.out.print("*");
    //         }
    //         for(int k = 0; k<2*(n-i-1); k++){
    //             System.out.print(" ");
    //         }
    //         for(int j = 0; j<= i; j++){
    //             System.out.print("*");
    //         }
    //         System.out.println();
    //     }

    //     for(int i = 1; i<n; i++){
    //         for(int j = 0; j<n-i; j++){
    //             System.out.print("*");
    //         }
    //         for(int k = 0; k<2*i; k++){
    //             System.out.print(" ");
    //         }
    //         for(int j = 0; j<n-i; j++){
    //             System.out.print("*");
    //         }
    //         System.out.println();
    //     }
    // }

    public static void doPattern(int n){
        int space = 2*n -2;
        for(int i = 1; i<2*n; i++){
            int star = i;
            if(i>n){
                star = 2*n - i;
            }
            
            for(int j = 1; j<=star; j++){
                System.out.print("*");
            }

            for(int k = 1; k<= space; k++){
                System.out.print(" ");
            }

            for(int j = 1; j<= star; j++){
                System.out.print("*");
            }
            if(i<n){
                space -= 2;
            }
            else{
                space += 2;
            }
            System.out.println();
        }
    }
}
