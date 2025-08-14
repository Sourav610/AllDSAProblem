import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * e.g 
 * 13 - binary 1 1 0 1
 * and we need to set 2nd bit as 1 
 * then    1 1 0 1
 *         1 0 1 1  - it is left shift by 2 of  1 and then its not operation
 * and we take and operation we will get 1 0 0 1 as result.
 */
public class ClearIthBit {
    public static void main(String[]args) throws IOException{
        int num;
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        System.out.println("Enter a number: ");
        num = Integer.parseInt(br.readLine());
        System.out.println("Enter the bit number you want to check: ");
        int bit = Integer.parseInt(br.readLine());

        int ans = (num&(~(1<<bit)));
        System.out.println("The result after setting bit is: "+ans);
    }
}
