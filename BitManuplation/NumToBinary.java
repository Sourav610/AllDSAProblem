package BitManuplation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * T.C - log base2 n
 * S.C - log base2 n
 */
public class NumToBinary {
    public static void main(String[]args) throws IOException{
        int num;
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        System.out.println("Enter a number: ");
        num = Integer.parseInt(br.readLine());

        String ans = "";
        while(num != 1){
            if(num%2 == 1){
                ans += '1';
            }
            else{
                ans += '0';
            }
            num = num/2;
        }
        ans += '1';
        StringBuilder sb = new StringBuilder(ans);
        String reversedString = sb.reverse().toString();

        System.out.println("The conversion from num to binary is: "+
        reversedString);
    }
}
