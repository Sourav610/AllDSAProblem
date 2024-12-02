import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseAlphabetPyramid {
    public static void main(String args[]) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of rows you want to print: ");
        n = Integer.parseInt(br.readLine());

        printPattern(n);

    }
    public static void printPattern(int n){
        char c = 'A';
        for(int i = 0; i< n; i++){
            c = 'A';
            for(int j = 0; j< n-i; j++){
                System.out.print(c);
                c++;
            }
            System.out.println();
        }
    }
}
