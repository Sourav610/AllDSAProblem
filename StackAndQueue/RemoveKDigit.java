package StackAndQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class RemoveKDigit {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a string of number: ");
        String num = br.readLine();

        System.out.println("Enter the kth value");
        int k = Integer.parseInt(br.readLine());

        String ans ="";
        ans = findNumAfterRemoveK(num,k);
        System.out.println("The final num is: "+ans );
    }
    /*
     * T.C - O(3n)+ (k)
     * S.c - O(n)+O(n)
     */

    public static String findNumAfterRemoveK(String num,int k){
        Stack<Integer>st = new Stack();

        if(num.length() == k){
            return "0";
        }
        char[] arr = num.toCharArray();
        for(int i = 0; i<arr.length; i++){
            while(!st.empty() && (arr[st.peek()] -'0') > (arr[i]-'0') && k != 0){
                st.pop();
                k--;
            }
            st.push(i);
        }

        while(k != 0){
            st.pop();
            k--;
        }

        

        String ans="";
        while(!st.empty()){
            ans += arr[st.pop()];
        }
        System.out.println(ans);

        int l = ans.length()-1;
        if(ans.length() > 0){
            while(ans.charAt(l) == '0'){
                l--;
            }
        }
        ans = ans.substring(0, l+1);
        StringBuilder sb = new StringBuilder();
        sb.append(ans);
        sb.reverse();

        ans = sb.toString();
        return ans;
    }
}
