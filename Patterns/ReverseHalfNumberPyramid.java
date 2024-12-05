
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReverseHalfNumberPyramid{
    public static void main(String []args) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of rows you want to print: ");
        n = Integer.parseInt(br.readLine());

        int k ;
        for(int i = 0; i< n; i++){
            k = 1;
            for(int j = n-i-1; j>=0; j--){
                System.out.print(k);
                k++;
            }
            System.out.println();
        }
    }
}