import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveLastSetBit {
    /*
    for this question we only need to remove the last set bit (that is rightMost 1)
 * e.g 
 *  16 - 1 0 0 0   40 - 1 0 1 0 0 0     84 - 1 0 1 0 1 0 0
 *  15 - 0 1 1 1   39 - 1 0 0 1 1 1     83 - 1 0 1 0 0 1 1
 * from the above data we can observe that when we reduce any number by 1
 * its binary equivalent change after the last set bit(rightMost);
 * 
 * so we can conclude for removing last set bit we can take N & N-1;
 *  let n = 16 then n & n-1 == 1 0 0 0
 *                             0 1 1 1 
 *                           = 0 0 0 0  which is the answer
 */
public static void main(String[]args) throws IOException{
        int num;
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        System.out.println("Enter a number: ");
        num = Integer.parseInt(br.readLine());

        int ans = (num & num-1);
        System.out.println("The result after setting bit is: "+ans);
    }

}
