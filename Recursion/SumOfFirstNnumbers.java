package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfFirstNnumbers {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter any number: ");
        n = Integer.parseInt(br.readLine());
        System.out.print(printSum(n));
    }

    public static int printSum(int n){
        if(n <1){
            return 0;
        }

        return n + printSum(n-1);
    }
}
