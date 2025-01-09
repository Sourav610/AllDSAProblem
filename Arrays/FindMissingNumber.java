package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class FindMissingNumber {
    public static void main(String args[]) throws IOException{
        int n; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        System.out.print("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // MissingElementApproach1(arr);
        // MissingElementApproach2(arr);
        MissingElementApproach3(arr);
    }

    public static void MissingElementApproach1(int[]arr){
        HashMap<Integer,Integer>mp = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            mp.put(arr[i],i);
        }

        for(int i = 0; i<arr.length; i++){
            if(mp.get(i) == null){
                System.out.println("The missing number is: "+i);
                break;
            }
        }

    }

    public static void MissingElementApproach2(int[]arr){
        int n = arr.length;
        int originalSum = (n*(n+1))/2;
        int newSum2 = 0;
        for(int i = 0; i<n; i++){
            newSum2 += arr[i];
        }
        //sum of n natural no n*(n+2)/n if a single number is missing , just substract it to sum of array.
        System.out.println("The missing number is: "+(originalSum-newSum2));
    }

    /*
     * Two important properties of XOR are the following:

XOR of two same numbers is always 0 i.e. a ^ a = 0. ←Property 1.
XOR of a number with 0 will result in the number itself i.e. 0 ^ a = a.  ←Property 2

Now, let’s XOR all the numbers between 1 to N.
xor1 = 1^2^.......^N

Let’s XOR all the numbers in the given array.
xor2 = 1^2^......^N (contains all the numbers except the missing one).

Now, if we again perform XOR between xor1 and xor2, we will get:
xor1 ^ xor2 = (1^1)^(2^2)^........^(missing Number)^.....^(N^N)

Here all the numbers except the missing number will form a pair and each pair will result in 0 according to the XOR property. The result will be = 0 ^ (missing number) = missing number (according to property 2).

So, if we perform the XOR of the numbers 1 to N with the XOR of the array elements, we will be left with the missing number.
     */
    public static void MissingElementApproach3(int[]arr){
        int n = arr.length;
       int xor1 = 0, xor2 = 0;
       for(int i = 0;i<n; i++){
        xor1 ^= i;
        xor2 ^= arr[i];
       }

       xor1 = xor1^n;

        System.out.println("The missing number is: "+(xor1^xor2));
    }
}
