package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.

A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.
 * 
 */
public class CountGoodNumbers {
    static long mod = 1000000007;
    public static void main(String []args) throws NumberFormatException, IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number: ");
        n = Integer.parseInt(br.readLine());

        long val = (calPow(5,(n+1)/2) * calPow(4,n/2))%mod;
        System.out.println("The pow of given number is: "+val);
    }

    public static long calPow(long x, long n){
        if(n == 0)return 1;
        if (n == Integer.MAX_VALUE) return (x == 1) ? 1 : (x == -1) ? -1 : 0;
        if (n == Integer.MIN_VALUE) return (x == 1 || x == -1) ? 1 : 0;
        if(n<0){
            n = Math.abs(n);
            x = 1/x;
        }
        if(n%2 == 0){
            return calPow((x*x)%mod,n/2);
        }
        else{
            return (x*calPow(x,n-1))%mod;
        }
    }
}
