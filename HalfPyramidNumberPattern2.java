import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class HalfPyramidNumberPattern2 {
    public static void main(String args[]) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of rows: ");
        n = Integer.parseInt(br.readLine());
        int k = 1; 
        for(int i = 0; i<n; i++){
            for(int j = 0; j<= i; j++){
                System.out.print(k);
            }
            k++;
            System.out.println();
        }
    }
}
