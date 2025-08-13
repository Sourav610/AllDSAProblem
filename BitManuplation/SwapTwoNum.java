import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * swaping without using third variable - we will user xor operator
 * a = a ^ b
 * b = a ^b = a ^ b ^ b = a  : replace a with value and xor of same give 0
 * a = a ^ b = a ^ b ^ b = a ^ b ^ a = b
 * 
 * another approach
 * int a = 5, b = 10;

    a = a + b; // a = 15
    b = a - b; // b = 5
    a = a - b; // a = 10
 */
public class SwapTwoNum {
     public static void main(String []args) throws IOException{
        int num1, num2;
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        System.out.println("Enter a number: ");
        num1 = Integer.parseInt(br.readLine());
        System.out.println("Enter another number: ");
        num2 = Integer.parseInt(br.readLine());

        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;

        System.out.println("The number after swap is : ");
        System.out.println(num1);
        System.out.println(num2);
     
    }
}
