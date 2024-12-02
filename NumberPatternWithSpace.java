import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberPatternWithSpace {
    public static void main(String []args) throws IOException{
        int n ;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of rows you want to print: ");
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++){
            int k = 1;
            for(int j = 0; j<=i; j++){
                System.out.print(k);
                k++;
            }
            for(int l = i+1; l<2*n-i-1; l++){
                System.out.print(" ");
            }
            k = i+1;
            for(int j = 0; j<= i; j++){
                System.out.print(k);
                k--;
            }
            System.out.println();
        }
    }
}
