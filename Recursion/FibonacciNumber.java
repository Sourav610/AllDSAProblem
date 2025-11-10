

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciNumber {
    public static void main(String []args) throws IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter any number: ");
        n = Integer.parseInt(br.readLine());
        // printFibonacci(n);
    //     System.out.print(0+" ");
    //    System.out.print(1+" ");
        int []arr = new int[n+1];
        for(int i = 0; i<=n; i++){
            arr[i] = 0;
        }
        System.out.print(recursiveFibonacci(n, arr));
        
    }

    // public static void printFibonacci(int n){
    //    int i = 0, j = 1, k;
    //    System.out.print(i+" ");
    //    System.out.print(j+" ");
    //    for(int l = 2; l<n; l++){
    //         k = i+j;
    //         i = j;
    //         j = k;
           
    //         System.out.print(k+" ");
    //    }
    
    // }

    public static int recursiveFibonacci(int n, int []arr){
        if(n<=1){
            return n;
        }
        if(arr[n] != 0)return arr[n];
        int sum = recursiveFibonacci(n-1, arr) + recursiveFibonacci(n-2, arr);
        arr[n] = sum;
        return sum;
    }

}
