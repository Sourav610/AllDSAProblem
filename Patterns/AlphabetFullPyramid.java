
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class AlphabetFullPyramid {
    public static void main(String args[]) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of rows you want to print: ");
        n = Integer.parseInt(br.readLine());

        // printPattern(n);
        printOptimizePattern(n);
    }

    // public static void printPattern(int n){
    //     char c = 'A';

    //     for(int i = 0; i< n; i++){
    //         for(int k = 0; k<n-i-1; k++){
    //             System.out.print(" ");
    //         }
    //         c = 'A';
    //         for(int j = 0; j<=i; j++){
    //             System.out.print(c);
    //             c++;
    //         }

    //         c--;
    //         for(int k = i+1; k<2*i+1; k++){
    //             c--;
    //             System.out.print(c);
                
    //         }

    //          System.out.println();
    //     }
    // }

    public static void printOptimizePattern(int size){
       

        for(int i = 0; i< size; i++){
            for(int k = 0; k<size-i-1; k++){
                System.out.print(" ");
            }
            
            char c = 'A';
            int breakPoint = (2*i+1)/2;
            for(int j = 1; j<=2*i +1; j++){
                System.out.print(c);
                if(j<= breakPoint) {
                    c++;
                }
                else{
                    c--;
                }
            }

            for(int k = 0; k<size-i-1; k++){
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
