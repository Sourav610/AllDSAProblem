package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestOddNumberInString {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the value of string: ");
        String st = br.readLine();

        String ans = largestOddNum(st);
        
        System.out.println("The string after removing outermost parenthesis is: "+ans);
        
    }

    public static String largestOddNum(String str){
        for(int i = str.length()-1; i>=0; i--){
            int val = str.charAt(i) -'0';
            if(val%2 != 0){
                return str.substring(0, i+1);
            }
        }
        return "";
    }
}
