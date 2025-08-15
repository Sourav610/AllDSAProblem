import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * every binary of a odd number contain one set bit at last
 * and when we take and operation with 1 we get 1. 
 * Therefore N&1 == 1 (if number is odd); and this is little bit faster
 * than (num%2 == 1) check
 * 
 * another approach
 * we use N&N-1 for removing the right most bit 
 * so consider e.g 84 - 1 0 1 0 1 0 0 
 *              &  83 - 1 0 1 0 0 1 1
 *                      1 0 1 0 0 0 0 - it become N
 * and again from result we will take N&N-1
 *                      1 0 1 0 0 0 0
 *                      1 0 0 1 1 1 1
 *  We will get         1 0 0 0 0 0 0 - it become N
 * 
 * and same if we again take N&N-1 we will get 0 as final result so in this way we 
 * can count number of set bit.
 * 
 * same way in binary search ((low+high)/2) is slower than and same as ((low+high)>>1)
 * 
 * in c++ one inbuilt function to count set bit is --builtin_popcount(n);
 */
public class CountSetBit {
    public static void main(String[]args) throws IOException{
        int num;
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        System.out.println("Enter a number: ");
        num = Integer.parseInt(br.readLine());

        int count = 0; 
        // while (num > 1){
        //     if(num%2 == 1){
        //         count++;
        //     }
        //     num = num/2;
        // }

        // while(num>1){
        //     count += num&1;
        //     num = num >>1;
        // }

        //second approch using N&(N-1)
        while(num != 0){
            num = num&(num-1);
            count++;
        }

        System.out.println("The number of set bit is: "+count);
    }

    /*
     * T. C - O(no. of sets) - for largest int O(31) - so it is better
     * T.C - in modulo - O(log2 N) - if largest int O(31)
     */

}
