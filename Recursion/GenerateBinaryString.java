package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class GenerateBinaryString {
    public static void main(String args[]) throws NumberFormatException, IOException{
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number: ");
        n = Integer.parseInt(br.readLine());
        List<String> res = generateBinaryStrings(n);
        for (String s : res) {
            System.out.println(s);
        }
    }

    public static List<String> generateBinaryStrings(int n){
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < n; j++) {
            s.append('0');
        }
            
        List<String> ans = new ArrayList<>();
            
        stringRecur(0, s, ans);
            
        return ans;
    }
    
    public static void stringRecur(int i, StringBuilder s, List<String>ans){
        if(i >= s.length()){
            ans.add(s.toString());
            return;
        }
    
        stringRecur(i+1, s, ans);
    
        s.setCharAt(i, '1');
    
        stringRecur(i+2, s, ans);
    
        s.setCharAt(i,'0');
    }
    
}

