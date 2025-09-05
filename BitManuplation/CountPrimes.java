import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 */

public class CountPrimes {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        int n= Integer.parseInt(br.readLine());

        int ans = 0;
        ans = countPrime(n);
        // ans = countOptimizePrime(n);
        System.out.println("The prime factors are: "+ans);

    }
 
    /*
     * This problem is solve by ###Sieve of Eratosthenes algorithm###, it states-
     * Initialize a Boolean array prime[0..n] and set all entries to true, except for 0 and 1 (which are not primes).
        Start from 2, the smallest prime number.
        For each number p from 2 up to √n:
            If p is marked as prime(true):
            Mark all multiples of p as not prime(false), starting from p * p (since smaller multiples have already been marked by smaller primes).
        After the loop ends, all the remaining true entries in prime represent prime numbers.

        -it means create a array of n number and take first prime number 2 and marks its multiple in that array. and then check if next element in
        that array is prime then take it and mark its multiple , and whose number is marked don't take it. lastly at the end count the total unmarked
        element and it will be the answer.

        T.c - O(Nlog(logN))
        S.c - O(1)
     */
    public static int countOptimizePrime(int n){
        int[]arr = new int[n+1];
        int count = 0;
        for(int i = 2; i*i<=n; i++){
            if(arr[i] == 0){
                for(int j = i*i;j<=n; j+=i){
                    arr[j] = -1;
                }
            }
        }

        for(int i = 2; i<n; i++){
            if(arr[i] == 0){
                count++;
            }
        }
        return count;
    }

    /*
     * it is brute force approach
     * T.c - O(n*sqrt(n))
     * S.c - O(1)
     */

    public static int countPrime(int n){
        int count = 0;
        for(int i = 2; i<=n; i++){
            if(checkPrime(i)){
                count++;
            }
        }
        return count;
    }

    public static boolean checkPrime(int val){
        int range = (int) Math.sqrt(val);
        int count = 0;
        for(int i = 1; i<=range; i++){
            if(val%i == 0){
                count++;
                if(val/i != i){
                    count++;
                }
            }
        }

        if(count == 2){
            return true;
        }
        return false;
    }

}
