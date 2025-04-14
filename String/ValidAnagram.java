package String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the value of 2 string: ");
        String st = br.readLine();
        String t = br.readLine();

        boolean ans;
        // ans = checkAnagramString(st,t);
        // ans = optimizedAnagramString(st,t);
        ans = usingArray(st,t);
        
        System.out.println("The string Anagram status : "+ans);
        
    }

    public static boolean checkAnagramString(String st, String t){
        if(st.length() != t.length()){
            return false;
        }
        char[]str1 = st.toCharArray();
        char[]str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        st = new String(str1);
        t = new String(str2);
        return st.equals(t);
    }

    public static boolean optimizedAnagramString(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }

        HashMap<Character,Integer>mp = new HashMap<>();
        for(int i = 0; i<str1.length(); i++){
             mp.put(str1.charAt(i),mp.getOrDefault(str1.charAt(i), 0)+1);
             mp.put(str2.charAt(i),mp.getOrDefault(str2.charAt(i), 0)-1);
        }


        for(char c:mp.keySet()){
            if(mp.get(c) != 0){
                return false;
            }
        }
        return true;

    }

    public static boolean usingArray(String st1,String st2){
        int[] alpha = new int[26];
        for(int i = 0; i<st1.length(); i++){
            alpha[st1.charAt(i) -'a']++;
            alpha[st2.charAt(i)-'a']--;
        }

        for(int i : alpha){
            if (i != 0){
                return false;
            }
        }
        return true;
    }

}
