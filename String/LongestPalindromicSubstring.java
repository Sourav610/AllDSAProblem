package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindromicSubstring{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the value of string: ");
        String st = br.readLine();

        String ans="";

        ans = findLongestPalindromicSubstring(st);

        System.out.println("The length of substring is:"+ans);
    }

    public static String findLongestPalindromicSubstring(String st){
        String ans="";
        for(int i = 0; i<st.length(); i++){
            String odd = expand(i,i,st);
            if(odd.length() > ans.length()){
                ans = odd;
            }

            String even = expand(i,i+1,st);
            if(even.length() > ans.length()){
                ans = even;
            }
        }
        return ans;
    }

    public static String expand(int i, int j, String s){
        int left = i, right = j;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return s.substring(left+1, right);
    }
}
