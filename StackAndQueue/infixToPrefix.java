package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * Given a valid arithmetic expression in infix notation, return its equivalent prefix (Polish) notation.

The expression can contain:

lowercase letters a–z as operands,
the four binary operators + - * /,
and round parentheses ( ) that enforce evaluation order.
No whitespace appears in the input.


The input is guaranteed to be syntactically correct (parentheses are balanced, every operator has two operands, etc.).

T.c - O(N)
S.c - O(N)
 */
public class infixToPrefix {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the infix expression: ");
        String infixExpression = br.readLine();

        String ans = infixToPrefixConversion(infixExpression);

        System.out.println("The prefix expression is: "+ans);

    }

    /*
     * Same approach as infix to postfix but here we need to traverse from right to left and also check precendence should be less than top 
     * of stack and push it.
     * 
     * Another approach: 
     * First reverse the infix string and then reverse the bracket if contain.
     * the follow infix to postfix approach.
     */

    public static String infixToPrefixConversion(String str){
        String ans = "";
        Stack<Character>st = new Stack();
        for(int i = str.length()-1; i>= 0; i--){
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                ans = ch + ans;
            }
            else{
                if(ch == ')'){
                    st.push(ch);
                }
                else if(ch == '('){
                    while(!st.empty() && st.peek() != ')'){
                        ans = st.pop()+ans;
                    }
                    st.pop();
                }
                else {
                    while(!st.empty() && precendence(ch) < precendence(st.peek())){
                        ans = st.pop()+ans;
                    }
                    st.push(ch);
                }
            }
        }

        while(!st.empty()){
            ans = st.pop()+ans;
        }
        return ans;
    }

    public static int precendence(Character ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;

        }
    }
}
