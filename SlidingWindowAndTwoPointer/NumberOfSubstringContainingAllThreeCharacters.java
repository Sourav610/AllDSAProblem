package SlidingWindowAndTwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfSubstringContainingAllThreeCharacters {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a String of character: ");
        String arr;
        arr = br.readLine();
        System.out.println("Enter the value of k: ");
        int ans = 0;
        // ans = calculateTotalSubstring(arr);
        ans = calculateOptimizeTotalSubstring(arr);
        System.out.println("The total substring are: "+ans);
    }

    /*
     Brute Force approach:
     T.C - O(n*n)
     S.C - O(1)
    */

    public static int calculateTotalSubstring(String arr){
        int count = 0;
        for(int i=0; i<arr.length(); i++){
            int ele[] = new int[3];
            for(int j = i; j<arr.length(); j++){
                int ind = arr.charAt(j)-'a';
                ele[ind] = 1;
                if((ele[0]+ele[1]+ele[2]) == 3){
                    count++;
                }
            }
        }
        return count;
    }

    /*
        Optimize approach: from the character we find that once we got all three character then whatever character we got next
        it will be consider subarray. And the subarray will only count when all three character there. so we will store the index
        of all three character in a array of size 3 and will take the min of all three index value and add 1 to it as shown in ex:

        abcabc - here a = 0, b= 1, c= 2, so till first c number of subarray is 1 which is equal to min(a,b,c)+1;

        T.c: O(n);
        S.C : O(1)
    */

    public static int calculateOptimizeTotalSubstring(String arr){
        int count = 0;
        int ele[] = new int[3];
        for(int i = 0; i<3; i++){
            ele[i] = -1;
        }
        for(int i = 0; i<arr.length(); i++){
            int ind = arr.charAt(i)-'a';
            ele[ind] = i;
            count += Math.min(ele[0],Math.min(ele[1],ele[2]))+1;
        }
        return count;
    }
}
