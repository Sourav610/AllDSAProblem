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

    /*
     * (n/i != i) we are doing because already we check n is divisble by i and then we are checking 
     * that by getting the quetiont which is differnt from i if it is different then this number can also divide
     * that why increasing count.
     * 
     * also if count is exactly 2(1 and itself) then prime number else not prime
     */
    public static void checkOptimalPrime(int n){
        int range = (int)Math.sqrt(n);
        int count = 0;
        for(int i = 1; i<= range; i++){
            if(n%i == 0){
                count ++;
                if(n/i != i){
                    count++;
                }
            }
        }
        if(count == 2){
            System.out.println("prime number");
        }
        else{
            System.out.println("Not a Prime number");
        }
    }
}
