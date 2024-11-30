
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseHalfStarPyramid {
    public static void main(String []args) throws IOException{
        int n ;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of rows you want to print: ");
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i< n; i++){
            for(int j = n-i-1; j>=0; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
