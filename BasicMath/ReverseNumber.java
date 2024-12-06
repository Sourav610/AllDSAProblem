package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseNumber {
    public static void main(String args[]) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number to be reversed: ");
        n = Integer.parseInt(br.readLine());

        System.out.println(reverseDigit(n));
    }

    public static int reverseDigit(int n){
        int ans = 0;
        while(n != 0){
            int val = n%10;
            //checking the reversenumbe should not be greater that 2^31-1 or less than -2^31 +1
            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && val > 7)){
                return 0;
            }
            if(ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && val < -8)){
                return 0;
            }
            ans =  ans *10 + val;
            n = n/10;
        }
        return ans;
    }
}
