import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 
 The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 */
public class DivideTwoIntegers {

    public static void main(String[]args) throws IOException{
        int dividend;
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        System.out.println("Enter a dividend: ");
        dividend = Integer.parseInt(br.readLine());
        System.out.println("Enter the divisor: ");
        int divisor = Integer.parseInt(br.readLine());

        int result = 0;
        result = (int)divideInteger(dividend,divisor);
        System.out.println("The answer is: "+result);

    }

    /*
    -- Brute Force
     * we can directly add divisor multiple time until it is equal to dividend.
     * and the number of times we add it is the result. This is brute force.
     * 
     * Optimal Approach
     * we can represent the divisor in power of 2 format as shown below
     * dividend = 10, divisor = 3
     * 10 = 3*2^1 + 3*2^0
     *     = 6 + 3 = 9  the is maximum value we can get
     * so 3*2^1 can be represent as 3 <<(1)
     * so every time we can check what will be the larget number we can take from dividend
     * then subtract that value from dividend and and power value to count.
     * 
     * 
     * --> ans we are using long because when we convert -2^31 to positive as we cannot store in int
     * variable as int range is (-2^31 to 2^31-1) that why we are using long.
     */

    public static long divideInteger(int dividend,int divisor){
        long dv = Math.abs(dividend);
        long dr = Math.abs(divisor);

        boolean sign = false;
        if(dividend >= 0 && divisor < 0) sign =true;
        if(dividend < 0 && divisor >= 0) sign = true;
        long ans = 0;
        while(dv >= dr){
            int count = 0;
            while(dv >= (dr<<(count+1))){
                count++;
            }
            ans += 1<<count;
            dv -= (dr<<count);
        }

        if(ans == (1<<31) && !sign){
            return Integer.MAX_VALUE;
        }
        if(ans == (1<<31) && sign){
            return Integer.MIN_VALUE;
        }

        return sign?-ans:ans;
    }
}
