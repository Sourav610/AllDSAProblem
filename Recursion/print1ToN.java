
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class print1ToN {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of times you want to print a number: ");
        n = Integer.parseInt(br.readLine());

        printReverse(n);


    }

    public static void printReverse(int n){
        if(n < 1){
            return;
        }
        System.out.print(n+" ");
        printReverse(n-1);
    }
}
