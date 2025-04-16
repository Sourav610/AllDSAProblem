package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MaximumNestingDepthOfParentheses {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the value of string: ");
        String st = br.readLine();

        int ans;
        // ans = maximumDepth(st);
        ans = usingStackMaximumDepth(st);
        
        System.out.println("The string after removing outermost parenthesis is: "+ans);
        
    }

    public static int maximumDepth(String str){
        int maxDepth = 0;
        int brackets= 0;

        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                brackets++;
            }
            else if(str.charAt(i) == ')'){
                brackets--;
            }
            maxDepth  = Math.max(maxDepth,brackets);
        }

        return maxDepth;
    }

    public static int usingStackMaximumDepth(String str){
        int ans = 0;
        Stack<Character>st = new Stack<Character>();
        for(Character c : str.toCharArray()){
            if(c=='('){
                st.push(c);
            }
            else if(c==')'){
                st.pop();
            }

            ans = Math.max(st.size(),ans);
        }
        return ans;
    }
}
