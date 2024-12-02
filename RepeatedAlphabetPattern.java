import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class RepeatedAlphabetPattern {
    public static void main(String []args) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of rows you want to print: ");
        n = Integer.parseInt(br.readLine());

        printPattern(n);

    }
    public static void printPattern(int n){
        char c = 'A';
        for(int i = 0; i<n; i++){
            for(int j = 0; j<= i; j++){
                System.out.print(c);
            }
            System.out.println();
            c++;
        }
    }
}
