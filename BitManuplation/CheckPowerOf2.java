import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Question: - check that given number is power of 2 or not.
 * eg. 16 - power of 2 
 *     13 - not power of 2
 * 
 * ans:
 * for this first we can convert to binary and if there exist only 1 set bit
 * then it is power of 2 else not.
 * 
 * other approach N & (N-1) == 0 then true 
 * e.g.
 *  16 - 1 0 0 0
 *  15 - 0 1 1 1  and if we take and operation of both we will get 0
 * 
 */
public class CheckPowerOf2 {
    public static void main(String[]args) throws IOException{
        int num;
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        System.out.println("Enter a number: ");
        num = Integer.parseInt(br.readLine());
        
        //Brute force
        // String ans = "";
        // int count = 0;
        // while(num != 1){
        //     if(num%2 == 1){
        //         ans += '1';
        //         count++;
        //     }
        //     else{
        //         ans += '0';
        //     }
        //     num = num/2;
        // }
        boolean result= true;

        // num += '1';
        // if(count > 1){
        //     result = false;
        // }

        if((num & (num-1)) != 0){
            result = false;
        }

        System.out.println("The result for checking power is: "+result);
    }
}
