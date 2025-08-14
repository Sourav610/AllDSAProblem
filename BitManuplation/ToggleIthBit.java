import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * e.g 
 * 9 - binary 1 0 0 1
 * and we need to set 2nd bit as 1 if it 0 or 0 if it is 1
 * so for this we will use XOR operator 
 * then    1 0 0 1
 *         0 1 0 0  - it is left shift by 2 of 1
 * and we take XOR operation we will get 1 1 0 1 as result.
 */
public class ToggleIthBit {
    public static void main(String[]args) throws IOException{
        int num;
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        System.out.println("Enter a number: ");
        num = Integer.parseInt(br.readLine());
        System.out.println("Enter the bit number you want to check: ");
        int bit = Integer.parseInt(br.readLine());

        int ans = (num^(1<<bit));
        System.out.println("The result after setting bit is: "+ans);
    }
}
