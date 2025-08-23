import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 */

public class SingleNumber{
    public static void main(String[]agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of the array: ");
        int n= Integer.parseInt(br.readLine());
        int[]arr = new int[n];
        System.out.println("Enter "+n+" element: ");
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0; 
        ans = findSingle(arr);
        System.out.println("The answer is: "+ans);
    }

    /*
     * Xor of same bit gives 0 and different bit gives 1.
     * therefore xor of same number gives 0. 
     */
    public static int findSingle(int[]arr){
        int val = 0; 
        for(int i = 0; i<arr.length; i++){
            val ^= arr[i];
        }
        return val;
    }
}