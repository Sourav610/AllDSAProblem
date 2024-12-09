package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckPrime {
    public static void main(String [] args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter any number: ");
        n = Integer.parseInt(br.readLine());

        // checkPrime(n);
        checkOptimalPrime(n);
    }

    public static void checkPrime(int n){
        int range = (int)Math.sqrt(n);
        int flag = 0;
        for(int i = 2; i<= range; i++){
            if(n%i == 0){
                flag = 1;
                break;
            }
        }
        if(flag == 1){
            System.out.println("Not a prime number");
        }
        else{
            System.out.println("Prime number");
        }
    }

    public static void checkOptimalPrime(int n){
        int range = (int)Math.sqrt(n);
        int count = 0;
        for(int i = 2; i<= range; i++){
            if(n%i == 0){
                count ++;
                if(n/i != i){
                    count++;
                }
            }
        }
        if(count > 2){
            System.out.println("Not a prime number");
        }
        else{
            System.out.println("Prime number");
        }
    }
}
