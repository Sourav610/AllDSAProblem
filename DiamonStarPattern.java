import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class DiamonStarPattern {
    public static void main(String []args) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of rows you want to print: ");
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n-i-1; j++){
                System.out.print(" ");
            }

            for(int k = 0; k<2*i +1; k++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                System.out.print(" ");
            }

            for(int k = 0; k<2*(n-i)-1; k++){
                System.out.print("*");
            }
            System.out.println();
        }


    }
}
