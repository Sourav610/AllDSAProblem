import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * for optimize approach we can user left shift and right shift operator
 * 
 * left shift(<<) - first take left shift of 1 by the bit number(ith bit);
 * and then take and opearation with n. if it value is grater or equal to 1 then true else false;
 * - if(n &(1 << i) != 0) then true else false
 * 
 * Right shift (>>) - first take right shift of n by the bit number and then
 * take and operation with 1 if the result is 1 then true else false
 * 
 *  if((n >> i) & 1) == 0) return false else true;
 */
public class CheckIthBit{
    public static void main(String []args) throws IOException{
        int num;
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        System.out.println("Enter a number: ");
        num = Integer.parseInt(br.readLine());
        System.out.println("Enter the bit number you want to check: ");
        int bit = Integer.parseInt(br.readLine());

        // String binaryRep = "";
        // while(num != 1){
        //     if(num%2 == 1){
        //         binaryRep += '1';
        //     }
        //     else{
        //         binaryRep += '0';
        //     }
        //     num = num/2;
        // }
        // binaryRep += '1';

        // StringBuilder sb  = new StringBuilder(binaryRep);
        // sb.reverse();
        // System.out.println(sb);
        // if(binaryRep.charAt(bit) == '1'){
        //     System.out.println(true);
        // }
        // else{
        //     System.out.println(false);
        // }



        if((num & (1 << bit)) != 0){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }


    }
}