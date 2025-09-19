package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * You are given a valid prefix expression consisting of binary operators and single-character operands. Your task is to convert it into a valid postfix expression.

Prefix (Polish) notation places the operator before operands.

Postfix (Reverse Polish) notation places the operator after operands.

 */
public class PrefixToPostfix {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a prefix expression: ");
        String prefixExpression = br.readLine();

        String postfixExpression = prefixToPostfix(prefixExpression);

        System.out.println("The postfix expression is: "+postfixExpression);
    }

    /*
     * Approach:
     * Move from right to left
     * if it is an operand push to stack
     * else if it is an operator pop two element from stack and create a postfix string with op1 +op2+operator and push back to stack
     * 
     * lastly iterate through stack and form the result string from element.
     * 
     */

    public static String prefixToPostfix(String str){
        Stack<String>st = new Stack();
        for(int i = str.length()-1; i>= 0; i--){
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(ch+"");
            }
            else{
                String ele1 = st.pop();
                String ele2 = st.pop();
                String res = ele1+ele2+ch;
                st.push(res);
            }
        }

        String ans = "";
        while(!st.empty()){
            ans += st.pop();
        }
        return ans;
    }
}
