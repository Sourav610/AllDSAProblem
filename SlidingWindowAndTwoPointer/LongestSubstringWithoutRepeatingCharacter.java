package SlidingWindowAndTwoPointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


/*
Given a string s, find the length of the longest substring without duplicate characters.
 */
public class LongestSubstringWithoutRepeatingCharacter{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Eneter a string of character: ");
        String str = br.readLine();

        int ans = 0;
        // ans = findLongestSubstr(str);
        ans = findLongestSubstr(str);
        System.out.println("The longest substring is: "+ans);
    }

    //first run one loop to store the character with count. Inside that loop check if any charcter count is greater than 1 then move the j index
    // and update the map until the character count reduced to one.
    //T.C - O(n*n);
    //S.C - O(n);

    public static int findLongestSubstr(String str){
        Map<Character, Integer>mp = new HashMap();
        int maxSize = 0;
        int j = 0;
        for(int i = 0; i<str.length(); i++){
            Character ch = str.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            while(mp.get(ch) > 1){
                Character temp = str.charAt(j);
                mp.put(temp,mp.getOrDefault(temp,0)-1);
                j++;
            }
            maxSize = Math.max(maxSize,i-j+1);

        }
        return maxSize;
    }


    /*
    Approach: keep two pointer first move one by one and store the character with its index+1, and second pointer will move only when some
    character found twice then update the second pointer to value of that character:

    T.C - O(n)
    S.c - O(n)
     */
    public static int findLongestSubstrOptimize(String str){
        int maxSize = 0; 
        int j = 0; 
        Map<Character,Integer>mp = new HashMap();

        for(int i = 0; i<str.length(); i++){
            Character ch = str.charAt(i);
            if(mp.get(ch) > 1){
                j = Math.max(mp.get(ch),j);
            }
            maxSize = Math.max(maxSize,i-j+1);
            mp.put(ch,mp.getOrDefault(ch, i+1));
        }
        return maxSize;
    }
}