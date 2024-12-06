package BasicMath;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Countdigit {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter any digits: ");
        n = Integer.parseInt(br.readLine());

        int count = 0;
        while(n != 0){
            n = n/10;
            count++;
        }

        System.out.println("The number of digit are: "+ count);
    }
}
