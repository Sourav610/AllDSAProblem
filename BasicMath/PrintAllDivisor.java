package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintAllDivisor {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter any number: ");
        n = Integer.parseInt(br.readLine());
        
        // printDivisor(n);
        printOptimizeDivisor(n);
    }

    public static void printDivisor(int n){
        for(int i = 1; i<=n/2; i++){
            if(n%i == 0){
                System.out.print(i+" ");
            }
        }
        System.out.print(n);
    }

    public static void printOptimizeDivisor(int n){
        int range = (int)Math.sqrt(n);

        for(int i = 1; i<= range; i++){
            if(n%i == 0){
                System.out.print(i+" ");

                if(i != n/i){
                    System.out.print(n/i+" ");
                }
            }
        }
    }
}
