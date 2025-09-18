package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 
 * You are given a valid arithmetic expression in prefix notation. Your task is to convert it into a fully parenthesized infix expression.

Prefix notation (also known as Polish notation) places the operator before its operands. In contrast, infix notation places the operator between operands.

Your goal is to convert the prefix expression into a valid fully parenthesized infix expression.

Ex-

Input: expression = "+ab"

Output: "(a+b)"

Input: expression = "*+ab-cd"

Output: "((a+b)*(c-d))"


 */
public class PrefixToInfix {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter an prefix operation: ");
        String prefixString = br.readLine();

        String ans = prefixToInfix(prefixString);
        System.out.println("The infix string is: "+ans);
        
    }

    /*
     * Aproach: Move from right to left.
     * Then if it is a operand push to stack 
     * if it is operator pop two operand from stack and add the operator in between them and push back to stack again.
     * lastly return the top of stack.
     */

    public static String prefixToInfix(String str){
        Stack<String>st = new Stack();
        for(int i = str.length()-1; i>=0; i--){
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(ch+"");
            }
            else{
                if(st.empty()){
                    return "Invalid Expression";
                }
                String ele1 = st.pop();
                String ele2 = st.pop();
                String res = '(' + ele1 + str.charAt(i) +  ele2 + ')';
                st.push(res);
            }
        }
        return st.peek();
    }
}
