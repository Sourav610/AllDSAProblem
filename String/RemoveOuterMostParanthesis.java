package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveOuterMostParanthesis {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the value of string: ");
        String st = br.readLine();

        String ans = removeParanthesis(st);
        
        System.out.println("The string after removing outermost parenthesis is: "+ans);
        
    }

    public static String removeParanthesis(String str){
        int count = 0;
        String ans = "";
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == ')'){
                count--;
                if(count>0){
                    ans += str.charAt(i);
                }
            }
            else{
                if(count > 0){
                    ans += str.charAt(i);
                }
                count++;
            }
        }
        return ans;
    }
}
