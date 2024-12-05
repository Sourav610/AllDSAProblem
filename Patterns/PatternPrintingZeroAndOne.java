
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PatternPrintingZeroAndOne {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of rows you want to print: ");
        n = Integer.parseInt(br.readLine());

        // int one = 1, zero = 0;
        // for(int i = 0; i<n; i++){
        //     for(int j = 0; j<=i; j++){
        //         if((i%2 == 0 && j%2 == 0) || (i%2 != 0 && j%2 != 0)){
        //             System.out.print(one+" ");
        //         }
        //         else{
        //             System.out.print(zero+" ");
        //         }
        //     }
        //     System.out.println();
        // }
        doPattern(n);
    }

    public static void doPattern(int size){
        int start;
        for(int i = 0; i<size; i++){
            if(i%2 == 0){
                start = 1;
            }
            else{
                start = 0;
            }

            for(int j = 0; j<=i; j++){
                System.out.print(start+" ");
                start = 1-start;
            }
            System.out.println();
        }
    }
}
