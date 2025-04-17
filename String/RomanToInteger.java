package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the value of string: ");
        String st = br.readLine();

        int ans;
        ans = convertToInt(st);

        System.out.println("The converted string to int is:"+ans);
    }

    public static int convertToInt(String str){
        HashMap<Character,Integer>mp = new HashMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('M',1000);
        mp.put('D',500);
        mp.put('C',100);

        int ans=0;
        for(int i = 1; i<str.length(); i++){
            if(mp.get(str.charAt(i-1)) < mp.get(str.charAt(i))){
                ans -= mp.get(str.charAt(i-1));
            }
            else{
                ans += mp.get(str.charAt(i-1));
            }
        }

        ans = ans + mp.get(str.charAt(str.length()-1));
        return ans;

    }
}
