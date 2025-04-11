package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicString {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the value of 2 string: ");
        String st = br.readLine();
        String t = br.readLine();

        boolean ans = checkIsomorphic(st,t);
        
        System.out.println("The string isomorphic status : "+ans);
        
    }
    public static boolean checkIsomorphic(String st, String t){
        HashMap<Character,Character>mp = new HashMap<>();
        HashSet<Character>used= new HashSet<>();
        for(int i = 0; i<st.length(); i++){
            if(!mp.containsKey(st.charAt(i))){
                if(used.contains(t.charAt(i))){
                    return false;
                }
                mp.put(st.charAt(i),t.charAt(i));
                used.add(t.charAt(i));
            }
            else{
                if(!mp.get(st.charAt(i)).equals(t.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }
}
