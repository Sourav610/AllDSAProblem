

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class FactorialOfN {
    public static void main(String []args) throws IOException{
         int n;
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         System.out.print("Enter a number to find its factorial: ");
         n = Integer.parseInt(br.readLine());

         Factorial(n, 1);
        //  printFactorial(n)

    }

    public static void Factorial(int n, int start){
        if(n<1){
            System.out.print(start);
            return;
        }
        Factorial(n-1, start*n);
    }
}
