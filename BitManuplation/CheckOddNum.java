import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckOddNum {
     public static void main(String[]args) throws IOException{
        int num;
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        System.out.println("Enter a number: ");
        num = Integer.parseInt(br.readLine());

        boolean result = false;
        if((num&1) == 1){
            result  = true;
        }
        
        System.out.println("The number is odd: "+result);
     }
}
