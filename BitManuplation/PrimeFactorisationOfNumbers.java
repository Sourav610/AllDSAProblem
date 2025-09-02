import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrimeFactorisationOfNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        int n= Integer.parseInt(br.readLine());
        int[]arr = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        // ans = findPrimeFactor(arr);
        // ans = findOptimalPrimeFactor(arr);
        // ans = findAllPrimeFactor(arr);
        ans = findOptimzeAllPrimeFactor(arr);
        System.out.println("The prime factors are: "+ans);

    }

    /*
     * This code will not include the repeat factor of number;
     */
    public static ArrayList<ArrayList<Integer>> findPrimeFactor(int[]arr){
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            int val = arr[i];
            ArrayList<Integer>res = new ArrayList<>();
            for(int k = 2; k<=val; k++){
                if(val%k == 0){
                    if(checkPrime(k)){
                        res.add(k);
                    }
                }
            }
            ans.add(res);

        }
        return ans;
    }

    /*
     * This code will not include the repeat factor of number;
     * T.c will be aprox O(sqrt(n)*2*sqrt(n));
     * S.C - depends on number of prime factor
     */
    public static ArrayList<ArrayList<Integer>> findOptimalPrimeFactor(int[]arr){
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            int val = arr[i];
            ArrayList<Integer>res = new ArrayList<>();
            for(int k = 1; k<=Math.sqrt(val); k++){
                if(val%k == 0){
                    if(checkPrime(k)){
                        res.add(k);
                    }
                    if(val/k != k){
                        if(checkPrime(val/k)){
                            res.add(val/k);
                        }
                    }
                }
            }
            ans.add(res);

        }
        return ans;
    }

    public static boolean checkPrime(int k){
        int range = (int) Math.sqrt(k);
        int count = 0;
        for(int i = 1; i<=range; i++){
            if(k%i == 0){
                count++;
                if(k/i != i){
                    count++;
                }
            }
        }

        if(count==2){
            return true;
        }
        return false;
    }

    /*
     * using simple prime factorize - we divide the number by 2 until not divisible then move to another number
     * in this way only prime number will come as initially all factor's are taken.
     * 
     * T.c - O(N);
     * S.c - its depends on number of prime factor
     */
    public static ArrayList<ArrayList<Integer>> findAllPrimeFactor(int[]arr){
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            int val = arr[i];
            ArrayList<Integer>res = new ArrayList<>();
            for(int k = 2; k<=val; k++){
                while(val%k == 0){
                    res.add(k);
                    val = val/k;
                }
            }
            ans.add(res);

        }
        return ans;
    }

    /*
     * T.C - O(sqrt(N)*logN)
     * S.c - it depends on number of prime factors.
     */

    public static ArrayList<ArrayList<Integer>> findOptimzeAllPrimeFactor(int[]arr){
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            int val = arr[i];
            ArrayList<Integer>res = new ArrayList<>();
            for(int k = 2; k<=Math.sqrt(val); k++){
                while(val%k == 0){
                    res.add(k);
                    val = val/k;
                }
            }

            if(val != 1){
                res.add(val);
            }
            ans.add(res);

        }
        return ans;
    }
}
