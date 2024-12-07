package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckHCFOrGCD {
    public static void main(String []args) throws IOException{
        int n1,n2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter first number: ");
        n1 = Integer.parseInt(br.readLine());
        System.out.println("Enter second number: ");
        n2 = Integer.parseInt(br.readLine());

        checkHCF(n1,n2);
    }

    public static void checkHCF(int a, int b){

        while(a != b){
            if(a> b){
                a = a-b;
            }
            else{
                b = b-a;
            }
        }
        
        System.out.println("The hcf is: "+a);
    }

}
