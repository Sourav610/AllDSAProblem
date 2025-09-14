package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 */

/*
 * T.C - O(n)
 * S.C - O(n) as using stack
 * 
 * stack operation take O(1) time
 */

public class ValidParentheses {
    public static void main(String[]args) throws IOException{
        String str;
        System.out.println("Enter a string of brackets: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        boolean check = isValid(str);
        System.out.println("The String is valid: "+check);
    }  

    public static boolean isValid(String str){
        Stack<Character> st = new Stack<>();
        for(char it: str.toCharArray()){
            if(it == '(' || it == '{' || it == '['){
                st.push(it);
            }
            else{
                if(st.isEmpty()) return false;
                char ch = st.pop();
                if((it == ')' && ch == '(') || (it == '}' && ch == '{') || (it == ']' && ch == '[')){
                    continue;
                }
                else return false;
            }
        }
        return st.isEmpty();
    }
}
