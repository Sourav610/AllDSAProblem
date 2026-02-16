package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

import javax.swing.text.html.HTMLDocument.BlockElement;

/*
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
*/
public class ValidParenthesisString {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a string of parenthesis: ");
        String str = br.readLine();

        boolean isValid;
        // isValid = checkValidRecursive(0,str,0);
        // int[][]memo = new int[str.length()+1][str.length()+1];
        // for(int[]row: memo){
        //     Arrays.fill(row,-1);
        // }
        // isValid = checkValidRecursiveMemo(0, str, 0, memo);
        // isValid = checkValid(str);
        isValid = checkValidRecursiveBottomUp(str);
        System.out.println("The string is valid: "+isValid);
    }

    //Brute force using recursion: T.C - exponential
    public static boolean checkValidRecursive(int i,String str,int count){
        if(i == str.length()){
            if(count == 0){
                return true;
            }
            return false;
        }   
        if(count< 0){
            return false;
        }

        if(str.charAt(i) == '('){
            if(checkValidRecursive(i+1,str,count+1))return true;
        }
        else if(str.charAt(i) == ')'){
            if(checkValidRecursive(i+1,str,count-1))return true;
        }
        else{
            if(checkValidRecursive(i+1, str, count+1))return true;
            if(checkValidRecursive(i+1, str, count-1)) return true;
            if(checkValidRecursive(i+1, str, count)) return true;
        }
        return false;
    }


    /*
     Memoizatio approach:
     T.C - O(n*n);
     S.C - O(n*n);
    */

    public static boolean checkValidRecursiveMemo(int i,String str,int count,int[][]memo){
        if(i == str.length()){
            if(count == 0){
                return true;
            }
            return false;
        }  
        
        if(count<0){
            return false;
        }
        if(memo[i][count] != -1){
            return memo[i][count] == 1;
        }

        boolean isValid = false;

        if(str.charAt(i) == '('){
           isValid = checkValidRecursive(i+1,str,count+1);
        }
        else if(str.charAt(i) == ')'){
            isValid = checkValidRecursive(i+1,str,count-1);
        }
        else{
            boolean b1 = checkValidRecursive(i+1, str, count+1);
            boolean b2 = checkValidRecursive(i+1, str, count-1);
            boolean b3 = checkValidRecursive(i+1, str, count);
            isValid = b1||b2||b3;
        }
        memo[i][count] = isValid?1:0;
        return isValid;
    }


    /*
        Bottom up Approach:
        T.C - O(n*n);
        S.C - O(n*n);
    */
    public static boolean checkValidRecursiveBottomUp(String str){
        boolean[][]dp= new boolean[str.length()+1][str.length()+1];
        for(boolean[]d:dp){
            Arrays.fill(d,false);
        }
        int n = str.length();

        dp[n][0] = true;

        for(int i = n-1; i>= 0; i--){
            for(int j = 0; j<n;j++){
                boolean isValid = false;
                if(str.charAt(i) == '('){
                    isValid = dp[i+1][j+1];
                }
                else if(str.charAt(i) == ')'){
                    if(j>0){
                        isValid = dp[i+1][j-1];
                    }
                }
                else{
                    boolean b1 = dp[i+1][j+1];
                    boolean b2 = false;
                    if(j>0){
                        b2 = dp[i+1][j+1];
                    }
                    boolean b3 = dp[i+1][j];
                    isValid = b1||b2||b3;
                }
                dp[i][j] = isValid;
            }
        }
        
        return dp[0][0];
    }

    /*
        Using Two Stack:

        Algorithm
        Initialize two stacks: openBrackets to store indices of open brackets '(', and asterisks to store indices
         of asterisks '*'.
        Iterate through the string s character by character:
        If the current character is '(', push its index onto the openBrackets stack.
        If the current character is '*', push its index onto the asterisks stack.
        If the current character is ')':
        If openBrackets is not empty, pop an element from it (removing the matching open bracket).
        If asterisks is not empty, pop an element from asterisks (using an asterisk to balance the closing bracket).
        If neither an open bracket nor an asterisk is available, return false.
        After iterating through the entire string, check if any remaining open brackets and asterisks can 
        balance each other:
        While both openBrackets and asterisks are not empty:
        If the top element of openBrackets (representing an open bracket index) is greater than the top element 
        of asterisks (representing an asterisk index), it means the open bracket appears after the asterisk,
         which cannot be balanced, so return false.
        Otherwise, pop elements from both openBrackets and asterisks stacks (matching an open bracket with an asterisk).
        If after the above step, openBrackets is empty, it means all open brackets have been matched or balanced,
         so return true. Otherwise, return false (unmatched open brackets are remaining).

         T.C - O(n);
         S.C - O(n);
    */

        public boolean checkValidString(String s) {
        // Stacks to store indices of open brackets and asterisks
        Stack<Integer> openBrackets = new Stack < > ();
        Stack<Integer> asterisks = new Stack < > ();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If current character is an open bracket, push its index onto the stack
            if (ch == '(') {
                openBrackets.push(i);
            }
            // If current character is an asterisk, push its index onto the stack
            else if (ch == '*') {
                asterisks.push(i);
                // current character is a closing bracket ')'
            } else {
                // If there are open brackets available, use them to balance the closing bracket
                if (!openBrackets.empty()) {
                    openBrackets.pop();
                // If no open brackets are available, use an asterisk to balance the closing bracket
                } else if (!asterisks.isEmpty()) {
                    asterisks.pop();
                } else {
                    return false;
                }
            }
        }

        // Check if there are remaining open brackets and asterisks that can balance them
        while (!openBrackets.isEmpty() && !asterisks.isEmpty()) {
            // If an open bracket appears after an asterisk, it cannot be balanced, return false
            if (openBrackets.pop() > asterisks.pop()) {
                return false; // '*' before '(' which cannot be balanced.
            }
        }

        // If all open brackets are matched and there are no unmatched open brackets left, return true
        return openBrackets.isEmpty();
    }


    /*
        Two Pointer apporach:
        Points to remember - 
        high = best-case open brackets

        low = worst-case open brackets

        Keep the possible open count in a range

        If range collapses (high < 0) → impossible

        At end, zero must be in range (low == 0)

        T.C - O(n)
        S.C - O(1);
    */
    public static boolean checkValid(String s){
        int low =0;
        int high =0;
        for(int i = 0; i<s.length() i++){
            if(s.charAt(i)== '('){
                low++;
                high++;
            }
            else if(s.charAt(i) == ')'){
                low--;
                high--;
            }
            else{
                low--;
                high++;
            }
            if(high<0){
                return false;
            }
            if(low < 0){
                low = 0;
            }
        }


        if(low == 0){
            return true;
        }
        return false;
    }
}
