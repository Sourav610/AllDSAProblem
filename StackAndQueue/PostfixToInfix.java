package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a postfix expression: ");
        String postfixExpression = br.readLine();

        String ans = postfixToInfix(postfixExpression);

        System.out.println("Enter the infix expression is: "+ans);
    }

    public static String postfixToInfix(String str){
        Stack<String>st = new Stack<>();
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(ch+"");
            }
            else{
                String st1 = st.pop();
                String st2 = st.pop();
                String res = '('+st2+ch+st1 + ')';
                st.push(res);
            }
        }

        return st.pop();
    }
}
