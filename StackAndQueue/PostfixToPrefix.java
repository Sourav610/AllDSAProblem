package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * You are given a valid postfix expression as a string, where:

Operands are single lowercase English letters ('a' to 'z')
Operators are binary: '+', '-', '*', '/'
The expression contains no spaces and is guaranteed to be valid.


Write a function to convert the postfix expression into a prefix expression, also as a string without spaces.
 */
public class PostfixToPrefix {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a postfix expression: ");
        String postFix = br.readLine();

        String ans = postfixToPrefix(postFix);
        System.out.println("The prefix conversion is: "+ans);
    }

    public static String postfixToPrefix(String str){
        Stack<String>st = new Stack();
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(ch+"");
            }
            else{
                String ele1 = st.pop();
                String ele2 = st.pop();
                String res = ch + ele2 + ele1;
                st.push(res);
            }
        }

        String ans = "";
        for(String ele: st){
            ans += ele;
        }  
        return ans;
    }
}
