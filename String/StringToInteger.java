package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringToInteger {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the value of string: ");
        String st = br.readLine();

        int ans;
        ans = convertToInt(st);

        System.out.println("The converted string to int is:"+ans);
    }

    public static int convertToInt(String str){
        str = str.trim();

        int i = 0; 
        int sign = 1;
        long ans = 0;
        if(str.charAt(i) == '-'){
            sign = -1;
            i++;
        }
        else if(str.charAt(i) == '+'){
            i++;
        }

        while(i<str.length()){
            char c = str.charAt(i);
            if( c <'0' || c > '9') break;
             ans= ans*10 + str.charAt(i) - '0';
             if(ans*sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
             if(ans*sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
             i++;
        }

        return (int)ans*sign;
    }
}
