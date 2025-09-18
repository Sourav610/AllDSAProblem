package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;


/*
 * Given an infix expression, Your task is to convert the given infix expression to a postfix expression.

Examples:

Example 1:
Input: a+b*(c^d-e)^(f+g*h)-i
Output: abcd^e-fgh*+^*+i-
Explanation: Infix to postfix

Example 2:
Input: (p+q)*(m-n)
Output: pq+mn-*
Explanation: Infix to postfix
 */


public class InfixToPostfixConversion{
    public static void main(String []args){
        String str="";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an Math expression: ");
        str = sc.next();

        String ans = infixToPostfix(str);
        System.out.println("The postfix expression is: "+ans);

    }

    /*
     * Approach: To convert Infix expression to Postfix
1. Scan the infix expression from left to right. 

2. If the scanned character is an operand, Print it. 

3. Else, 

If the precedence of the scanned operator is greater than the precedence of the operator in the stack or the stack is empty or the stack contains a ‘(‘, push the character into the stack. 
Else, Pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator. After doing that Push the scanned operator to the stack. 
4. If the scanned character is an ‘(‘, push it into the stack. 

5. If the scanned character is an ‘)’, pop the stack and output it until a ‘(‘ is encountered, and discard both the parenthesis. 

6. Repeat steps 2-5 until the entire infix expression is scanned. 

7. Print the output.

8. Pop and print the output from the stack until it is not empty.


==> for checking precedence we will create precendence method as shown below where ^ > * or / > + or -



     */

    public static String infixToPostfix(String str){
        String ans = "";
        Stack<Character>st = new Stack();
        for(Character ch: str.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                ans += ch;
            }
            else if(ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
                while(!st.empty() && st.peek() != '('){
                    ans += st.pop();
                }
                st.pop();
            }
            else{
                while(!st.empty() && precedence(ch) <= precedence(st.peek())){
                    ans += st.pop();
                }
                st.push(ch);
            }
        }

        while(!st.empty()){
            if(st.peek() == '('){
                return "Invalid Expression";
            }
            ans += st.pop();
        }
        return ans;
    }

    public static int precedence(char c){
        switch(c){
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