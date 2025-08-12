package BitManuplation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * T.C - O(n)
 * S.C - O(1)
 */
public class BinaryToNum {
    public static void main(String []args) throws IOException{
        String num;
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        System.out.println("Enter a number: ");
        num = br.readLine();
        int power = 1;
        int ans = 0;
        for(int i = num.length()-1; i>= 0; i--){
            if(num.charAt(i) == '1'){
                ans += power;
            }
            power *= 2;
        }

        System.out.println("Binary to num conversion result is: "+ans);
    }
}
