package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReverseWordsInString {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the value of string: ");
        String st = br.readLine();

        String ans ="";
        // ans =  optimizeReverseWord(st);
        ans = reverseWord(st);

        
        System.out.println("The string after removing outermost parenthesis is: "+ans);
        
    }

    public static String optimizeReverseWord(String st){
        int i = 0, j = st.length()-1;
        String temp="";
        String ans="";
        while(i<=j){
            char s = st.charAt(i);
            if(s == ' '){
                if(ans != ""){
                    if(temp != ""){
                        ans = temp+" "+ans;
                    }
                    
                }
                else{
                    ans = temp;
                }
                temp = "";
            }
            else{
                temp += s;
            }
            i++;
        }

        if(temp!=""){
            if(ans!=""){
                ans = temp+" "+ans;
            }
            else{
                ans = temp;
            }
        }
        
        return ans;
    }

    public static String reverseWord(String str){
        Stack<String>st = new Stack<>();
        String temp="";
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == ' '){
                if(temp != ""){
                    st.push(temp);
                    temp="";
                }
            }
            else{
                temp += str.charAt(i);
            }
        }

        String ans="";
        while(st.size() != 1){
            ans = st.peek()+" ";
            st.pop();
        }

        ans += st.peek();
        return ans;
    }
}
